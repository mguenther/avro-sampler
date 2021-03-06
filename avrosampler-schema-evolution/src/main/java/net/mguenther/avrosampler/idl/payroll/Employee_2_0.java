/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package net.mguenther.avrosampler.idl.payroll;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Employee_2_0 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4709816464434343259L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Employee_2_0\",\"namespace\":\"net.mguenther.avrosampler.idl.payroll\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"years\",\"type\":\"int\",\"aliases\":[\"age\"]},{\"name\":\"gender\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"unknown\"},{\"name\":\"emails\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}}],\"aliases\":[\"Employee_1_0\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.String name;
  @Deprecated public int years;
  @Deprecated public java.lang.String gender;
  @Deprecated public java.util.List<java.lang.String> emails;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Employee_2_0() {}

  /**
   * All-args constructor.
   * @param name The new value for name
   * @param years The new value for years
   * @param gender The new value for gender
   * @param emails The new value for emails
   */
  public Employee_2_0(java.lang.String name, java.lang.Integer years, java.lang.String gender, java.util.List<java.lang.String> emails) {
    this.name = name;
    this.years = years;
    this.gender = gender;
    this.emails = emails;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return years;
    case 2: return gender;
    case 3: return emails;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.String)value$; break;
    case 1: years = (java.lang.Integer)value$; break;
    case 2: gender = (java.lang.String)value$; break;
    case 3: emails = (java.util.List<java.lang.String>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'years' field.
   * @return The value of the 'years' field.
   */
  public java.lang.Integer getYears() {
    return years;
  }

  /**
   * Sets the value of the 'years' field.
   * @param value the value to set.
   */
  public void setYears(java.lang.Integer value) {
    this.years = value;
  }

  /**
   * Gets the value of the 'gender' field.
   * @return The value of the 'gender' field.
   */
  public java.lang.String getGender() {
    return gender;
  }

  /**
   * Sets the value of the 'gender' field.
   * @param value the value to set.
   */
  public void setGender(java.lang.String value) {
    this.gender = value;
  }

  /**
   * Gets the value of the 'emails' field.
   * @return The value of the 'emails' field.
   */
  public java.util.List<java.lang.String> getEmails() {
    return emails;
  }

  /**
   * Sets the value of the 'emails' field.
   * @param value the value to set.
   */
  public void setEmails(java.util.List<java.lang.String> value) {
    this.emails = value;
  }

  /**
   * Creates a new Employee_2_0 RecordBuilder.
   * @return A new Employee_2_0 RecordBuilder
   */
  public static net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder newBuilder() {
    return new net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder();
  }

  /**
   * Creates a new Employee_2_0 RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Employee_2_0 RecordBuilder
   */
  public static net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder newBuilder(net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder other) {
    return new net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder(other);
  }

  /**
   * Creates a new Employee_2_0 RecordBuilder by copying an existing Employee_2_0 instance.
   * @param other The existing instance to copy.
   * @return A new Employee_2_0 RecordBuilder
   */
  public static net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder newBuilder(net.mguenther.avrosampler.idl.payroll.Employee_2_0 other) {
    return new net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder(other);
  }

  /**
   * RecordBuilder for Employee_2_0 instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Employee_2_0>
    implements org.apache.avro.data.RecordBuilder<Employee_2_0> {

    private java.lang.String name;
    private int years;
    private java.lang.String gender;
    private java.util.List<java.lang.String> emails;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.years)) {
        this.years = data().deepCopy(fields()[1].schema(), other.years);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.gender)) {
        this.gender = data().deepCopy(fields()[2].schema(), other.gender);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.emails)) {
        this.emails = data().deepCopy(fields()[3].schema(), other.emails);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Employee_2_0 instance
     * @param other The existing instance to copy.
     */
    private Builder(net.mguenther.avrosampler.idl.payroll.Employee_2_0 other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.years)) {
        this.years = data().deepCopy(fields()[1].schema(), other.years);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.gender)) {
        this.gender = data().deepCopy(fields()[2].schema(), other.gender);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.emails)) {
        this.emails = data().deepCopy(fields()[3].schema(), other.emails);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder setName(java.lang.String value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'years' field.
      * @return The value.
      */
    public java.lang.Integer getYears() {
      return years;
    }

    /**
      * Sets the value of the 'years' field.
      * @param value The value of 'years'.
      * @return This builder.
      */
    public net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder setYears(int value) {
      validate(fields()[1], value);
      this.years = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'years' field has been set.
      * @return True if the 'years' field has been set, false otherwise.
      */
    public boolean hasYears() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'years' field.
      * @return This builder.
      */
    public net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder clearYears() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'gender' field.
      * @return The value.
      */
    public java.lang.String getGender() {
      return gender;
    }

    /**
      * Sets the value of the 'gender' field.
      * @param value The value of 'gender'.
      * @return This builder.
      */
    public net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder setGender(java.lang.String value) {
      validate(fields()[2], value);
      this.gender = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'gender' field has been set.
      * @return True if the 'gender' field has been set, false otherwise.
      */
    public boolean hasGender() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'gender' field.
      * @return This builder.
      */
    public net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder clearGender() {
      gender = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'emails' field.
      * @return The value.
      */
    public java.util.List<java.lang.String> getEmails() {
      return emails;
    }

    /**
      * Sets the value of the 'emails' field.
      * @param value The value of 'emails'.
      * @return This builder.
      */
    public net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder setEmails(java.util.List<java.lang.String> value) {
      validate(fields()[3], value);
      this.emails = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'emails' field has been set.
      * @return True if the 'emails' field has been set, false otherwise.
      */
    public boolean hasEmails() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'emails' field.
      * @return This builder.
      */
    public net.mguenther.avrosampler.idl.payroll.Employee_2_0.Builder clearEmails() {
      emails = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public Employee_2_0 build() {
      try {
        Employee_2_0 record = new Employee_2_0();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.String) defaultValue(fields()[0]);
        record.years = fieldSetFlags()[1] ? this.years : (java.lang.Integer) defaultValue(fields()[1]);
        record.gender = fieldSetFlags()[2] ? this.gender : (java.lang.String) defaultValue(fields()[2]);
        record.emails = fieldSetFlags()[3] ? this.emails : (java.util.List<java.lang.String>) defaultValue(fields()[3]);
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
