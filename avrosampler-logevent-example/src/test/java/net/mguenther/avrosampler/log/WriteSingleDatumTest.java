package net.mguenther.avrosampler.log;

import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * @author Markus Guenther (markus.guenther@gmail.com)
 */
public class WriteSingleDatumTest {

    @Test
    public void writeSingleRecordToFileShouldOmitSchema() throws Exception {

        LogEvent event = LogEvent
                .newBuilder()
                .setCode("AVRO-001")
                .setSeverity(Severity.ERROR)
                .setTimestamp(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()))
                .build();

        File containerFile = File.createTempFile("logevent-datum", "avro");

        try (FileOutputStream fos = new FileOutputStream(containerFile)) {
            Encoder e = EncoderFactory.get().binaryEncoder(fos, null);
            DatumWriter<LogEvent> writer = new SpecificDatumWriter<>(LogEvent.class);
            writer.write(event, e);
            e.flush();
        }

        LogEvent sameEvent;

        try (FileInputStream fin = new FileInputStream(containerFile)) {
            Decoder d = DecoderFactory.get().binaryDecoder(fin, null);
            DatumReader<LogEvent> reader = new SpecificDatumReader<>(LogEvent.class);
            sameEvent = reader.read(null, d);
        }

        assertNotNull(sameEvent);
        assertThat(sameEvent.getCode(), is(event.getCode()));
        assertNull(sameEvent.getDescription());
        assertThat(sameEvent.getSeverity(), is(event.getSeverity()));
        assertThat(sameEvent.getTimestamp(), is(event.getTimestamp()));

        System.out.println(event.getTimestamp());
    }
}
