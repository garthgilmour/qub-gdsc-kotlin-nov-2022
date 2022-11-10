package com.instil.courses.services

import com.instil.DeletionException
import com.instil.courses.db.buildPortfolio
import com.instil.courses.model.Course
import com.instil.courses.model.CourseDifficulty
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*

val portfolio = buildPortfolio()

fun Application.configureTrainingCourses() {
    routing {
        route("/courses") {
            get("/") {
                val courses = portfolio.values.toList()
                val queryParam = call.request.queryParameters["type"]

                val output = if (queryParam == null || queryParam == "All") {
                    courses
                } else {
                    val type = CourseDifficulty.valueOf(queryParam)
                    courses.filter { it.difficulty == type }
                }
                call.response.headers.append("NumCourses", output.size.toString())
                call.respond(output)
            }
            get("/{id}") {
                val pathParam = call.parameters["id"]
                val course = portfolio[pathParam]
                if (course == null) {
                    call.respondText(
                        "No course with id $pathParam",
                        status = HttpStatusCode.NotFound
                    )
                } else {
                    call.respond(course)
                }
            }
            put("/{id}") {
                val newCourse = call.receive<Course>()
                val pathParam = call.parameters["id"] ?: newCourse.id
                portfolio[pathParam] = newCourse
                call.respond(HttpStatusCode.NoContent)
            }
            delete("/{id}") {
                val pathParam = call.parameters["id"]
                if (portfolio.containsKey(pathParam)) {
                    if (portfolio[pathParam]!!.title.contains("Scala")) {
                        throw DeletionException("Cannot remove Scala courses!")
                    }
                    portfolio.remove(pathParam)
                    call.respondText("[\"Removed $pathParam\"]")
                } else {
                    call.respondText(
                        "No course to delete with id $pathParam",
                        status = HttpStatusCode.NotFound
                    )
                }
            }
        }
    }
}
