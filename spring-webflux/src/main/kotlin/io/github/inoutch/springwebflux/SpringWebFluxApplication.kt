package io.github.inoutch.springwebflux


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SpringWebFluxApplication

fun main(args: Array<String>) {
    runApplication<SpringWebFluxApplication>(*args)
}
