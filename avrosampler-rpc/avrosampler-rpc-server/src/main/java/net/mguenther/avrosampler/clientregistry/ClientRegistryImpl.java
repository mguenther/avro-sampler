package net.mguenther.avrosampler.clientregistry;

import org.apache.avro.AvroRemoteException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
public class ClientRegistryImpl implements ClientRegistry {

    private final Map<String, Client> registeredClients = new HashMap<>();

    @Override
    public String login(final LoginRequest request) throws AvroRemoteException, ServiceError {

        synchronized (registeredClients) {
            if (registeredClients.containsKey(request.getClientId())) {
                throw ServiceError
                        .newBuilder()
                        .setCode(1)
                        .setMessage$("A client with ID " + request.getClientId() + " is already registered.")
                        .build();
            }
            final Client client = new Client(request.getClientId(), request.getClientName());
            registeredClients.put(request.getClientId(), client);
        }

        System.out.println("Registered client with ID " + request.getClientId() + ".");

        return "ok";
    }

    @Override
    public String logout(final LogoutRequest request) throws AvroRemoteException, ServiceError {

        synchronized (registeredClients) {
            if (registeredClients.containsKey(request.getClientId())) {
                registeredClients.remove(request.getClientId());
                System.out.println("Removed client with ID " + request.getClientId() + ".");
            }
        }

        return "ok";
    }
}
