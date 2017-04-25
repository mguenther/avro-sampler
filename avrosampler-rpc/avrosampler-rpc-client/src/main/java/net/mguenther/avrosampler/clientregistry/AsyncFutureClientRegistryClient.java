package net.mguenther.avrosampler.clientregistry;

import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
public class AsyncFutureClientRegistryClient {

    private final NettyTransceiver underlyingClient;

    private final ClientRegistry proxy;

    private final ExecutorService executorService;

    public AsyncFutureClientRegistryClient(final int serverPort) throws IOException {
        this(serverPort, ForkJoinPool.commonPool());
    }

    public AsyncFutureClientRegistryClient(final int serverPort, final ExecutorService executorService) throws IOException {
        this.underlyingClient = new NettyTransceiver(new InetSocketAddress(serverPort));
        this.proxy = SpecificRequestor.getClient(ClientRegistry.class, underlyingClient);
        this.executorService = executorService;
    }

    public void close() {
        if (underlyingClient != null) {
            underlyingClient.close();
        }
    }

    public CompletableFuture<String> login(final String clientId, final String clientName) {

        return CompletableFuture.supplyAsync(() -> {
            final LoginRequest loginRequest = LoginRequest
                    .newBuilder()
                    .setClientId(clientId)
                    .setClientName(clientName)
                    .build();
            try {
                return proxy.login(loginRequest);
            } catch (Exception e) { // we wont go into detail about ServiceErrors at this point
                throw new CompletionException(e);
            }
        }, executorService);
    }

    public CompletableFuture<String> logout(final String clientId) {

        return CompletableFuture.supplyAsync(() -> {
            final LogoutRequest logoutRequest = LogoutRequest
                    .newBuilder()
                    .setClientId(clientId)
                    .build();
            try {
                return proxy.logout(logoutRequest);
            } catch (Exception e) {
                throw new CompletionException(e);
            }
        }, executorService);
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Missing port number to connect to.");
            System.exit(1);
        }

        final int port = Integer.parseInt(args[0]);
        final AsyncFutureClientRegistryClient client = new AsyncFutureClientRegistryClient(port);

        Runtime.getRuntime().addShutdownHook(new Thread(client::close));

        System.out.println("Connected to remote ClientRegistry server at port " + port + ".");

        final String clientId = UUID.randomUUID().toString().substring(0, 8);

        client.login(clientId, "Test Client").whenComplete(AsyncFutureClientRegistryClient::onCompletion);
        client.login(clientId, "Test Client").whenComplete(AsyncFutureClientRegistryClient::onCompletion);
        client.logout(clientId).whenComplete(AsyncFutureClientRegistryClient::onCompletion).join();
    }

    private static <T> void onCompletion(final T response, final Throwable cause) {
        final Throwable exception = unwrap(cause);
        if (exception != null) {
            if (exception instanceof ServiceError) {
                final ServiceError error = (ServiceError) exception;
                System.err.println(error.getMessage$());
            } else {
                System.err.println("Unable to complete RPC call: " + exception.getMessage());
            }
        } else {
            System.out.println(response);
        }
    }

    private static Throwable unwrap(final Throwable cause) {
        if (cause instanceof CompletionException) {
            return cause.getCause();
        } else {
            return cause;
        }
    }
}
