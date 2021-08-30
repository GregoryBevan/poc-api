package me.elgregos.pocapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PocapiApplication

fun main(args: Array<String>) {
	runApplication<PocapiApplication>(*args)
}
