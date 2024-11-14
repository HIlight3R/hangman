fun main() {
    while (Menu.show()) {
        val game = Game()
        while (game.step() == GameState.RUNNING) {
            // Do nothing
        }
    }
}