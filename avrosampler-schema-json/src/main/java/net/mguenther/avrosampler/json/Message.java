/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package net.mguenther.avrosampler.json;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Message extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2168136878670577791L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Message\",\"namespace\":\"net.mguenther.avrosampler.json\",\"fields\":[{\"name\":\"messageId\",\"type\":\"string\"},{\"name\":\"text\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence messageId;
  @Deprecated public java.lang.CharSequence text;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Message() {}

  /**
   * All-args constructor.
   * @param messageId The new value for messageId
   * @param text The new value for text
   */
  public Message(java.lang.CharSequence messageId, java.lang.CharSequence text) {
    this.messageId = messageId;
    this.text = text;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return messageId;
    case 1: return text;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: messageId = (java.lang.CharSequence)value$; break;
    case 1: text = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'messageId' field.
   * @return The value of the 'messageId' field.
   */
  public java.lang.CharSequence getMessageId() {
    return messageId;
  }

  /**
   * Sets the value of the 'messageId' field.
   * @param value the value to set.
   */
  public void setMessageId(java.lang.CharSequence value) {
    this.messageId = value;
  }

  /**
   * Gets the value of the 'text' field.
   * @return The value of the 'text' field.
   */
  public java.lang.CharSequence getText() {
    return text;
  }

  /**
   * Sets the value of the 'text' field.
   * @param value the value to set.
   */
  public void setText(java.lang.CharSequence value) {
    this.text = value;
  }

  /**
   * Creates a new Message RecordBuilder.
   * @return A new Message RecordBuilder
   */
  public static net.mguenther.avrosampler.json.Message.Builder newBuilder() {
    return new net.mguenther.avrosampler.json.Message.Builder();
  }

  /**
   * Creates a new Message RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Message RecordBuilder
   */
  public static net.mguenther.avrosampler.json.Message.Builder newBuilder(net.mguenther.avrosampler.json.Message.Builder other) {
    return new net.mguenther.avrosampler.json.Message.Builder(other);
  }

  /**
   * Creates a new Message RecordBuilder by copying an existing Message instance.
   * @param other The existing instance to copy.
   * @return A new Message RecordBuilder
   */
  public static net.mguenther.avrosampler.json.Message.Builder newBuilder(net.mguenther.avrosampler.json.Message other) {
    return new net.mguenther.avrosampler.json.Message.Builder(other);
  }

  /**
   * RecordBuilder for Message instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Message>
    implements org.apache.avro.data.RecordBuilder<Message> {

    private java.lang.CharSequence messageId;
    private java.lang.CharSequence text;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(net.mguenther.avrosampler.json.Message.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.messageId)) {
        this.messageId = data().deepCopy(fields()[0].schema(), other.messageId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.text)) {
        this.text = data().deepCopy(fields()[1].schema(), other.text);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Message instance
     * @param other The existing instance to copy.
     */
    private Builder(net.mguenther.avrosampler.json.Message other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.messageId)) {
        this.messageId = data().deepCopy(fields()[0].schema(), other.messageId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.text)) {
        this.text = data().deepCopy(fields()[1].schema(), other.text);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'messageId' field.
      * @return The value.
      */
    public java.lang.CharSequence getMessageId() {
      return messageId;
    }

    /**
      * Sets the value of the 'messageId' field.
      * @param value The value of 'messageId'.
      * @return This builder.
      */
    public net.mguenther.avrosampler.json.Message.Builder setMessageId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.messageId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'messageId' field has been set.
      * @return True if the 'messageId' field has been set, false otherwise.
      */
    public boolean hasMessageId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'messageId' field.
      * @return This builder.
      */
    public net.mguenther.avrosampler.json.Message.Builder clearMessageId() {
      messageId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'text' field.
      * @return The value.
      */
    public java.lang.CharSequence getText() {
      return text;
    }

    /**
      * Sets the value of the 'text' field.
      * @param value The value of 'text'.
      * @return This builder.
      */
    public net.mguenther.avrosampler.json.Message.Builder setText(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.text = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'text' field has been set.
      * @return True if the 'text' field has been set, false otherwise.
      */
    public boolean hasText() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'text' field.
      * @return This builder.
      */
    public net.mguenther.avrosampler.json.Message.Builder clearText() {
      text = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public Message build() {
      try {
        Message record = new Message();
        record.messageId = fieldSetFlags()[0] ? this.messageId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.text = fieldSetFlags()[1] ? this.text : (java.lang.CharSequence) defaultValue(fields()[1]);
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
