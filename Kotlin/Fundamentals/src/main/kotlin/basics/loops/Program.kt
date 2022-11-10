package basics.loops

import java.lang.Integer.parseInt
import java.util.Scanner

fun main() {
    println("Enter the height of the pyramid")
    val height = parseInt(readLine())

    pyramidViaFor(height)
    printSpacer()
    pyramidViaWhile(height)
    printSpacer()
    pyramidViaDoWhile(height)
    printSpacer()
    pyramidViaFP(height)
}

fun printSpacer() {
    println("--------------------")
}
fun pyramidViaFP(height: Int) {
    (1..height).forEach { rowNum ->
        val spaces = height - rowNum
        val hashes = (rowNum * 2) - 1

        (1..spaces).forEach { print(' ') }
        (1..hashes).forEach { print('#') }
        println()
    }
}
fun pyramidViaFor(height: Int) {
    for (rowNum in 1..height) {
        val spaces = height - rowNum
        val hashes = (rowNum * 2) - 1

        for (x in 1..spaces) print(' ')
        for (x in 1..hashes) print('#')
        println()
    }
}

fun pyramidViaWhile(height: Int) {
    fun printSpaces(spaces: Int) {
        var x = 0
        while (x < spaces) {
            print(' ')
            x++
        }
    }
    fun printHashes(hashes: Int) {
        var x = 0
        while (x < hashes) {
            print('#')
            x++
        }
    }
    var rowNum = 1
    while (rowNum <= height) {
        printSpaces(height - rowNum)
        printHashes((rowNum * 2) - 1)
        rowNum++
        println()
    }
}

fun pyramidViaDoWhile(height: Int) {
    fun printSpaces(spaces: Int) {
        var x = 0
        do {
            print(' ')
            x++
        } while (x <= spaces)
    }
    fun printHashes(hashes: Int) {
        var x = 0
        do {
            print('#')
            x++
        } while (x < hashes)
    }
    var rowNum = 1
    do {
        printSpaces(height - rowNum)
        printHashes((rowNum * 2) - 1)
        rowNum++
        println()
    } while (rowNum <= height)
}
