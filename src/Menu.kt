object Menu {
    fun show(): Boolean {
        println()
        println("В И С Е Л И Ц А")
        println("1. Начать игру")
        println("2. Выход")
        print("Выберите пункт меню: ")

        return when (readln().toIntOrNull()) {
            1 -> true
            2 -> false
            else -> show()
        }
    }
}