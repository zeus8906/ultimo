package io.ulti.service.rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.ulti.service.domain.Card;
import io.ulti.service.domain.CardColor;
import io.ulti.service.domain.CardValue;
import io.ulti.service.domain.Game;
import io.ulti.service.domain.Phase;
import io.ulti.service.domain.Player;
import io.ulti.service.domain.WageAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/drools-test-context.xml")
public class WageRuleServiceIT {

    private static final Set<Card> SAMPLE_TWELVE_CARD_HAND = new HashSet<>();

    @Autowired
    private WageRuleService underTest;
    
    @Autowired
    private Game game;

    static{
        SAMPLE_TWELVE_CARD_HAND.add(new Card(CardColor.PUMPKIN, CardValue.VII));
        SAMPLE_TWELVE_CARD_HAND.add(new Card(CardColor.PUMPKIN, CardValue.VIII));
        SAMPLE_TWELVE_CARD_HAND.add(new Card(CardColor.PUMPKIN, CardValue.IX));
        SAMPLE_TWELVE_CARD_HAND.add(new Card(CardColor.PUMPKIN, CardValue.X));
        SAMPLE_TWELVE_CARD_HAND.add(new Card(CardColor.PUMPKIN, CardValue.NETHER));
        SAMPLE_TWELVE_CARD_HAND.add(new Card(CardColor.PUMPKIN, CardValue.OVERHEAD));
        SAMPLE_TWELVE_CARD_HAND.add(new Card(CardColor.PUMPKIN, CardValue.KING));
        SAMPLE_TWELVE_CARD_HAND.add(new Card(CardColor.PUMPKIN, CardValue.ACE));
        SAMPLE_TWELVE_CARD_HAND.add(new Card(CardColor.ACORN, CardValue.VII));
        SAMPLE_TWELVE_CARD_HAND.add(new Card(CardColor.ACORN, CardValue.VIII));
        SAMPLE_TWELVE_CARD_HAND.add(new Card(CardColor.ACORN, CardValue.IX));
        SAMPLE_TWELVE_CARD_HAND.add(new Card(CardColor.ACORN, CardValue.X));
    }

    @Before
    public void setUp() {
        reset(game);
        when(game.getPhase()).thenReturn(Phase.WAGE);
    }

    @Test
    public void contextIsUpAndServiceIsAvailable() {
        assertNotNull(underTest);
    }

    @Test
    public void testWagingPlayerIsNotTalkingPlayer() {
        WageAction action = new WageAction(new Player("name"), Collections.emptySet(), false);
        underTest.isValidWage(action);
        assertFalse(action.isValidAction());
    }

    @Test
    public void testWagingPlayerIsTheTalkingPlayer() {
        Player talkingPlayer = new Player("name");
        when(game.getTalkingPlayer()).thenReturn(talkingPlayer);
        WageAction action = new WageAction(talkingPlayer, Collections.emptySet(), false);
        underTest.isValidWage(action);
        assertTrue(action.isValidAction());
    }

    @Test
    public void testWagingPlayerHasTwelveCardsInHand() {
        Player talkingPlayer = new Player("name");
        when(game.getTalkingPlayer()).thenReturn(talkingPlayer);
        talkingPlayer.fillHand(SAMPLE_TWELVE_CARD_HAND);
        assertTrue(talkingPlayer.getHand().size() == 12);
        WageAction action = new WageAction(talkingPlayer, Collections.emptySet(), false);
        underTest.isValidWage(action);
        assertFalse(action.isValidAction());
        assertEquals("The player must drop cards to talon!", action.getStatus());
    }
}
