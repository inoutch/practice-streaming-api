package io.github.inoutch.grpcspringbootstarter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class GrpcSpringBootStarterApplication

fun main(args: Array<String>) {
    runApplication<GrpcSpringBootStarterApplication>(*args)
}
