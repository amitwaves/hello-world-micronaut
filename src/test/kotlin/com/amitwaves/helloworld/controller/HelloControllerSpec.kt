package com.amitwaves.helloworld.controller

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object HelloControllerSpec: Spek({
    describe("calling /hello endpoint") {
        var server : EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        var client : HttpClient = HttpClient.create(server.url)

        it("should respond Hello World from Kotlin on success") {
            var expected = "Hello World from Kotlin"
            var actual : String = client.toBlocking().retrieve("/hello")
            actual.equals(expected)
        }
        afterGroup {
            client.close()
            server.close()
        }
    }
})