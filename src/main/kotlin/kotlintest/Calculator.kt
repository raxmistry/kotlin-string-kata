package kotlintest

class Calculator {
    fun add(input: String): Int {
        var total = 0
        if (input.isBlank()) {
            return total
        }

        if (input.startsWith("//")) {
            val splitInput = input.split(Regex("\n"))
            val customDelimiter = getCustomDelimiter(splitInput)
            val values = splitStringOnDelimiter(customDelimiter, splitInput.get(1))
            total = values.fold(0) { total, s -> total + s.toInt() }
        } else {
            val delimiter = ",|\n"
            val values = splitStringOnDelimiter(input, delimiter)
            total = values.fold(0) { total, s -> total + s.toInt() }
        }
        return total
    }

    private fun splitStringOnDelimiter(customDelimiter: String, valueString: String): List<String> {
        val values = valueString.split(customDelimiter)
        return values
    }

    private fun getCustomDelimiter(splitInput: List<String>): String {
        val customDelimiter = splitInput.get(0).removePrefix("//")
        return customDelimiter
    }
}
