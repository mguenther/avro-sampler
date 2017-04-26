package net.mguenther.avrosampler.log;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.Transceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.UUID;

public class LogClient implements AutoCloseable {

    private final Transceiver underlyingClient;

    private final Log proxy;

    public LogClient(final int serverPort) throws IOException {
        underlyingClient = new NettyTransceiver(new InetSocketAddress(serverPort));
        proxy = SpecificRequestor.getClient(Log.class, underlyingClient);
    }

    @Override
    public void close() throws Exception {
        if (underlyingClient != null) {
            underlyingClient.close();
        }
    }

    public void submit(final String clientId, final LogEvent data) {
        final LogEventRequest request = LogEventRequest
                .newBuilder()
                .setClientId(clientId)
                .setData(data)
                .build();
        try {
            proxy.submit(request);
        } catch (ServiceError e) {
            System.err.println("Fehlerhafter Request (Error Code: " + e.getCode());
        } catch (AvroRemoteException e) {
            System.err.println("Kommunikationsfehler mit RPC-Server: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Port-Nummer fehlt");
            System.exit(1);
        }

        final String clientId = UUID.randomUUID().toString().substring(0, 8);
        final int port = Integer.parseInt(args[0]);

        try (final LogClient client = new LogClient(port)) {
            LogEvent data = LogEvent
                    .newBuilder()
                    .setCode("1001")
                    .setDescription("Verbindungsfehler Datenbank")
                    .setSeverity(Severity.ERROR)
                    .setTimestamp(System.currentTimeMillis())
                    .build();
            client.submit(clientId, data);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
