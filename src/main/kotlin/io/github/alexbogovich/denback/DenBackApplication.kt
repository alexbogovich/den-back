package io.github.alexbogovich.denback

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DenBackApplication

fun main(args: Array<String>) {
    runApplication<DenBackApplication>(*args)
}
