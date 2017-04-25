package net.mguenther.avrosampler;

import net.mguenther.avrosampler.idl.payroll.Employee_1_0;
import net.mguenther.avrosampler.idl.payroll.Employee_2_0;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 */
public class BackwardCompatibilityTest {

    @Test
    public void an_Employee_1_0_Record_Should_Be_Readable_With_Employee_2_0_Schema() throws Exception {

        final Employee_1_0 employee = Employee_1_0.newBuilder()
                .setName("Markus Günther")
                .setAge(34)
                .setEmails(Arrays.asList("markus.guenther@gmail.com"))
                .setBoss(null)
                .build();

        final File tmpFile = File.createTempFile("bc-emp_1_0-emp_2_0", ".avro");

        final DataFileWriter<Employee_1_0> writer = new DataFileWriter<>(new SpecificDatumWriter<>(Employee_1_0.class));
        writer.create(employee.getSchema(), tmpFile);
        writer.append(employee);
        writer.close();

        final DatumReader<Employee_2_0> specificDatumReader =
                new SpecificDatumReader<>(Employee_1_0.getClassSchema(), Employee_2_0.getClassSchema());
        final DataFileReader<Employee_2_0> reader = new DataFileReader<>(tmpFile, specificDatumReader);
        final Employee_2_0 sameEmployee = reader.next();

        assertThat(sameEmployee.getName(), is(employee.getName()));
        assertThat(sameEmployee.getYears(), is(employee.getAge()));
        assertThat(sameEmployee.getEmails().size(), is(employee.getEmails().size()));
        assertThat(sameEmployee.getEmails().get(0), is(employee.getEmails().get(0)));
        assertThat(sameEmployee.getGender(), is("unknown"));
    }
}
