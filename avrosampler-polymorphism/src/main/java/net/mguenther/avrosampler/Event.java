package net.mguenther.avrosampler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 */
@RequiredArgsConstructor
@Getter
public class Event {

    private final String id;
    private final String type;
    private final long created;

}
