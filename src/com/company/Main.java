package com.company;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
        Blackjack
            Create a new project named BlackJack
            Create a new repo in Github named BlackJack
        In IntelliJ, create a new project named BlackJack
        In the Terminal navigate to your BlackJack project location
        In terminal, use git init
        Copy the Github SSH key for your new Github repo
        In Terminal Setup the git remote named origin by using the Github SSH key you copied earlier
            Stage and commit the init changes to your local repo
            Push changes to Github
        Create a class called Card
            A card should have at least 3 properties: suit, rank, and value
        Create a new class called Deck
            Deck should have a public method that “builds” an arraylist of Card objects
                Assign each Card a Suit (Spades, Clubs, Diamond, and Heart)
                Assigning each card a Rank (2-10, Jack, Queen, King, Ace)
                Assigning each card a value to 2-11
                This should be done to recreate the 52 unique cards in a deck

        Create a new class called Dealer
            Dealer should have a method named “deal”, that returns two random Cards and removes them from the deck
            Dealer should have a method named “hit”, that returns a random single card and removes it from the deck
        In your main class, deal the user a hand of two cards
            Display the total of the two card values to the user
            If the cards equal 21, declare Black Jack and congratulate the user.
            If the cards are not equal to 21, ask the user to hit (get another card) or stay (take the current score and end the “hand)
            Allow the user to keep getting cards until their value exceeds 21 or they choose to stay
        Bonus: Can you figure out a way to handle Aces being worth 1 or 11?
        Super Bonus: Can you handle the dealer also playing a hand to see who wins with the closest score to 21?
        */



        Dealer dealer = new Dealer();
        Card newCard = new Card();
        List<Card> player1 = new ArrayList<>();
        List<Card> house = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String playerChoice;
        int player1Total = 0;
        int houseTotal = 0;

        ///ADD SOMETHING TO SEND THE player1 list of cards to DEALER and have the dealer output??!??!?!?

        player1.addAll(dealer.deal());
        house.addAll(dealer.deal());

        System.out.println("*********************************House Hand");
        for(int i=0; i<player1.size(); i++){
            house.get(i).outputCard();
            houseTotal = houseTotal + house.get(i).getValue();
        }

        System.out.println("*********************************Player First Hand");
        for(int i=0; i<player1.size(); i++){
            player1.get(i).outputCard();
            player1Total = player1Total + player1.get(i).getValue();
        }

        System.out.print("Do you want to hit or stay? (h/s):");
        playerChoice = scan.nextLine();  // input for options

        while(playerChoice.equals("h") && player1Total <= 21){
            newCard = dealer.hit();
            newCard.outputCard();
            player1.add(newCard);
            player1Total = player1Total + newCard.getValue();

            System.out.print("Do you want to hit or stay? (h/s):");
            playerChoice = scan.nextLine();  // input for options

        }

        while(houseTotal <= 16){
            System.out.println("The House Hits");
            newCard = newCard = dealer.hit();
            newCard.outputCard();
            house.add(newCard);
            houseTotal = houseTotal + newCard.getValue();
        }

        System.out.println("The House Stays");








        //System.out.println(houseTotal);
        //player1.add(dealer.hit());
        //house.add(dealer.hit());

        System.out.println("*********************************Player Final Hand "+player1Total);
        for(int i=0; i<player1.size(); i++)
            player1.get(i).outputCard();

        System.out.println("*********************************House Final Hand "+houseTotal);
        for(int i=0; i<house.size(); i++)
            house.get(i).outputCard();


        if(player1Total > 21 && houseTotal > 21){
            System.out.println("Both player and house busted, house wins");
        }
        else if(player1Total > 21){
            System.out.println("Player busted, house wins");
        }
        else if(houseTotal > 21) {
            System.out.println("House busted, player wins");
        }
        else if(houseTotal == player1Total){
            System.out.println("Tie game, no winner");
        }
        else if(player1Total == 21 ){
            System.out.println("BLACKJACK!! Player wins!");
        }
        else if(houseTotal == 21){
            System.out.println("House Blackjack wins!");
        }
        else if(player1Total > houseTotal){
            System.out.println("Player wins!");
        }
        else if(houseTotal > player1Total){
            System.out.println("House wins.");
        }



        //dealer.stack.outputDeck();




        /* TESTING OUTPUT BOXES
        JOptionPane.showMessageDialog(null,"Welcome to BlackJack!","Blackjack!",1);

        int x;

        Object[] options = {"Yes, please",
                "No, thanks",
                "No eggs, no ham!"};

        x = JOptionPane.showOptionDialog(null,//parent container of JOptionPane
                "Would you like some green eggs to go with that ham?",
                "A Silly Question",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,//do not use a custom Icon
                options,//the titles of buttons
                options[2]);//default button title

        System.out.println(x);


         */

    }
}
