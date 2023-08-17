package consumer.app.event

import io.micronaut.serde.annotation.Serdeable

@Serdeable
class Event {

    String message
    Date date

}
