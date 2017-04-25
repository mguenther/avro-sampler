package net.mguenther.avrosampler.clientregistry;

import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
public class ClientRegistryTest {

    private static final int USE_EPHEMERAL_PORT = 0;

    private static ClientRegistryServer server;

    private static NettyTransceiver underlyingClient;

    private static ClientRegistry proxy;

    @BeforeClass
    public static void prepareEnvironment() throws Exception {

        final ClientRegistry clientRegistry = new ClientRegistryImpl();
        server = new ClientRegistryServer(clientRegistry);
        server.start(USE_EPHEMERAL_PORT);

        Thread.sleep(1_000); // wait shortly

        underlyingClient = new NettyTransceiver(new InetSocketAddress(server.getPort()));
        proxy = SpecificRequestor.getClient(ClientRegistry.class, underlyingClient);
    }

    @AfterClass
    public static void shutdownEnvironment() throws Exception {
        server.stop();
        underlyingClient.close();
    }

    @Test
    public void loginShouldYieldOkForPreviouslyUnregisteredClient() throws Exception {

        final LoginRequest loginRequest = LoginRequest.newBuilder().setClientId(generateClientId()).build();
        final String response = proxy.login(loginRequest);

        assertThat(response, is("ok"));
    }

    @Test
    public void duplicateLoginAttemptShouldRaiseServiceError() throws Exception {

        final LoginRequest loginRequest = LoginRequest.newBuilder().setClientId(generateClientId()).build();
        proxy.login(loginRequest);

        try {
            proxy.login(loginRequest);
            fail("Expected a ServiceError with error code 1, but none was raised.");
        } catch (ServiceError e) {
            assertThat(e.getCode(), is(1));
        }
    }

    @Test
    public void logoutShouldYieldOkForPreviouslyRegisteredClient() throws Exception {

        final LoginRequest loginRequest = LoginRequest.newBuilder().setClientId(generateClientId()).build();
        final LogoutRequest logoutRequest = LogoutRequest.newBuilder().setClientId(loginRequest.getClientId()).build();

        proxy.login(loginRequest);
        final String response = proxy.logout(logoutRequest);

        assertThat(response, is("ok"));
    }

    private String generateClientId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
