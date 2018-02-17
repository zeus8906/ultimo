package io.ulti.service.domain;

import java.util.HashSet;
import java.util.Set;

public class Player {

    private final String name;
    private Set<Card> hand;

    private MatchRole role;

    public Player(String name) {
        this.name = name;
        this.hand = new HashSet<Card>();
        this.role = MatchRole.DEFENDER;
    }

    public String getName() {
        return name;
    }

    public MatchRole getRole() {
        return role;
    }

    public void setRole(MatchRole role) {
        this.role = role;
    }

    public Set<Card> getHand() {
        return hand;
    }

    public void fillHand(Set<Card> cards) {
        assert MatchRole.GRABBER.equals(role) && cards.size() == 12 || cards.size() == 10;
        this.hand = cards;
    }

    public boolean playCard(Card card) {
        assert this.hand.contains(card);
        return this.hand.remove(card);
    }
}
