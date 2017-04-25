/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package net.mguenther.avrosampler.clientregistry;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class LoginRequest extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7935355477395661974L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"LoginRequest\",\"namespace\":\"net.mguenther.avrosampler.clientregistry\",\"fields\":[{\"name\":\"clientId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"The identifier for the client.\"},{\"name\":\"clientName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"The name of the client. This may be null if the client does not have a dedicated name.\",\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** The identifier for the client. */
  @Deprecated public java.lang.String clientId;
  /** The name of the client. This may be null if the client does not have a dedicated name. */
  @Deprecated public java.lang.String clientName;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public LoginRequest() {}

  /**
   * All-args constructor.
   * @param clientId The identifier for the client.
   * @param clientName The name of the client. This may be null if the client does not have a dedicated name.
   */
  public LoginRequest(java.lang.String clientId, java.lang.String clientName) {
    this.clientId = clientId;
    this.clientName = clientName;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return clientId;
    case 1: return clientName;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: clientId = (java.lang.String)value$; break;
    case 1: clientName = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'clientId' field.
   * @return The identifier for the client.
   */
  public java.lang.String getClientId() {
    return clientId;
  }

  /**
   * Sets the value of the 'clientId' field.
   * The identifier for the client.
   * @param value the value to set.
   */
  public void setClientId(java.lang.String value) {
    this.clientId = value;
  }

  /**
   * Gets the value of the 'clientName' field.
   * @return The name of the client. This may be null if the client does not have a dedicated name.
   */
  public java.lang.String getClientName() {
    return clientName;
  }

  /**
   * Sets the value of the 'clientName' field.
   * The name of the client. This may be null if the client does not have a dedicated name.
   * @param value the value to set.
   */
  public void setClientName(java.lang.String value) {
    this.clientName = value;
  }

  /**
   * Creates a new LoginRequest RecordBuilder.
   * @return A new LoginRequest RecordBuilder
   */
  public static net.mguenther.avrosampler.clientregistry.LoginRequest.Builder newBuilder() {
    return new net.mguenther.avrosampler.clientregistry.LoginRequest.Builder();
  }

  /**
   * Creates a new LoginRequest RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new LoginRequest RecordBuilder
   */
  public static net.mguenther.avrosampler.clientregistry.LoginRequest.Builder newBuilder(net.mguenther.avrosampler.clientregistry.LoginRequest.Builder other) {
    return new net.mguenther.avrosampler.clientregistry.LoginRequest.Builder(other);
  }

  /**
   * Creates a new LoginRequest RecordBuilder by copying an existing LoginRequest instance.
   * @param other The existing instance to copy.
   * @return A new LoginRequest RecordBuilder
   */
  public static net.mguenther.avrosampler.clientregistry.LoginRequest.Builder newBuilder(net.mguenther.avrosampler.clientregistry.LoginRequest other) {
    return new net.mguenther.avrosampler.clientregistry.LoginRequest.Builder(other);
  }

  /**
   * RecordBuilder for LoginRequest instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<LoginRequest>
    implements org.apache.avro.data.RecordBuilder<LoginRequest> {

    /** The identifier for the client. */
    private java.lang.String clientId;
    /** The name of the client. This may be null if the client does not have a dedicated name. */
    private java.lang.String clientName;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(net.mguenther.avrosampler.clientregistry.LoginRequest.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.clientId)) {
        this.clientId = data().deepCopy(fields()[0].schema(), other.clientId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.clientName)) {
        this.clientName = data().deepCopy(fields()[1].schema(), other.clientName);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing LoginRequest instance
     * @param other The existing instance to copy.
     */
    private Builder(net.mguenther.avrosampler.clientregistry.LoginRequest other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.clientId)) {
        this.clientId = data().deepCopy(fields()[0].schema(), other.clientId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.clientName)) {
        this.clientName = data().deepCopy(fields()[1].schema(), other.clientName);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'clientId' field.
      * The identifier for the client.
      * @return The value.
      */
    public java.lang.String getClientId() {
      return clientId;
    }

    /**
      * Sets the value of the 'clientId' field.
      * The identifier for the client.
      * @param value The value of 'clientId'.
      * @return This builder.
      */
    public net.mguenther.avrosampler.clientregistry.LoginRequest.Builder setClientId(java.lang.String value) {
      validate(fields()[0], value);
      this.clientId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'clientId' field has been set.
      * The identifier for the client.
      * @return True if the 'clientId' field has been set, false otherwise.
      */
    public boolean hasClientId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'clientId' field.
      * The identifier for the client.
      * @return This builder.
      */
    public net.mguenther.avrosampler.clientregistry.LoginRequest.Builder clearClientId() {
      clientId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'clientName' field.
      * The name of the client. This may be null if the client does not have a dedicated name.
      * @return The value.
      */
    public java.lang.String getClientName() {
      return clientName;
    }

    /**
      * Sets the value of the 'clientName' field.
      * The name of the client. This may be null if the client does not have a dedicated name.
      * @param value The value of 'clientName'.
      * @return This builder.
      */
    public net.mguenther.avrosampler.clientregistry.LoginRequest.Builder setClientName(java.lang.String value) {
      validate(fields()[1], value);
      this.clientName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'clientName' field has been set.
      * The name of the client. This may be null if the client does not have a dedicated name.
      * @return True if the 'clientName' field has been set, false otherwise.
      */
    public boolean hasClientName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'clientName' field.
      * The name of the client. This may be null if the client does not have a dedicated name.
      * @return This builder.
      */
    public net.mguenther.avrosampler.clientregistry.LoginRequest.Builder clearClientName() {
      clientName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public LoginRequest build() {
      try {
        LoginRequest record = new LoginRequest();
        record.clientId = fieldSetFlags()[0] ? this.clientId : (java.lang.String) defaultValue(fields()[0]);
        record.clientName = fieldSetFlags()[1] ? this.clientName : (java.lang.String) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
