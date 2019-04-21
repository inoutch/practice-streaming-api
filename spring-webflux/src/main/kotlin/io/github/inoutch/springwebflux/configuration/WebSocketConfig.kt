package io.github.inoutch.springwebflux.configuration

import io.github.inoutch.springwebflux.api.handler.HelloWebSocketHandler
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter
import java.util.HashMap
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.HandlerMapping
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping


@Configuration
open class WebSocketConfig(private val helloHandler: HelloWebSocketHandler) {

    @Bean
    open fun webSocketMapping(): HandlerMapping {
        val map = HashMap<String, WebSocketHandler>().also {
            it["/hello"] = helloHandler
        }

        return SimpleUrlHandlerMapping().apply {
            urlMap = map
            order = -1 // before annotated controllers
        }
    }

    @Bean
    open fun handlerAdapter() = WebSocketHandlerAdapter()
}
