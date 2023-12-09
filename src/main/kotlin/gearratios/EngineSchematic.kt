package gearratios

data class EngineSchematic(val lines: List<String>) {

    val y = lines.count()
    val x = lines.first().length

    init {
        verifyAllLinesSameLength(x)
    }

    private fun verifyAllLinesSameLength(firstLineLength: Int) {
        lines.forEach {
            require( it.length == firstLineLength) {
               "All lines must have same length"
            }
        }
    }
}


