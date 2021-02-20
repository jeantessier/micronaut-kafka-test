package consumer.app.consumer

import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic

import java.text.SimpleDateFormat

import consumer.app.event.Event

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class EventConsumer {

    static final dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    @Topic("micronaut.kafka.test.events")
    def receive(@KafkaKey String key, Event event) {
        println "${dateFormat.format(event.date)}: ${event.message}"
    }

}
