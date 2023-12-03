package cubeconundrum

data class GameData(val id: Int, val draws: List<CubeDraws>)

data class CubeDraws(val red: Int, val green: Int, val blue: Int)
