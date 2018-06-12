package org.hp.springboot.kotlin.seed

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebMvc
class SbKotlinSeedApplication

fun main(args: Array<String>) {
    runApplication<SbKotlinSeedApplication>(*args)
}