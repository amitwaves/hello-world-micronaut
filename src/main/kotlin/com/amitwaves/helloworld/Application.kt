package com.amitwaves.helloworld

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.amitwaves.helloworld")
                .mainClass(Application.javaClass)
                .start()
    }
}