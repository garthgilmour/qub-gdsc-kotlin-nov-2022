package com.instil

import io.ktor.server.engine.*
import io.ktor.server.netty.*

import com.instil.courses.services.configureTrainingCourses
import io.ktor.serialization.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureHTTP()
        configureStaticRouting()
        configureSerialization()
        configureErrorHandling()
        configureTrainingCourses()
    }.start(wait = true)
}

fun Application.configureHTTP() {
    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        anyHost() //Not to be used in production
    }
}

fun Application.configureStaticRouting() {
    routing {
        get ("/") {
            call.respondRedirect("static/courses.html")
        }
        static("/static") {
            resources("static")
        }
    }
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}

fun Application.configureErrorHandling() {
    install(StatusPages) {
        exception<DeletionException> { cause ->
            call.respondText(
                "[\"Root cause was - ${cause.message}\"]",
                status = HttpStatusCode.Forbidden
            )
        }
    }
}
