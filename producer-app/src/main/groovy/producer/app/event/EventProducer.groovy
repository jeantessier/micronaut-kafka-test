package producer.app.event

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
interface EventProducer {

    @Topic("micronaut.kafka.test.events")
    def send(@KafkaKey String key, Event event)

}
