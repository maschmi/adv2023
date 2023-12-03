package trebuchet

import readAllLines

fun trebuchetPart01() {
    val result = TrebuchetData(readAllLines("day01/input.txt"))
        .evaluatePart01()
    println("Trebuchet result part 01: $result")
}
fun trebuchetPart02() {
    val result = TrebuchetData(readAllLines("day01/input.txt"))
        .evaluatePart02()
    println("Trebuchet result part 02: $result")
}

fun TrebuchetData.evaluatePart01(): Int {
    return lines.sumOf {
        parseLineOnlyDigits(it)
    }
}

fun TrebuchetData.evaluatePart02(): Int {
    return lines.sumOf {
        parseLineDigitsAndWords(it)
    }
}


fun parseLineOnlyDigits(line: String): Int {
    val firstDigit = line.find { it.isDigit() }
    val lastDigit = line.findLast { it.isDigit() }
    return "$firstDigit$lastDigit".toInt()
}

fun parseLineDigitsAndWords(line: String): Int {
    val keys = NumberWord.entries.flatMap {
        listOf(it.digit, it.word)
    }
    val firstDigit = line.findAnyOf(keys)?.second?.toNumberWord()
        ?: throw IllegalArgumentException("No number found")
    val lastDigit = line.findLastAnyOf(keys)?.second?.toNumberWord()
        ?: throw IllegalArgumentException("No number found")
    return "${firstDigit.digit}${lastDigit.digit}".toInt()
}


fun String.toNumberWord(): NumberWord {
    return when (this) {
        NumberWord.ONE.word, NumberWord.ONE.digit -> NumberWord.ONE
        NumberWord.TWO.word, NumberWord.TWO.digit -> NumberWord.TWO
        NumberWord.THREE.word, NumberWord.THREE.digit -> NumberWord.THREE
        NumberWord.FOUR.word, NumberWord.FOUR.digit -> NumberWord.FOUR
        NumberWord.FIVE.word, NumberWord.FIVE.digit -> NumberWord.FIVE
        NumberWord.SIX.word, NumberWord.SIX.digit -> NumberWord.SIX
        NumberWord.SEVEN.word, NumberWord.SEVEN.digit -> NumberWord.SEVEN
        NumberWord.EIGHT.word, NumberWord.EIGHT.digit -> NumberWord.EIGHT
        NumberWord.NINE.word, NumberWord.NINE.digit -> NumberWord.NINE
        else -> throw IllegalArgumentException("must be a NumberWord")
    }
}

enum class NumberWord(val word: String, val digit: String) {
    ONE("one", "1"),
    TWO("two", "2"),
    THREE("three", "3"),
    FOUR("four", "4"),
    FIVE("five", "5"),
    SIX("six", "6"),
    SEVEN("seven", "7"),
    EIGHT("eight", "8"),
    NINE("nine", "9"),
}
