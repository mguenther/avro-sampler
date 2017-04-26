package net.mguenther.avrosampler.log;

import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.specific.SpecificResponder;

import java.io.IOException;
import java.net.InetSocketAddress;

public class LogServer {

    private volatile Server server;

    private volatile Log log;

    public LogServer(final Log log) {
        this.log = log;
    }

    public void start(final int port) throws IOException {
        if (server == null) {
            server = new NettyServer(
                    new SpecificResponder(Log.class, log),
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
            System.err.println("Port-Nummer fehlt.");
            System.exit(1);
        }

        final Log log = new LogImpl();
        final LogServer server = new LogServer(log);
        final int port = Integer.parseInt(args[0]);

        server.start(port);

        Runtime.getRuntime().addShutdownHook(new Thread(server::stop));

        System.out.println("Server started. Listening at port " + port + ".");
    }
}
