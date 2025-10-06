import kotlin.math.pow

tailrec fun divideViaSubcontract(base: Double, on: Double, acc: Double = 0.0): Double {
    return if (base <= 0) acc else divideViaSubcontract(base - on, on, acc + 1)
}

tailrec fun multiplication(base: Double, on: Double, acc: Double = 0.0): Double {
    return if (on <= 0) acc else multiplication(base, on - 1, acc + base)
}


tailrec fun factorial(n: Int, acc: Long = 1): Long {
    return if (n <= 1) acc else factorial(n - 1, acc * n)
}

tailrec fun pow(base: Double, to: Int, acc: Double = 1.0): Double {
    return if (to <= 0) acc else pow(base, to -1, acc * base)
}


fun fullSum(N: Int): Double {
    var sum = 0.0
    var n = 1

    while (n <= N) {
        val numerator = pow(3.0, n) * factorial(n).toDouble()
        val denominator = pow (n.toDouble(), n)
        val term = numerator / denominator
        sum += term
        println(sum)
        n +=1
    }
    return sum
}



fun main() {
    assert(multiplication(10.0, 2.0) == 10.0 * 2)
    assert(divideViaSubcontract(50.0, 10.0) == 50.0 / 10)
    println(fullSum(10))
}