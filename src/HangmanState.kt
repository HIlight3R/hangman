object HangmanState {
    private fun getArt(
        head: Boolean,
        body: Boolean,
        leftArm: Boolean,
        rightArm: Boolean,
        leftLeg: Boolean,
        rightLeg: Boolean
    ): String {
        val headChar = if (head) 'O' else ' '
        val bodyChar = if (body) '|' else ' '
        val leftArmChar = if (leftLeg) '/' else ' '
        val rightArmChar = if (rightLeg) '\\' else ' '
        val leftLegChar = if (leftLeg) '/' else ' '
        val rightLegChar = if (rightLeg) '\\' else ' '
        return """
            +---+
            |   |
            |   $headChar
            |  $leftArmChar$bodyChar$rightArmChar
            |  $leftLegChar $rightLegChar
            |
            =========
        """.trimIndent()
    }

    fun ofMistakes(mistakes: Int): String {
        return when (mistakes) {
            0 -> getArt(
                head = false,
                body = false,
                leftArm = false,
                rightArm = false,
                leftLeg = false,
                rightLeg = false
            )

            1 -> getArt(head = true, body = false, leftArm = false, rightArm = false, leftLeg = false, rightLeg = false)
            2 -> getArt(head = true, body = true, leftArm = false, rightArm = false, leftLeg = false, rightLeg = false)
            3 -> getArt(head = true, body = true, leftArm = true, rightArm = false, leftLeg = false, rightLeg = false)
            4 -> getArt(head = true, body = true, leftArm = true, rightArm = true, leftLeg = false, rightLeg = false)
            5 -> getArt(head = true, body = true, leftArm = true, rightArm = true, leftLeg = true, rightLeg = false)
            6 -> getArt(head = true, body = true, leftArm = true, rightArm = true, leftLeg = true, rightLeg = true)
            else -> throw IllegalArgumentException("Invalid number of mistakes: $mistakes")
        }
    }
}