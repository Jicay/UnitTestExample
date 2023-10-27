package com.jicay.unittests

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UnitTestsApplication

fun main(args: Array<String>) {
	runApplication<UnitTestsApplication>(*args)
}
