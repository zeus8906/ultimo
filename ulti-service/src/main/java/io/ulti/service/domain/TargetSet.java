package io.ulti.service.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TargetSet implements Comparable<TargetSet> {

    private Set<GameTarget> statedTargets;
    private CardColor color;
    private Map<Player, Set<GameTarget>> counters;

    public TargetSet(Collection<GameTarget> statedTargets, boolean isRed) {
        this.statedTargets = new HashSet<>(statedTargets);
        counters = new HashMap<>();
        color = isRed ? CardColor.RED : null;
    }

    public int getGameValueWithoutParty() {
        int targetValueSum = statedTargets.stream().mapToInt(target -> target.getBaseValue()).sum();
        return CardColor.RED.equals(color) ? targetValueSum * 2 : targetValueSum;
    }

    public int getGameValue() {
        int targetValueSum = statedTargets.stream().mapToInt(target -> target.getBaseValue()).sum()
                + (isPartyInGame() ? 1 : 0);
        return CardColor.RED.equals(color) ? targetValueSum * 2 : targetValueSum;
    }

    public boolean isPartyInGame() {
        return statedTargets.stream().allMatch(target -> target.isParty());
    }

    public Map<Player, Set<GameTarget>> getCounters() {
        return counters;
    }

    public void addTargetsToGame(Collection<GameTarget> targetsToAdd) {
        this.statedTargets.addAll(targetsToAdd);
    }

    @Override
    public int compareTo(TargetSet other) {
        int withPartyComparsion = Integer.compare(this.getGameValue(), other.getGameValue());
        return withPartyComparsion == 0
                ? Integer.compare(this.getGameValueWithoutParty(), other.getGameValueWithoutParty())
                : withPartyComparsion;
    }
}
