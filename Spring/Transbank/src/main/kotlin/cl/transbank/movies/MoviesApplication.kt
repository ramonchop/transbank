package cl.transbank.movies

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
open class MoviesApplication

fun main(args: Array<String>) {
    SpringApplication.run(MoviesApplication::class.java, *args)
}