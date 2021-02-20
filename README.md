# Micronaut - Kafka Test

This is a simple test of the `micronaut-kafka` integration.

It has a simple producer that writes to a topic.  It has a simple consumer that
reads from this topic.

## To Run

You can start the message producer with the following command:

    $ (cd producer-app && ./gradlew run)

Just hit Ctrl-C in each shell to stop it when you're done.

## To Trigger a Message

    $ http :8080

or

    $ http :8080 name=="Jean Tessier"
