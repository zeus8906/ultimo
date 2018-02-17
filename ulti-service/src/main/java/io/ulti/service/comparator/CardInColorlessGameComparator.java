package io.ulti.service.comparator;

import java.util.Comparator;

import io.ulti.service.domain.Card;

public class CardInColorlessGameComparator implements Comparator<Card> {

    @Override
    public int compare(Card one, Card other) {
        int priorityDifference = one.getValue().getColorlessGamePriority()
                - other.getValue().getColorlessGamePriority();
        return priorityDifference / Math.abs(priorityDifference);
    }

}
