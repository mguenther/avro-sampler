package net.mguenther.avrosampler.log;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
public class WriteToContainerTest {

    @Test
    public void writeToContainerShouldPutSchemaAlongsideWithRecords() throws Exception {

        LogEvent event = LogEvent
                .newBuilder()
                .setCode("AVRO-001")
                .setSeverity(Severity.ERROR)
                .setTimestamp(System.currentTimeMillis())
                .build();

        File containerFile = File.createTempFile("logevent-container", "avro");

        try (DataFileWriter<LogEvent> writer = new DataFileWriter<>(new SpecificDatumWriter<>(LogEvent.class))) {
            writer.create(event.getSchema(), containerFile);
            writer.append(event);
        }

        LogEvent sameEvent;

        try (DataFileReader<LogEvent> reader = new DataFileReader<>(containerFile, new SpecificDatumReader<>())) {
            sameEvent = reader.next();
        }

        assertThat(sameEvent.getCode(), is(event.getCode()));
        assertNull(sameEvent.getDescription());
        assertThat(sameEvent.getSeverity(), is(event.getSeverity()));
        assertThat(sameEvent.getTimestamp(), is(event.getTimestamp()));
    }
}
