package net.mguenther.avrosampler.clientregistry;

import java.util.Optional;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
public class Client {

    private final String clientId;
    private final String clientName;

    public Client(final String clientId, final String clientName) {
        this.clientId = clientId;
        this.clientName = clientName;
    }

    public String getClientId() {
        return this.clientId;
    }

    public Optional<String> getClientName() {
        return Optional.ofNullable(this.clientName);
    }
}
