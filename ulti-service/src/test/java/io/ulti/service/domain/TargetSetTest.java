package io.ulti.service.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TargetSetTest {

    private static final Set<GameTarget> SAMPLE_TARGET_SET = new HashSet<>();
    private static final Set<GameTarget> SAMPLE_TARGET_SET_WITH_PARTY = new HashSet<>();

    static {
        SAMPLE_TARGET_SET.add(GameTarget.FOUR_ACES);
        SAMPLE_TARGET_SET.add(GameTarget.TWENTY_HUNDRED);
        SAMPLE_TARGET_SET_WITH_PARTY.add(GameTarget.ULTI);
        SAMPLE_TARGET_SET_WITH_PARTY.add(GameTarget.FOUR_ACES);
    }

    @Test
    public void testGetGameValueWithoutParty() {
        TargetSet underTest = new TargetSet(SAMPLE_TARGET_SET, false);
        int gameValueWithoutParty = underTest.getGameValueWithoutParty();
        assertEquals(10, gameValueWithoutParty);
    }

    @Test
    public void testGetGameValuePartyMatters() {
        TargetSet underTest = new TargetSet(SAMPLE_TARGET_SET_WITH_PARTY, false);
        int gameValue = underTest.getGameValue();
        assertEquals(9, gameValue);
    }

    @Test
    public void testGetGameValueWithoutPartyWhenPartyMatters() {
        TargetSet underTest = new TargetSet(SAMPLE_TARGET_SET_WITH_PARTY, false);
        int gameValueWithoutParty = underTest.getGameValueWithoutParty();
        assertEquals(8, gameValueWithoutParty);
    }

    @Test
    public void testGetGameValuePartyMattersWhenRed() {
        TargetSet underTest = new TargetSet(SAMPLE_TARGET_SET_WITH_PARTY, true);
        int gameValue = underTest.getGameValue();
        assertEquals(18, gameValue);
    }

    @Test
    public void testGetGameValueWithoutPartyWhenPartyMattersWhenRed() {
        TargetSet underTest = new TargetSet(SAMPLE_TARGET_SET_WITH_PARTY, true);
        int gameValueWithoutParty = underTest.getGameValueWithoutParty();
        assertEquals(16, gameValueWithoutParty);
    }

    @Test
    public void testGetGameValueWithoutPartyWhenRed() {
        TargetSet underTest = new TargetSet(SAMPLE_TARGET_SET, true);
        int gameValueWithoutParty = underTest.getGameValueWithoutParty();
        assertEquals(20, gameValueWithoutParty);
    }

    @Test
    public void testGetGameValue() {
        TargetSet underTest = new TargetSet(SAMPLE_TARGET_SET, false);
        int gameValue = underTest.getGameValue();
        assertEquals(10, gameValue);
    }

    @Test
    public void testIsPartyInGame() {
        TargetSet underTest = new TargetSet(SAMPLE_TARGET_SET, false);
        assertFalse(underTest.isPartyInGame());
    }

    @Test
    public void testCompare() {
        assertEquals(1,
                new TargetSet(SAMPLE_TARGET_SET, false).compareTo(new TargetSet(SAMPLE_TARGET_SET_WITH_PARTY, false)));
    }

    @Test
    public void testCompare2() {
        assertEquals(-1,
                new TargetSet(SAMPLE_TARGET_SET, false).compareTo(new TargetSet(SAMPLE_TARGET_SET_WITH_PARTY, true)));
    }

}
