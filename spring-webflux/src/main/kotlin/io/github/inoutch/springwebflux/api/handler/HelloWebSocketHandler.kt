package io.github.inoutch.springwebflux.api.handler

import org.springframework.stereotype.Component
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketMessage
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono
import java.time.Duration

@Component
class HelloWebSocketHandler : WebSocketHandler {

    override fun handle(session: WebSocketSession): Mono<Void> {
        val factory = session.bufferFactory()

        return session.send(
                session.receive()
                        .map { WebSocketMessage(WebSocketMessage.Type.TEXT, factory.wrap(it.payloadAsText.toByteArray())) }
                        .delayElements(Duration.ofSeconds(2L))
                        .doAfterTerminate { println("terminated!") })
    }
}
