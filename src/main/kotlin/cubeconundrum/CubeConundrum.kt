package cubeconundrum

import readAllLines

fun cubeConPart01() {
    val result = evaluatePart01(readAllLines("day02/input.txt"))
    println("CubeConundrum Part01: $result")
}

fun cubeConPart02() {
    val result = evaluatePart02(readAllLines("day02/input.txt"))
    println("CubeConundrum Part02: $result")
}

fun evaluatePart01(lines: List<String>): Int {
    val maxCubes = MaxCubes(12, 13, 14)
    return lines
        .map {
            parseGame(it)
        }
        .filter {
            it.isPossible(maxCubes)
        }.sumOf {
            it.id
        }
}

fun evaluatePart02(lines: List<String>): Int {
    return lines
        .map {
            parseGame(it)
        }
        .map {
            it.findMinimalCubesNeeded()
        }
        .sumOf {
            it.calculateCubePower()
        }
}


fun parseGame(game: String): GameData {
    val (gameData, draws) = game.split(":", limit = 2)
    val gameId = gameData
        .split("Game ", limit = 2)
        .let {
            it[1].toInt()
        }
    val cubeDraws = parseDraws(draws)
    return GameData(gameId, cubeDraws)
}

fun parseDraws(draws: String): List<CubeDraws> {
    if (draws.isBlank()) return emptyList()
    return draws
        .split(";")
        .map { parseDraw(it) }
}

fun parseDraw(draw: String): CubeDraws {
    var red = 0
    var green = 0
    var blue = 0
    draw.split(",")
        .forEach { cube ->
            cube.trim()
                .split(" ")
                .let {
                    val cnt = it[0].toInt()
                    val color = it[1]
                    if (color == "red")
                        red = cnt
                    if (color == "green")
                        green = cnt
                    if (color == "blue")
                        blue = cnt
                }
        }
    return CubeDraws(red, green, blue)
}

fun GameData.isPossible(maxCubes: MaxCubes): Boolean {
    val minCubesNeeded = this.findMinimalCubesNeeded()
    return minCubesNeeded.red <= maxCubes.red
            && minCubesNeeded.green<= maxCubes.green
            && minCubesNeeded.blue <= maxCubes.blue
}


fun GameData.findMinimalCubesNeeded(): MinimalNeededCubes {
    var minRed = 0
    var minGreen = 0
    var minBlue = 0
    this.draws.forEach { draw ->
        if (draw.red > minRed) minRed = draw.red
        if (draw.green > minGreen) minGreen = draw.green
        if (draw.blue > minBlue) minBlue = draw.blue
    }
    return MinimalNeededCubes(minRed, minGreen, minBlue)
}

fun MinimalNeededCubes.calculateCubePower() = this.red.zeroIsOne() * this.green.zeroIsOne() * this.blue.zeroIsOne()
fun Int.zeroIsOne() = if (this == 0) 1 else this
