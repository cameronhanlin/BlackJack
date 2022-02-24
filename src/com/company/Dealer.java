package com.company;

import java.util.ArrayList;
import java.util.List;

public class Dealer {


    /*
    Create a new class called Dealer
            Dealer should have a method named “deal”, that returns two random Cards and removes them from the deck
            Dealer should have a method named “hit”, that returns a random single card and removes it from the deck

     */

    public Deck stack = new Deck();

    public List<Card> deal(){
        List<Card> newDeal = new ArrayList<>();
        newDeal.add(stack.getRandomCard());
        newDeal.add(stack.getRandomCard());
        return newDeal;
    }

    public Card hit(){
        return stack.getRandomCard();
    }


}
