package net.mguenther.avrosampler;

import net.mguenther.avrosampler.idl.payroll.Employee_1_0;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.file.FileReader;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 */
public class SerializeTest {

    @Test
    public void an_Employee_1_0_Record_Should_Be_Written_To_Disk_And_Read_Back_Into_The_Same_Type() throws Exception {

        final Employee_1_0 employee = Employee_1_0.newBuilder()
                .setName("Markus Günther")
                .setAge(34)
                .setEmails(Arrays.asList("markus.guenther@gmail.com"))
                .setBoss(null)
                .build();

        final File tmpFile = File.createTempFile("ser-emp_1_0", ".avro");

        final DataFileWriter<Employee_1_0> writer = new DataFileWriter<>(new SpecificDatumWriter<>(Employee_1_0.class));
        writer.create(Employee_1_0.SCHEMA$, tmpFile);
        writer.append(employee);
        writer.close();

        final FileReader<Employee_1_0> reader = DataFileReader.openReader(tmpFile, new SpecificDatumReader<>(Employee_1_0.class));
        final Employee_1_0 sameEmployee = reader.next();

        assertThat(sameEmployee.getName(), is(employee.getName()));
        assertThat(sameEmployee.getAge(), is(employee.getAge()));
        assertThat(sameEmployee.getEmails().size(), is(employee.getEmails().size()));
        assertThat(sameEmployee.getEmails().get(0), is(employee.getEmails().get(0)));
        assertNull(sameEmployee.getBoss());
    }
}
