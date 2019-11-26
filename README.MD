# Coding  Challenge 17 - Pontoon

##  Challenge

In this challenge you need to create a function that determines whether a player or the dealer has won at the card game known in the UK as Pontoon.

<details><summary>Click here for full details</summary>
<p>

```
The function will receive one array containing all the cards for a player and another array containing all the cards for the dealer. It will return the winner (ie. “The player” or “The dealer”) and a description of the winning hand.

Each card will be represented by two characters, the first character representing “rank” and the second character representing “suit”. Rank can be any of 2,3,4,5,6,7,8,9,T,J,Q,K,A (T=Ten, J=Jack, Q=Queen, K=King, A=Ace). Suit can be any of C,D,H,S (Clubs, Diamonds, Hearts, Spades). So TH will be 10 of Hearts.

Winning hands (ordered by highest scoring) are:

Pontoon - one card has a rank of ace and the other card is a picture card, i.e. has rank of J, Q or K.

Five card Trick - there are five cards with a total value of 21 or less. Ace has value of one and picture cards have value of 10. The total value of the cards doesn’t matter as long as it is 21 or less.

Highest total of 21 or less. Ace can have a value of one or eleven. e.g. two kings and an ace would have a value of 21 but an ace and a 3 would have a value of 14.

Hands totalling more than 21 are “bust” and worth nothing

The player must have a higher scoring hand than the dealer to win, otherwise the dealer wins.

---------------------------------------------------------------
Sample data for a Pontoon: ["QH","AC"]

Sample data for a five card trick: ["3D","2C","4H","AD","5C"]

Sample data for total of 17: ["7C","AD","9H"]

Sample data for total of 21: ["AD","8S","2H"]

Sample data for total of 13: ["AD","AH","AS"]
```

</p>
</details>

##  Solution

My solution is written in Kotlin with gradle as the build tool.

There are three object types in my solution: Card, Hand and Pontoon.

#### Card

I decided to model a card as an enum, mainly because I've not used them before but it seemed a playing card was well suited as it has a fixed and unchanging definition.
There is a companion object with a function for returing the correct Card based on the two character input expected by the game.

#### Hand

A hand is passed an array of strings of the form seen in the description, the initialisation block will convert these to a list of Cards and throw an error for bad input.
The hand also has three functions. One checks if the hand is pontoon, one checks if the hand is a 5 card trick, the final function just calculates a score (accounting for Aces dual value)

#### Pontoon

Pontoon is just an object that is initialised with two Hands. It will calculate the result of the game and store this as result parameter in initialisation and print this out.

## Tests

Test framework is Junit. They can be ran in the ide or running `./gradlew test` in the terminal.
I added Mockito for mocking but didn't get round to it. I might come back and do that...