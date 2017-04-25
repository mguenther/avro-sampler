/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package net.mguenther.avrosampler.clientregistry;

@SuppressWarnings("all")
/** Defines the RPC API for clients to login and logout. */
@org.apache.avro.specific.AvroGenerated
public interface ClientRegistry {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"ClientRegistry\",\"namespace\":\"net.mguenther.avrosampler.clientregistry\",\"doc\":\"Defines the RPC API for clients to login and logout.\",\"types\":[{\"type\":\"record\",\"name\":\"LoginRequest\",\"fields\":[{\"name\":\"clientId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"The identifier for the client.\"},{\"name\":\"clientName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"The name of the client. This may be null if the client does not have a dedicated name.\",\"default\":null}]},{\"type\":\"record\",\"name\":\"LogoutRequest\",\"fields\":[{\"name\":\"clientId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"The identifier for the client.\"}]},{\"type\":\"error\",\"name\":\"ServiceError\",\"fields\":[{\"name\":\"code\",\"type\":\"int\",\"doc\":\"Unique code that identifies an error condition.\"},{\"name\":\"message\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Provides a detailed description of the error situation.\"}]}],\"messages\":{\"login\":{\"request\":[{\"name\":\"request\",\"type\":\"LoginRequest\"}],\"response\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"errors\":[\"ServiceError\"]},\"logout\":{\"request\":[{\"name\":\"request\",\"type\":\"LogoutRequest\"}],\"response\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"errors\":[\"ServiceError\"]}}}");
  /**
   */
  java.lang.String login(net.mguenther.avrosampler.clientregistry.LoginRequest request) throws org.apache.avro.AvroRemoteException, net.mguenther.avrosampler.clientregistry.ServiceError;
  /**
   */
  java.lang.String logout(net.mguenther.avrosampler.clientregistry.LogoutRequest request) throws org.apache.avro.AvroRemoteException, net.mguenther.avrosampler.clientregistry.ServiceError;

  @SuppressWarnings("all")
  /** Defines the RPC API for clients to login and logout. */
  public interface Callback extends ClientRegistry {
    public static final org.apache.avro.Protocol PROTOCOL = net.mguenther.avrosampler.clientregistry.ClientRegistry.PROTOCOL;
    /**
     * @throws java.io.IOException The async call could not be completed.
     */
    void login(net.mguenther.avrosampler.clientregistry.LoginRequest request, org.apache.avro.ipc.Callback<java.lang.String> callback) throws java.io.IOException;
    /**
     * @throws java.io.IOException The async call could not be completed.
     */
    void logout(net.mguenther.avrosampler.clientregistry.LogoutRequest request, org.apache.avro.ipc.Callback<java.lang.String> callback) throws java.io.IOException;
  }
}