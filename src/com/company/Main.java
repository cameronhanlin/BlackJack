package com.company;

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
    }
}
