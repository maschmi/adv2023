package trebuchet

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TrebuchetKtTest : DescribeSpec({

    describe("part 01") {
        val testCases = mapOf(
            Pair("1abc2", 12),
            Pair("pqr3stu8vwx", 38),
            Pair("a1b2c3d4e5f", 15),
            Pair("treb7uchet", 77)
        )

        testCases.forEach {
            it("parse " + it.key + " should be " + it.value) {
                parseLineOnlyDigits(it.key) shouldBe it.value
            }
        }

        it("should sum up to 142") {
            val input = TrebuchetData(testCases.keys.toList())
            input.evaluatePart01() shouldBe 142
        }
    }

    describe("part 02") {
        val testCases = mapOf(
            Pair("two1nine", 29),
            Pair("eightwothree", 83),
            Pair("abcone2threexyz", 13),
            Pair("xtwone3four", 24),
            Pair("4nineeightseven2", 42),
            Pair("zoneight234", 14),
            Pair("7pqrstsixteen", 76)
        )

        testCases.forEach {
            it("parse " + it.key + " should be " + it.value) {
                parseLineDigitsAndWords(it.key) shouldBe it.value
            }
        }

        it("should sum up to 281") {
            val input = TrebuchetData(testCases.keys.toList())
            input.evaluatePart02() shouldBe 281
        }
    }
})