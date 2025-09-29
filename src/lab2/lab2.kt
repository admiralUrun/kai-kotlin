package lab2

import java.io.File

fun removeExtraSpaces(text: String): Pair<String, Int> {
    val originalSpaces = text.count { it == ' ' }

    val cleaned = text.trim().replace(Regex("\\s+"), " ")

    val newSpaces = cleaned.count { it == ' ' }

    val removed = originalSpaces - newSpaces

    return Pair(cleaned, removed)
}


fun sortMatrixByKIndex(k: Int) {
    fun printMatrix(matrix: List<List<Int>>) {
        for (row in matrix) {
            println(row.joinToString(" "))
        }
    }

    val inputFile = File("src/lab2/input.txt")

    try {
        if (!inputFile.exists()) {
            println("Файл input.txt не знайдено!")
            return
        }

        val matrix = inputFile
            .readLines()
            .filter { it.isNotBlank() }
            .map { line ->
                line.trim().split(Regex("\\s+")).map { it.toInt() }
            }

        printMatrix(matrix)

        val matrixSorted = matrix.sortedByDescending { it[k] }

        println("Сортована матриця")
        printMatrix(matrixSorted)

        val result = matrixSorted.joinToString("\n") { row -> row.joinToString(" ") }

        File("src/lab2/output.txt").writeText(result)

        println("Результат записано у output.txt ✅")

    } catch (e: Exception) {
        println("Помилка: ${e.message}")
    }
}

fun main() {
    val text = "Це     приклад   тексту   з   зайвими     пробілами."
    val (result, removed) = removeExtraSpaces(text)

    println("Початковий текст: \"$text\"")
    println("Очищений текст:   \"$result\"")
    println("Кількість видалених пробілів: $removed")
    println("--------")

    sortMatrixByKIndex(1)


}
