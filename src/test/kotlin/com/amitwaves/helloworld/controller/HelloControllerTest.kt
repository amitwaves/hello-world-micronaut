package com.amitwaves.helloworld.controller

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec
import io.micronaut.http.client.annotation.Client
import io.micronaut.rxjava2.http.client.RxHttpClient
import io.micronaut.test.extensions.junit5.annotation.MicronautTest

@MicronautTest
class HelloControllerTest(@Client("/") private val client: RxHttpClient) : BehaviorSpec({
    given("/hello endpoint") {
        `when`("/hello endpoint is called") {
            then("will return result string Hello World from Kotlin") {
                var expected = "Hello World from Kotlin on success"
                var actual: String = client.toBlocking().retrieve("/hello")
                actual shouldBe expected
            }
        }
    }
})