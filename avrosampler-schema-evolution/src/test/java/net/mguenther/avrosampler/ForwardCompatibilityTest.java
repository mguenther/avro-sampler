package net.mguenther.avrosampler;

import org.junit.Ignore;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 */
@Ignore
public class ForwardCompatibilityTest {

    /*@Test
    public void an_Employee_2_0_Record_Should_Be_Readable_With_Employee_1_0_Schema() throws Exception {

        final Employee_2_0 employee = Employee_2_0.newBuilder()
                .setName("Markus Günther")
                .setYears(34)
                .setEmails(Arrays.asList("markus.guenther@gmail.com"))
                .build();

        final File tmpFile = File.createTempFile("fc-emp_2_0-emp_1_0", ".avro");

        final DataFileWriter<Employee_2_0> writer = new DataFileWriter<>(new SpecificDatumWriter<>(Employee_2_0.class));
        writer.create(employee.getSchema(), tmpFile);
        writer.append(employee);
        writer.close();

        final DatumReader<Employee_1_0> specificDatumReader =
                new SpecificDatumReader<>(Employee_2_0.getClassSchema(), Employee_1_0.getClassSchema());
        final DataFileReader<Employee_1_0> reader = new DataFileReader<>(tmpFile, specificDatumReader);
        final Employee_1_0 sameEmployee = reader.next();

        assertThat(sameEmployee.getName(), is(employee.getName()));
        assertThat(sameEmployee.getAge(), is(employee.getYears()));
        assertThat(sameEmployee.getEmails().size(), is(employee.getEmails().size()));
        assertThat(sameEmployee.getEmails().get(0), is(employee.getEmails().get(0)));
        assertNull(sameEmployee.getBoss());
    }*/
}
