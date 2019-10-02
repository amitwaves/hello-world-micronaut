package com.amitwaves.helloworld.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello")
class HelloWorldController {
    @Get(produces = [MediaType.TEXT_PLAIN])
    fun get(): String {
        return "Hello World from Kotlin"
    }
}