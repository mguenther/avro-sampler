package net.mguenther.avrosampler.clientregistry;

import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.specific.SpecificResponder;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
public class ClientRegistryServer {

    private volatile Server server;

    private volatile ClientRegistry clientRegistry;

    public ClientRegistryServer(final ClientRegistry clientRegistry) {
        this.clientRegistry = clientRegistry;
    }

    public void start(final int port) throws IOException {
        if (server == null) {
            server = new NettyServer(
                    new SpecificResponder(ClientRegistry.class, clientRegistry),
                    new InetSocketAddress(port));
        }
    }

    public void stop() {
        if (server != null) {
            server.close();
        }
    }

    public int getPort() {
        int port = 0;
        if (server != null) {
            port = server.getPort();
        }
        return port;
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Missing port number.");
            System.exit(1);
        }

        final ClientRegistry clientRegistry = new ClientRegistryImpl();
        final ClientRegistryServer server = new ClientRegistryServer(clientRegistry);

        final int port = Integer.parseInt(args[0]);
        server.start(port);

        Runtime.getRuntime().addShutdownHook(new Thread(server::stop));

        try {
            Thread.sleep(5_000); // give the Netty server some time to launch
        } catch (InterruptedException e) {
            System.err.println("Caught an interrupt while launching the application: " + e.getMessage());
        }
        System.out.println("Server started. Listening at port " + port + ".");
    }
}
