# Micronaut - Kafka Test

This is a simple test of the `micronaut-kafka` integration.

It has a simple producer that writes to a topic.  It has a simple consumer that
reads from this topic.

Inspired by [this Micronaut presentation](https://youtu.be/6jL1RPdVm2w).

## To Run

You can start Kafka with Docker Compose:

    $ docker compose up -d

You can start the message producer with the following command:

    $ (cd producer-app && ./gradlew run)

You can start one or more message consumers with the following command:

    $ (cd consumer-app && ./gradlew run)

Just hit Ctrl-C in each shell to stop it when you're done.  You  can stop Kafka
with `docker compose stop`.

## To Trigger a Message

    $ http :8080/hello/event

or

    $ http :8080/hello/string

## To Trigger a Message With a Parameter

    $ http :8080/hello/event name=="Jean Tessier"

or

    $ http :8080/hello/string name=="Jean Tessier"

## Topics

The application will automatically create the `micronaut.kafka.test.events` and
`micronaut.kafka.test.strings` topics, but with a single partition.  This means
that no matter how many consumers you start, all messages will go to only one of
them (usually the last one to start).

You can add partitions with:

    $ docker compose exec kafka \
        /opt/bitnami/kafka/bin/kafka-topics.sh \
        --bootstrap-server kafka:9092 \
        --alter \
        --topic micronaut.kafka.test.events \
        --partitions 5
