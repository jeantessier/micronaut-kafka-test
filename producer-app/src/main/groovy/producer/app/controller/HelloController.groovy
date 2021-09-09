package producer.app.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import jakarta.inject.*

import producer.app.event.Event
import producer.app.event.EventProducer

@Controller("/hello")
class HelloController {

    @Inject
    EventProducer eventProducer

    @Get(uri = "/event", produces = MediaType.TEXT_PLAIN)
    def event(Optional<String> name) {
        def message = name.present ? "Hello, ${name.get()}!" : "Hello, world!"
        eventProducer.send(new Event(message: message, date: new Date()))

        return "OK (event)"
    }

    @Get(uri = "/string", produces = MediaType.TEXT_PLAIN)
    def string(Optional<String> name) {
        def message = name.present ? "Hello, ${name.get()}!" : "Hello, world!"
        eventProducer.send(message)

        return "OK (string)"
    }

}
