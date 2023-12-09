package gearratios

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class EngineSchematicTest: StringSpec({
    "should construct EngineSchematic correctly from a list of Strings of equal length" {
        val data = listOf(
            "line1",
            "line2",
            "line3"
        )
        val schematic = EngineSchematic(data)
        schematic.lines shouldBe data
    }

    "should construct EngineSchematic correctly from a list of Strings" {
        val data = listOf(
            "line1",
            "line2",
            "line3"
        )
        val schematic = EngineSchematic(data)
        schematic.lines shouldBe data
    }

    "should retain the order of input data" {
        val data = listOf(
            "line1",
            "line2",
            "line3"
        )
        val schematic = EngineSchematic(data)
        schematic.lines[0] shouldBe "line1"
        schematic.lines[1] shouldBe "line2"
        schematic.lines[2] shouldBe "line3"
    }

    "should construct EngineSchematic correctly from a list of equally long Strings and set x and y correctly" {
        val data = listOf(
            "1234",
            "5678",
            "abcd"
        )
        val schematic = EngineSchematic(data)

        schematic.lines shouldBe data
        schematic.x shouldBe 4
        schematic.y shouldBe 3
    }

    "should throw an exception with list of Strings of unequal length and x and y should not be set" {
        val data = listOf(
            "12",
            "4567",
            "abcd"
        )

        shouldThrow<IllegalArgumentException> {
            val schematic = EngineSchematic(data)
            schematic.x shouldBe 0
            schematic.y shouldBe 0
        }
    }

})
