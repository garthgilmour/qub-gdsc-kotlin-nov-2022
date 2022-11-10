package functions.using.the.toolkit

import functions.using.the.toolkit.model.Course
import functions.using.the.toolkit.model.CourseType
import functions.using.the.toolkit.model.CourseType.ADVANCED
import functions.using.the.toolkit.model.CourseType.BEGINNER
import kotlin.collections.Map.Entry

fun printTabbed(input: Any) = println("\t$input")
fun printTitle(title: String) = println(title)
fun printLine() = println("--------")

fun List<String>.combinations(): List<Pair<String, String>> {
    val results = ArrayList<Pair<String, String>>()
    for (str1 in this) {
        for (str2 in this) {
            if (!str1.equals(str2)) {
                if (!results.contains(Pair(str2, str1))) {
                    results.add(Pair(str1, str2))
                }
            }
        }
    }
    return results
}

fun titlesOfCourses(courses: List<Course>) {
    printTitle("Titles of courses:")
    courses.map { it.title }.forEach(::printTabbed)
    printLine()
}

fun titlesOfCoursesWithoutATrainer(courses: List<Course>) {
    printTitle("Titles of courses without a trainer:")
    courses.filter { it.instructors.isEmpty() }
            .map { it.title }
            .forEach(::printTabbed)
    printLine()
}

fun namesAndRatesOfTrainers(courses: List<Course>) {
    printTitle("Names and rates of trainers:")
    courses.flatMap { it.instructors }
            .toSet()
            .map { Pair(it.name, it.rate) }
            .forEach(::printTabbed)
    printLine()
}

fun theNumberOfAdvancedCourses(courses: List<Course>) {
    printTitle("The number of advanced courses:")
    printTabbed(courses.count { it.courseType == ADVANCED })
    printLine()
}

fun totalDurationsOfBeginnerAndNonBeginnerCourses(courses: List<Course>) {
    printTitle("Total days for both beginner and non-beginner courses")
    val splitCourses = courses.partition { it.courseType == BEGINNER }
    val beginnerDuration = splitCourses.first.map { it.duration }.sum()
    val nonBeginnerDuration = splitCourses.second.map { it.duration }.sum()
    printTabbed(Pair(beginnerDuration, nonBeginnerDuration))
    printLine()
}

fun everyPairOfTrainersThatCouldDeliverJava(courses: List<Course>) {
    printTitle("Pairs of trainers that could deliver Java")
    courses.flatMap { it.instructors }
            .distinct()
            .filter { it.skills.contains("Java") }
            .map { it.name }
            .combinations()
            .forEach { printTabbed("${ it.first } and ${ it.second }") }
    printLine()
}

fun possibleCostsOfJeeWebDevelopment(courses: List<Course>) {
    printTitle("Possible costs of 'JEE Web Development'")
    val course = courses.find { it.title.equals("JEE Web Development") }
    val duration = course?.duration ?: 0
    val namesAndCosts = course?.instructors?.map { Pair(it.name, it.rate * duration) }
    namesAndCosts?.forEach(::printTabbed)
    printLine()
}

fun coursesIdsAndTitlesGroupedByType(courses: List<Course>) {
    fun process(entry: Entry<CourseType, List<Course>>) {
        printTabbed(entry.key)
        entry.value.forEach { println("\t\t${ it.id } ${ it.title }") }
    }
    printTitle("Course ID's and titles grouped by type")
    courses.groupBy { it.courseType }
            .forEach(::process)
}
