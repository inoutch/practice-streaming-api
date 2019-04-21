package io.github.inoutch.springwebflux.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration

@RestController
@RequestMapping("hello")
class HelloRestController {
    private val streamResponse = Flux.just("hel", "lo ", "wor", "ld!")

    @GetMapping
    fun index(): Flux<String> {
        return streamResponse
    }

    @GetMapping("lazy")
    fun lazy() = streamResponse.delayElements(Duration.ofSeconds(1))
}
