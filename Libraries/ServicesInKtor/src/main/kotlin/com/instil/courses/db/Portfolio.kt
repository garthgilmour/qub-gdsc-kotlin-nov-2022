package com.instil.courses.db

import com.instil.courses.model.Course
import com.instil.courses.model.CourseDifficulty.*

fun buildPortfolio(): MutableMap<String, Course> {
    fun entry(course: Course) = course.id to course

    return mutableMapOf(
        entry(Course("AB12", "Intro to Scala", BEGINNER, 4)),
        entry(Course("CD34", "JEE Web Development", INTERMEDIATE, 3)),
        entry(Course("EF56", "Meta-Programming in Ruby", ADVANCED, 2)),
        entry(Course("GH78", "OO Design with UML", BEGINNER, 3)),
        entry(Course("IJ90", "Database Access with JPA", INTERMEDIATE, 3)),
        entry(Course("KL12", "Design Patterns in C#", ADVANCED, 2)),
        entry(Course("MN34", "Relational Database Design", BEGINNER, 4)),
        entry(Course("OP56", "Writing MySql Stored Procedures", INTERMEDIATE, 1)),
        entry(Course("QR78", "Patterns of Parallel Programming", ADVANCED, 2)),
        entry(Course("ST90", "C++ Programming for Beginners", BEGINNER, 5)),
        entry(Course("UV12", "UNIX Threading with PThreads", INTERMEDIATE, 2)),
        entry(Course("WX34", "Writing Linux Device Drivers", ADVANCED, 3))
    )
}
