package consumer.app.consumer

import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class StringConsumer {

    @Topic("micronaut.kafka.test.strings")
    def receive(@KafkaKey String key, String string, long offset, int partition, String topic, long timestamp) {
        println "${topic}[${partition}] offset: ${offset} timestamp: ${timestamp} key: ${key}"
        println "[${getClass().name}] ${string}"
    }

}
