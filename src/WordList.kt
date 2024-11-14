import java.io.File

class WordList(private val words: List<String>) {
    fun getRandom(): Word {
        return Word(words.random())
    }

    companion object {
        fun fromFile(fileName: String): WordList {
            val words = mutableListOf<String>()
            val file = File(fileName)
            file.forEachLine {
                words.add(it.trim().uppercase())
            }
            return WordList(words.filter { it.isNotEmpty() })
        }
    }
}