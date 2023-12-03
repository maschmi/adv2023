import java.io.BufferedReader
import java.io.IOException

fun openResource(path: String): BufferedReader =
    object {}.javaClass.getResourceAsStream(path)?.bufferedReader()
        ?: throw IOException("Error reading file at $path")

fun readAllLines(path: String): List<String> = openResource(path).readLines()
