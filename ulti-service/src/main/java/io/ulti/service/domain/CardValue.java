package io.ulti.service.domain;

public enum CardValue {
    VII(false, 1, 1), VIII(false, 2, 2), IX(false, 3, 3), X(true, 7, 4), NETHER(false, 4, 5), OVERHEAD(false, 5,
            6), KING(false, 6, 7), ACE(true, 8, 8);

    private final boolean isScore;
    private final int colorGamePriority;
    private final int colorlessGamePriority;

    private CardValue(boolean isScore, int colorGamePriority, int colorlessGamePriority) {
        this.isScore = isScore;
        this.colorGamePriority = colorGamePriority;
        this.colorlessGamePriority = colorlessGamePriority;
    }

    public boolean isScore() {
        return isScore;
    }

    public int getColorGamePriority() {
        return colorGamePriority;
    }

    public int getColorlessGamePriority() {
        return colorlessGamePriority;
    }

}
