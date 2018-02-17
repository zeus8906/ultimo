package io.ulti.service.domain;

import java.util.Set;

public class Deck {

    private static final Deck THE_DECK = new Deck();

    private Set<Card> cards;

    static {
        for (CardColor color : CardColor.values()) {
            for (CardValue value : CardValue.values()) {
                THE_DECK.addCard(new Card(color, value));
            }
        }
    }

    private Deck() {

    }

    public static final Deck getDeck() {
        return THE_DECK;
    }

    private void addCard(Card card) {
        cards.add(card);
    }
}
