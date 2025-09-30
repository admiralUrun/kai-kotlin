open class Row(private var content: String) {

    val length: Int
        get() = content.length

    open fun replaceSymbol(): String {
        return content
    }

    fun getContent(): String = content

    protected fun setContent(newContent: String) {
        content = newContent
    }
}

class Symbol(content: String) : Row(content) {
    override fun replaceSymbol(): String {
        val replaced = getContent().replace("#", "!!")
        setContent(replaced)
        return replaced
    }
}

class Digit(content: String) : Row(content) {
    override fun replaceSymbol(): String {
        val replaced = getContent().replace("3", "11")
        setContent(replaced)
        return replaced
    }
}

fun main() {
    val s1 = Symbol("Привіт#світ#Kotlin")
    val s2 = Digit("123456789")

    println("=== Клас Symbol ===")
    println("Початковий рядок: ${s1.getContent()}")
    println("Довжина: ${s1.length}")
    println("Після заміни: ${s1.replaceSymbol()}")
    println("Довжина після заміни: ${s1.length}")

    println("\n=== Клас Digit ===")
    println("Початковий рядок: ${s2.getContent()}")
    println("Довжина: ${s2.length}")
    println("Після заміни: ${s2.replaceSymbol()}")
    println("Довжина після заміни: ${s2.length}")
}
