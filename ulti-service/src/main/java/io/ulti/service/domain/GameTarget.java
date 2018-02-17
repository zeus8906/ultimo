package io.ulti.service.domain;

public enum GameTarget {
    PASS(0, true, true), FOURTY_HUNDRED(4, true, false), ULTI(4, true, true), FOUR_ACES(4, true, true), BETLI(5, false,
            false), COLORED_DURCHMARS(7, true, false), COLORLESS_DURCHMARS(7, false,
                    false), TWENTY_HUNDRED(6, true, false), REBETLI(10, false, false);

    private int baseValue;
    private boolean isColor;
    private boolean isParty;

    private GameTarget(int baseValue, boolean isColor, boolean isPartyInGame) {
        this.baseValue = baseValue;
        this.isColor = isColor;
        this.isParty = isPartyInGame;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public boolean isColor() {
        return isColor;
    }

    public boolean isParty() {
        return isParty;
    }

}
