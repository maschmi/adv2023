package cubeconundrum

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.shouldBe


class CubeConundrumKtTest : FunSpec({

    val input = listOf(
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
    )

    context("Part 01") {
        test("should return 8") {
            evaluatePart01(input) shouldBe 8
        }

        test("parse game") {
            parseGame(input[0]) shouldBeEqual GameData(
                1,
                listOf(
                    CubeDraws(4, 0, 3),
                    CubeDraws(1, 2, 6),
                    CubeDraws(0, 2, 0)
                )
            )
        }

        test("parse multi digit game id") {
            val line = "Game 123:"
            parseGame(line) shouldBeEqual GameData(
                123,
                emptyList()
            )
        }


        test("should be a possible game") {
            val game = GameData(
                1,
                listOf(
                    CubeDraws(4, 0, 3),
                    CubeDraws(1, 2, 6),
                    CubeDraws(0, 2, 0)
                )
            )
            val maxCubes = MaxCubes(6, 6, 6)
            game.isPossible(maxCubes) shouldBe true
        }

        test("should be a not possible game") {
            val game = GameData(
                1,
                listOf(
                    CubeDraws(4, 0, 3),
                    CubeDraws(1, 2, 6),
                    CubeDraws(0, 2, 0)
                )
            )
            val maxCubes = MaxCubes(5, 1, 1)
            game.isPossible(maxCubes) shouldBe false
        }
    }

    context("Part 02") {
        test("should return 2286") {
            evaluatePart02(input) shouldBe 2286
        }

        test("should return minimal cubes possible") {
            val game = GameData(
                1,
                listOf(
                    CubeDraws(4, 0, 3),
                    CubeDraws(1, 2, 6),
                    CubeDraws(0, 2, 0)
                )
            )
            game.findMinimalCubesNeeded() shouldBeEqual MinimalNeededCubes(4, 2, 6)
        }

        test("should return power of cubes") {
            MinimalNeededCubes(4, 2, 6).calculateCubePower() shouldBe 48
        }
    }
})

