const val ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
const val WORD_FILENAME = "words.txt"

class Game {
    private val word by lazy { WordList.fromFile(WORD_FILENAME).getRandom() }
    private var mistakes = 0
    private var attempts = 0

    fun step(): GameState {
        println()
        println(HangmanState.ofMistakes(mistakes))
        println(word.toString())

        if (word.isGuessed()) {
            println("Вы выиграли! Было загадано слово: ${word.original()}")
            return GameState.WON
        }

        if (mistakes >= 6) {
            println("Вы проиграли, у вас закончились попытки. Было загадано слово: ${word.original()}")
            return GameState.LOST
        }

        print("Буква: ")
        val letter = readln().uppercase().firstOrNull() ?: return GameState.RUNNING
        attempts++

        if (word.guess(letter)) {
            println("Вы угадали!")
        } else {
            println("Вы не угадали!")
            mistakes++
        }

        return GameState.RUNNING
    }
}