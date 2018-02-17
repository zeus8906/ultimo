package io.ulti.service.domain;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Game {

    private List<Player> players;
    private Phase phase;
    private LinkedList<Set<Card>> rounds;
    private TargetSet target;
    private Set<Card> talon;
    private Set<Integer> twenties;
    private int fourty = -1;
    private int talkingPlayer;
    private boolean isTalonTouched;

    public boolean isTalonTouched() {
        return isTalonTouched;
    }

    public void setTalonTouched(boolean isTalonTouched) {
        this.isTalonTouched = isTalonTouched;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players.addAll(players);
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public LinkedList<Set<Card>> getRounds() {
        return rounds;
    }

    public void setRounds(LinkedList<Set<Card>> rounds) {
        this.rounds = rounds;
    }

    public TargetSet getTarget() {
        return target;
    }

    public void setTarget(TargetSet target) {
        this.target = target;
    }

    public Player getTalkingPlayer() {
        return players.get(talkingPlayer);
    }

    public Set<Card> getTalon() {
        return talon;
    }

    public Set<Integer> getTwenties() {
        return twenties;
    }

    public int getFourty() {
        return fourty;
    }

}
