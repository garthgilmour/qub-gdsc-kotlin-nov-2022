package functions.using.the.toolkit

import functions.using.the.toolkit.model.Course
import functions.using.the.toolkit.model.CourseType.BEGINNER
import functions.using.the.toolkit.model.CourseType.INTERMEDIATE
import functions.using.the.toolkit.model.CourseType.ADVANCED
import functions.using.the.toolkit.model.Trainer

fun buildData(): List<Course> {
    val dave = Trainer("Dave Jones", 500.0, listOf("SQL", "Perl", "PHP"))
    val jane = Trainer("Jane Smith", 750.0, listOf("SQL", "Java", "JEE"))
    val pete = Trainer("Pete Hughes", 1000.0, listOf("Java", "JEE", "C#", "Scala"))
    val mary = Trainer("Mary Donaghy", 1250.0, listOf("Java", "JEE", "C#", "C++"))

    return arrayListOf(Course("AB12", "Intro to Scala", BEGINNER, 4, arrayListOf(pete)),
            Course("CD34", "JEE Web Development", INTERMEDIATE, 3, arrayListOf(pete, mary, jane)),
            Course("EF56", "Meta-Programming in Ruby", ADVANCED, 2, arrayListOf()),
            Course("GH78", "OO Design with UML", BEGINNER, 3, arrayListOf(jane, pete, mary)),
            Course("IJ90", "Database Access with JPA", INTERMEDIATE, 3, arrayListOf(jane)),
            Course("KL12", "Design Patterns in C#", ADVANCED, 2, arrayListOf(pete, mary)),
            Course("MN34", "Relational Database Design", BEGINNER, 4, arrayListOf(jane, dave)),
            Course("OP56", "MySql Stored Procedures", INTERMEDIATE, 1, arrayListOf(jane, dave)),
            Course("QR78", "Parallel Programming", ADVANCED, 2, arrayListOf(pete, mary)),
            Course("ST90", "C++ Programming for Beginners", BEGINNER, 5, arrayListOf(mary)),
            Course("UV12", "UNIX Threading with PThreads", INTERMEDIATE, 2, arrayListOf()),
            Course("WX34", "Writing Linux Device Drivers", ADVANCED, 3, arrayListOf(mary)))
}

fun main() {
    val data = buildData()
    titlesOfCourses(data)
    titlesOfCoursesWithoutATrainer(data)
    namesAndRatesOfTrainers(data)
    theNumberOfAdvancedCourses(data)
    totalDurationsOfBeginnerAndNonBeginnerCourses(data)
    everyPairOfTrainersThatCouldDeliverJava(data)
    possibleCostsOfJeeWebDevelopment(data)
    coursesIdsAndTitlesGroupedByType(data)
}
