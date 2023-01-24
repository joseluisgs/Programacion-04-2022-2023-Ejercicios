package gameCatan.enums;

public enum TypeResource {
    WOOD("M"),
    COAL("C"),
    SEED("T");

    private final String letter;

    TypeResource(String letter) {
        this.letter = letter;
    }

    public String get() {
        return letter;
    }
}
