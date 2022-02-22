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


        do {        //begin main loop for repeat play

            player1.addAll(dealer.deal());   //initial deal of player and computer
            house.addAll(dealer.deal());

            System.out.println("*********************************House Hand");    //outputs the dealer's hand
            for (int i = 0; i < player1.size(); i++) {
                house.get(i).outputCard();
                houseTotal = houseTotal + house.get(i).getValue();
            }

            System.out.println("*********************************Player First Hand");   //outputs the players hand
            for (int i = 0; i < player1.size(); i++) {
                player1.get(i).outputCard();
                player1Total = player1Total + player1.get(i).getValue();
            }

            for (int i = 0; i < player1.size(); i++) {     /// checks if the player has an ace in their initial deal, and if they want to split it
                if (player1.get(i).getRank().equals("Ace")) {
                    System.out.print("Do you want to switch your Ace to a 1? (y/n) ");
                    playerChoice = scan.nextLine();
                    if (playerChoice.equals("y")) {
                        player1.get(i).switchAceValue();
                        player1Total = player1Total - 10;
                    }
                }

            }

            System.out.print("Do you want to hit or stay? (h/s):");     //first ask if they want to hit or stay
            playerChoice = scan.nextLine();  // input for options

            while (playerChoice.equals("h") && player1Total <= 21) {   //checks that the player actually wants to hit
                newCard = dealer.hit();
                newCard.outputCard();
                if(newCard.getValue() == 11){
                    System.out.print("Do you want to switch your Ace to a 1? (y/n) ");    //asks about an ace value if the player hits and receives an ace
                    playerChoice = scan.nextLine();
                    if (playerChoice.equals("y")) {
                        newCard.switchAceValue();
                    }

                }
                player1.add(newCard);
                player1Total = player1Total + newCard.getValue();

                if(player1Total <21) {                             ///if they player is busted, it forces a stay
                    System.out.print("Do you want to hit or stay? (h/s):");
                    playerChoice = scan.nextLine();  // input for options
                }
                else
                    playerChoice = "s";

            }

            while (houseTotal <= 16) {             //the house hits if they are below 17, assumes aces are 11 always (default)
                System.out.println("The House Hits");
                newCard = newCard = dealer.hit();
                newCard.outputCard();
                house.add(newCard);
                houseTotal = houseTotal + newCard.getValue();
            }

            System.out.println("The House Stays");


            System.out.println("*********************************Player Final Hand " + player1Total);     //outputs final hands
            for (int i = 0; i < player1.size(); i++)
                player1.get(i).outputCard();

            System.out.println("*********************************House Final Hand " + houseTotal);
            for (int i = 0; i < house.size(); i++)
                house.get(i).outputCard();


            if (player1Total > 21 && houseTotal > 21) {                                        //checks who won
                System.out.println("Both player and house busted, house wins");
            } else if (player1Total > 21) {
                System.out.println("Player busted, house wins");
            } else if (houseTotal > 21) {
                System.out.println("House busted, player wins");
            } else if (houseTotal == player1Total) {
                System.out.println("Tie game, house wins");
            } else if (player1Total == 21) {
                System.out.println("BLACKJACK!! Player wins!");
            } else if (houseTotal == 21) {
                System.out.println("House Blackjack wins!");
            } else if (player1Total > houseTotal) {
                System.out.println("Player wins!");
            } else if (houseTotal > player1Total) {
                System.out.println("House wins.");
            }


            dealer.stack.newDeck();                ///defaults to reseting player and dealer's hand, and 'clears the table'
            player1.clear();
            house.clear();
            player1Total = 0;
            houseTotal = 0;

            System.out.print("Do you want to play again? (y/n)");
            playerChoice = scan.nextLine();


            if(playerChoice.equals("y")){                ///clears the consol as best as possible
                for(int i = 0; i<20; i++){
                    System.out.println("\n");
                }
            }

        } while(playerChoice.equals("y"));

        System.out.println("Thank you for playing!");



    }
}
