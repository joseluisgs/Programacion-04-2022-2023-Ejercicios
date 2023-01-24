package gameCatan.enums

enum class TypeResource(private val letter: String) {
    WOOD("M"), COAL("C"), SEED("T");

    fun get(): String {
        return letter
    }
}