package net.mguenther.avrosampler.clientregistry;

import org.apache.avro.ipc.Callback;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.UUID;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
public class AsyncClientRegistryClient {

    private final NettyTransceiver underlyingClient;

    private final ClientRegistry.Callback proxy;

    public AsyncClientRegistryClient(final int serverPort) throws IOException {
        underlyingClient = new NettyTransceiver(new InetSocketAddress(serverPort));
        proxy = SpecificRequestor.getClient(ClientRegistry.Callback.class, underlyingClient);
    }

    public void close() {
        if (underlyingClient != null) {
            underlyingClient.close();
        }
    }

    public void login(final String clientId, final String clientName, final Callback<String> callback) {
        final LoginRequest loginRequest = LoginRequest
                .newBuilder()
                .setClientId(clientId)
                .setClientName(clientName)
                .build();
        try {
            proxy.login(loginRequest, callback);
        } catch (IOException e) {
            // if the async call could not be completed - this is kind of cumbersome
            System.err.println("Unable to complete the asynchronous login for " + clientId + ".");
        }
    }

    public void logout(final String clientId, final Callback<String> callback) {
        final LogoutRequest logoutRequest = LogoutRequest
                .newBuilder()
                .setClientId(clientId)
                .build();
        try {
            proxy.logout(logoutRequest, callback);
        } catch (IOException e) {
            // if the async call could not be completed
            System.err.println("Unable to complete the asynchronous logout for " + clientId + ".");
        }
    }

    static class SimpleResponseCallback implements Callback<String> {

        @Override
        public void handleResult(final String response) {
            System.out.println(response);
        }

        @Override
        public void handleError(final Throwable throwable) { // Throwable? Really?
            if (throwable instanceof ServiceError) {
                final ServiceError error = (ServiceError) throwable;
                System.err.println(error.getMessage$());
            } else {
                System.err.println("Unable to complete RPC call: " + throwable.getMessage());
            }
        }
    }

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            System.err.println("Missing port number to connect to.");
            System.exit(1);
        }

        final int port = Integer.parseInt(args[0]);
        final AsyncClientRegistryClient client = new AsyncClientRegistryClient(port);

        Runtime.getRuntime().addShutdownHook(new Thread(client::close));

        System.out.println("Connected to remote ClientRegistry server at port " + port + ".");

        final String clientId = UUID.randomUUID().toString().substring(0, 8);
        final SimpleResponseCallback callback = new SimpleResponseCallback();

        // if we require the request context inside the callback handler, then
        // we would have to provide a new instance of the callback handler that
        // closes over the actual request instance for every client-server-
        // transaction
        client.login(clientId, "Test Client", callback);
        client.login(clientId, "Test Client", callback);
        client.logout(clientId, callback);

        Thread.sleep(5_000); // wait a bit so that all requests can complete
    }
}
