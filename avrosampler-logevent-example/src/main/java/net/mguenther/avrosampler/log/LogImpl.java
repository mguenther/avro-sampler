package net.mguenther.avrosampler.log;

import org.apache.avro.AvroRemoteException;
import org.apache.commons.lang.StringUtils;

public class LogImpl implements Log {

    private static final String TEMPLATE = "[%s] %s - %s (%s)";

    @Override
    public Void submit(final LogEventRequest request) throws ServiceError, AvroRemoteException {

        if (StringUtils.isEmpty(request.getClientId())) {
            throw ServiceError.newBuilder().setCode("001").build();
        }

        final LogEvent data = request.getData();
        final String logMessage = String.format(TEMPLATE, data.getSeverity(), data.getCode(), data.getDescription(), request.getClientId());

        System.out.println(logMessage);

        return null;
    }
}
