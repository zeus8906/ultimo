package io.ulti.service.comparator;

import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.ulti.service.domain.Card;
import io.ulti.service.domain.CardColor;

public class CardInColorGameComparator implements Comparator<Card> {

    private static final int SECOND_BEATS_FIRST = -1;
    private static final int FIRST_BEATS_DECOND = 1;
    private static final Logger LOG = LoggerFactory.getLogger(CardInColorGameComparator.class);
    private CardColor trumps;
    
    
    public CardInColorGameComparator(CardColor trumps) {
        super();
        this.trumps = trumps;
    }


    @Override
    public int compare(Card first, Card second) {
        int result = 0;
        if(first.getColor().equals(trumps) && !second.getColor().equals(trumps)){
            result = FIRST_BEATS_DECOND;
        } else
        if(second.getColor().equals(trumps) && !first.getColor().equals(trumps)){
            result = SECOND_BEATS_FIRST;
        } else {
            result = evaluateNonTrumphSituation(first, second);
        }

        return result;
    }

    private int evaluateNonTrumphSituation(Card first, Card second) {
        int diff = first.getValue().getColorGamePriority() - second.getValue().getColorGamePriority();
        if (diff == 0) {
            LOG.error("Two cards has the same value in the deck: {} - {}", first, second);
            throw new IllegalStateException("Two cards cannot be equal!");
        }
        return diff / Math.abs(diff);
    }

}
