package functions.standard.extensions

import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.*

fun main() {
    demoRun()
    demoApply()
    demoAlso()
    demoLet()
    demoTake()
}

fun printDate(msg: String, input: Date?) {
    print(msg)
    input?.let {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        print(dateFormat.format(input))
    }
    println()
}

fun demoRun() {
    val result: Date = calendar().run {
        set(DAY_OF_MONTH, 25)
        set(MONTH, 11)
        set(YEAR, 2020)
        time
    }
    printDate("Date via run ", result)
}

fun calendar() = Calendar.getInstance()

fun demoApply() {
    val result = calendar().apply {
        set(DAY_OF_MONTH, 25)
        set(MONTH, 11)
        set(YEAR, 2020)
    }
    printDate("Date via apply ", result.time)
}

fun demoAlso() {
    var date: Date
    calendar().apply {
        set(DAY_OF_MONTH, 25)
        set(MONTH, 11)
        set(YEAR, 2020)
    }.also { c -> date = c.time }

    printDate("Date via also ", date)
}

fun demoLet() {
    val date = calendar().let {
        it.set(DAY_OF_MONTH, 25)
        it.set(MONTH, 11)
        it.set(YEAR, 2020)
        it.time
    }
    printDate("Date via let ", date)
}

fun demoTake() {
    val calendar1 = calendar().apply {
        set(DAY_OF_MONTH, 25)
        set(MONTH, 11)
        set(YEAR, 2020)
    }
    val calendar2 = calendar1.takeIf { c -> c.after(Date()) }
    val calendar3 = calendar1.takeUnless { c -> c.before(Date()) }
    printDate("Date via takeIf  ", calendar2?.time)
    printDate("Date via takeUnless ", calendar3?.time)
}
