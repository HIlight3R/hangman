class Word(str: String) {
    private val letters = str.toSet()
    private val guessedLetters = mutableSetOf<Char>()
    private val unguessedLetters
        get() = letters - guessedLetters

    override fun toString() = letters.joinToString(" ") { if (it in guessedLetters) it.toString() else "_" }

    fun original() = letters.joinToString("")

    fun guess(letter: Char): Boolean = guessedLetters.add(letter.uppercaseChar())

    fun isGuessed() = unguessedLetters.isEmpty()
}