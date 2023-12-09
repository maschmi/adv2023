package gearratios

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class GearRatiosKtTest : FunSpec({

    context("Part 01") {
        val schematic = EngineSchematic(
            listOf(
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."
            )
        )

        test("should return 4361") {
            evaluatePart01(schematic) shouldBe 4361
        }
    }
})
