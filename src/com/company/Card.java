package com.company;

import java.util.ArrayList;
import java.util.List;

public class Card {

    /*
    Create a class called Card
            A card should have at least 3 properties: suit, rank, and value
     */

    //suit   Heart / Diamond / Spade / Club
    //rank   2,3,4,5,6,7,8,9,10,Jack,Queen,King,Ace
    //value  2,3,4,5,6,7,8,9,10,1/11

    private String suit;
    private String rank;
    private int value;
    private boolean onTable;

    public Card(){

    }

    public Card(String suit, String rank, int value){
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.onTable = false;
    }

    public String getSuit(){
        return suit;
    }

    public String getRank(){
        return rank;
    }

    public int getValue(){
        return value;
    }

    public boolean getOnTable(){
        return onTable;
    }

    public void setOnTable(boolean onTable){
        this.onTable = onTable;
    }

    public void switchAceValue(){
        if(value == 11)
            value = 1;
        else
            value = 11;
    }

    public void outputCard(){
        System.out.println(rank+" "+suit);
    }

}
