import kotlin.math.pow

tailrec fun divideViaSubcontract(base: Int, on: Int, acc: Int = 0): Int {
    return if (base <= 0) acc else divideViaSubcontract(base - on, on, acc + 1)
}

tailrec fun multiplication(base: Int, on: Int, acc: Int = 0): Int {
    return if (on <= 0) acc else multiplication(base, on - 1, acc + base)
}


tailrec fun factorial(n: Int, acc: Long = 1): Long {
    return if (n <= 1) acc else factorial(n - 1, acc * n)
}


fun fullSum(N: Int): Double {
    var sum = 0.0

    for (n in 1..N) {
        val numerator = (3.0).pow(n) * factorial(n).toDouble()
        val denominator = n.toDouble().pow(n)
        val term = numerator / denominator
        sum += term
    }
    return sum
}



fun main() {
    assert(multiplication(10, 2) == 10 * 2)
    assert(divideViaSubcontract(50, 10) == 50 / 10)
    println(fullSum(10))
}