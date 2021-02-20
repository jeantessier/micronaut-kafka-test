package producer.app.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import javax.inject.*

import producer.app.event.Event
import producer.app.event.EventProducer

@Controller("/")
class HelloController {

    @Inject
    EventProducer eventProducer

    @Get(produces = MediaType.TEXT_PLAIN)
    def index(Optional<String> name) {
        def message = name.present ? "Hello, ${name.get()}!" : "Hello, world!"
        eventProducer.send(new Event(message: message, date: new Date()))

        return "OK"
    }

}
