package net.mguenther.avrosampler.clientregistry;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.UUID;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
public class ClientRegistryClient {

    private final NettyTransceiver underlyingClient;

    private final ClientRegistry proxy;

    public ClientRegistryClient(final int serverPort) throws IOException {
        underlyingClient = new NettyTransceiver(new InetSocketAddress(serverPort));
        proxy = SpecificRequestor.getClient(ClientRegistry.class, underlyingClient);
    }

    public void close() {
        if (underlyingClient != null) {
            underlyingClient.close();
        }
    }

    public void login(final String clientId, final String clientName) {
        final LoginRequest loginRequest = LoginRequest
                .newBuilder()
                .setClientId(clientId)
                .setClientName(clientName)
                .build();
        try {
            final String response = proxy.login(loginRequest);
            System.out.println(response);
        } catch (ServiceError e) {
            System.err.println("Unable to carry out login due to error code " + e.getCode() + " with message '" + e.getMessage$() + ".");
        } catch (AvroRemoteException e) {
            System.err.println("Caught an AvroRemoteException: " + e.getMessage());
        }
    }

    public void logout(final String clientId) {
        final LogoutRequest logoutRequest = LogoutRequest
                .newBuilder()
                .setClientId(clientId)
                .build();
        try {
            final String response = proxy.logout(logoutRequest);
            System.out.println(response);
        } catch (AvroRemoteException e) {
            System.err.println("Caught an AvroRemoteException: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Missing port number to connect to.");
            System.exit(1);
        }

        final int port = Integer.parseInt(args[0]);
        final ClientRegistryClient client = new ClientRegistryClient(port);

        Runtime.getRuntime().addShutdownHook(new Thread(client::close));

        System.out.println("Connected to remote ClientRegistry server at port " + port + ".");

        final String clientId = UUID.randomUUID().toString().substring(0, 8);

        client.login(clientId, "Test client");
        client.login(clientId, "Test client");
        client.logout(clientId);
    }
}
