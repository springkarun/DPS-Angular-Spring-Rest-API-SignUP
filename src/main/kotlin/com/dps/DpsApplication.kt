package com.dps

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DpsApplication

fun main(args: Array<String>) {
    runApplication<DpsApplication>(*args)
}
