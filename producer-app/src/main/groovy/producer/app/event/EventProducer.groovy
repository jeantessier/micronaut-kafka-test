package producer.app.event

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
abstract class EventProducer {

    @Topic("micronaut.kafka.test.events")
    abstract send(@KafkaKey String key, Event event)

    @Topic("micronaut.kafka.test.strings")
    abstract send(@KafkaKey String key, String string)

    def send(Event event) {
        send(System.currentTimeMillis() as String, event)
    }

    def send(String string) {
        send(System.currentTimeMillis() as String, string)
    }

}
