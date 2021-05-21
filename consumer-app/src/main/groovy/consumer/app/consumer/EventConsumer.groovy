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
    def receive(@KafkaKey String key, Event event, long offset, int partition, String topic, long timestamp) {
        println "${topic}[${partition}] offset: ${offset} timestamp: ${timestamp} key: ${key}"
        println "${dateFormat.format(event.date)}: ${event.message}"
    }

    @Topic("micronaut.kafka.test.strings")
    def receive(@KafkaKey String key, String string, long offset, int partition, String topic, long timestamp) {
        println "${topic}[${partition}] offset: ${offset} timestamp: ${timestamp} key: ${key}"
        println string
    }

}
