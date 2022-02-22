package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    /*
    Create a new class called Deck
            Deck should have a public method that “builds” an arraylist of Card objects
                Assign each Card a Suit (Spades, Clubs, Diamond, and Heart)
                Assigning each card a Rank (2-10, Jack, Queen, King, Ace)
                Assigning each card a value to 2-11
                This should be done to recreate the 52 unique cards in a deck
     */
    private List<Card> deck = new ArrayList<>();
    private Random rand = new Random();
    private String[] suits = {"Hearts","Diamonds","Spades","Clubs"};
    private String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    private int[] values = {2,3,4,5,6,7,8,9,10,10,10,10,11};
    public int cardsOnTable;


    public Deck(){
        for(int i = 0; i < 13; i++){
            for(int j=0; j < 4; j++){
                deck.add(new Card(suits[j],ranks[i], values[i]));
            }
        }
        cardsOnTable = 0;
    }

    public Card getRandomCard(){
        int x = rand.nextInt(52); //picks a random card

        while(deck.get(x).getOnTable()){ ///checks if card has previously been given out
            x = rand.nextInt(52);
        }
        deck.get(x).setOnTable(true);
        cardsOnTable++;

        return deck.get(x);
    }

    public void newDeck(){
        for(int i = 0; i < deck.size(); i++){
            deck.get(i).setOnTable(false);
        }
        cardsOnTable = 0;
    }

    public void outputDeck(){
        for(int i=0; i < deck.size(); i++) {
            deck.get(i).outputCard();
        }
    }





}
