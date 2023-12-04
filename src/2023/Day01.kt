package `2023`

import println
import readInput

fun main() {

    val numbers = (0..9).map { "$it" }.toList()

    fun findNumberString(input: List<String>, strings: List<String>) = input.sumOf {
        "${it.findAnyOf(strings)!!.second}${it.findLastAnyOf(strings)!!.second}".toInt()
    }

    fun part1(input: List<String>): Int {
        return findNumberString(input, numbers)
    }
    check(part1(listOf("1abc2")) == 12)
    check(part1(listOf("pqr3stu8vwx")) == 38)
    check(part1(listOf("a1b2c3d4e5f")) == 15)
    check(part1(listOf("treb7uchet")) == 77)

    fun part2(input: List<String>): Int {
        val updatedInput = input.map {
            it.replace("one", "o1e")
                .replace("two", "t2o")
                .replace("three", "t3e")
                .replace("four", "4")
                .replace("five", "5e")
                .replace("six", "6")
                .replace("seven", "7n")
                .replace("eight", "e8t")
                .replace("nine", "9e")
        }
        return findNumberString(updatedInput, numbers)
    }

    check(part2(listOf("two1nine")) == 29)
    check(part2(listOf("eightwothree")) == 83)
    check(part2(listOf("abcone2threexyz")) == 13)
    check(part2(listOf("xtwone3four")) == 24)
    check(part2(listOf("4nineeightseven2")) == 42)
    check(part2(listOf("zoneight234")) == 14)
    check(part2(listOf("7pqrstsixteen")) == 76)

    val input = readInput("2023/Day01")
    part1(input).println()
    part2(input).println()
}
