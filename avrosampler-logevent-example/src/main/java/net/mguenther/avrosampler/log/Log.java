/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package net.mguenther.avrosampler.log;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public interface Log {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"Log\",\"namespace\":\"net.mguenther.avrosampler.log\",\"types\":[{\"type\":\"record\",\"name\":\"LogEvent\",\"doc\":\"Beschreibt ein Systemereignis.\",\"fields\":[{\"name\":\"code\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Eindeutiger Bezeichner für das Systemereignis.\",\"order\":\"ignore\"},{\"name\":\"description\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null,\"order\":\"ignore\"},{\"name\":\"timestamp\",\"type\":\"long\",\"order\":\"descending\"},{\"name\":\"severity\",\"type\":{\"type\":\"enum\",\"name\":\"Severity\",\"symbols\":[\"INFO\",\"WARN\",\"ERROR\"]},\"default\":\"INFO\",\"order\":\"ignore\"}]},{\"type\":\"record\",\"name\":\"LogEventRequest\",\"fields\":[{\"name\":\"clientId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Identifiziert das übermittelnde System\"},{\"name\":\"data\",\"type\":\"LogEvent\",\"doc\":\"Log-Daten vom übermittelnden System\"}]},{\"type\":\"error\",\"name\":\"ServiceError\",\"fields\":[{\"name\":\"code\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Beschreibt den Fehlerzustand\"}]}],\"messages\":{\"submit\":{\"doc\":\"Submits a LogEventRequest to the RPC server.\",\"request\":[{\"name\":\"request\",\"type\":\"LogEventRequest\"}],\"response\":\"null\",\"errors\":[\"ServiceError\"]}}}");
  /**
   * Submits a LogEventRequest to the RPC server.
   */
  java.lang.Void submit(net.mguenther.avrosampler.log.LogEventRequest request) throws org.apache.avro.AvroRemoteException, net.mguenther.avrosampler.log.ServiceError;

  @SuppressWarnings("all")
  public interface Callback extends Log {
    public static final org.apache.avro.Protocol PROTOCOL = net.mguenther.avrosampler.log.Log.PROTOCOL;
    /**
     * Submits a LogEventRequest to the RPC server.
     * @throws java.io.IOException The async call could not be completed.
     */
    void submit(net.mguenther.avrosampler.log.LogEventRequest request, org.apache.avro.ipc.Callback<java.lang.Void> callback) throws java.io.IOException;
  }
}