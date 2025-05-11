# java_snap

## Stage 1:

- public class CardGame
    
    - Class must contain an ArrayList of card objects containing all 52 playing cards.

        - Define a private static ArrayList<Card> called cards, containing all 52 playing cards.

    - Class must contain a 'name' field in the class Constructor.

    - Class must contain a getDeck method that prints all 52 playing cards.

- public class Card

    - Class must contain a String type 'suit' field:

        - In the CardGame class, define as a private, static, final ArrayList of string objects called suits, containing the four playing card suits as Unicode characters: ♥, ♣, ♦, ♠
    
    - Class must contain a String type 'symbol' field:

        - In the CardGame class, define as a private, static, final ArrayList of string objects called symbols, containing the thirteen playing card variations: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A

    - Class must contain an int type 'value' field:

        - In the CardGame class, define as a private, static, final ArrayList of integer primitives called values, containing the thirteen playing card values: 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
    
    - Class must contain a toString method that describes the Card class.

        - Return a formatted string type object, containing the suit, symbol and value, specific to each card type object.

- Create a CardGame class generateDeck method to generate a deck of 52 playing cards:

    - Contains a two-dimensional for loop:
  
        - The outer loop iterates over the length of the suits ArrayList, containing the four playing card suits as Unicode characters.
      
            - Accesses the suits ArrayList at position i.
      
        - The inner loop iterates over the length of the symbols ArrayList and the length of the values ArrayList, as both are the same size.

            - Accesses both the symbols ArrayList and the values ArrayList at position j.

        - At each iteration:

            - A new card type object is instantiated with suits at index position i and symbols and values at position j.
          
            - The card type object is added to the cards ArrayList of the CardGame object.

- Create a Card class toString method to return the fields specific to each playing card.

    - Returns a formatted string type object, containing the fields from the class constructor.

- Create a CardGame class getDeck method to print the fields of all 52 playing cards.

    - Contains a for loop:

        - Iterates over the length of the cards ArrayList, containing all 52 playing cards.

            - Accesses the cards ArrayList a position i.

            - Calls the Card class toString method on each card type object, printing the returned value.



## Stage 2

- Create a CardGame class dealCard method that returns the first item in the cards ArrayList.

    - Return the item at index position 0 of the cards ArrayList.

- Create a CardGame class sortDeckIntoValueOrder method that sorts in place the cards ArrayList by order of value.

    - Create a Comparator object that compares Card objects by the value instance variable, using the Card class getValue method.

    - Call the List interface sort method on the cards ArrayList, with the Comparator object as an argument, sorting the cards ArrayList by value.

- Create a CardGame class sortDeckIntoSuitOrder method that sorts in place the cards ArrayList, first by order of suits, then by order of value.

    - Create a Comparator object that compares Card objects by the suit instance variable, using the Card class getSuit method.

    - Create a Comparator object that compares Card objects by the value instance variable, using the Card class getValue method.

    - Chain the Comparator objects together, comparing by suit, and if two suits are the same, comparing by value.

    - Call the List interface sort method on the cards ArrayList, with the Comparator object as an argument, sorting the cards ArrayList by value.



## Stage 3

- Create a Snap class that extends the CardGame class.

  - Create a Snap class constructor:

    - Class must contain a 'currentCard' field to store the Card type object returned by the CardGame class dealCard method.

    - Class must contain a 'previousCard' field to store the Card type object returned by the CardGame class dealCard method from the previous turn.

        - Comparing the currentCard and previousCard fields will comprise the winning condition that ends the game.

- Create a Snap class playGame method:

    - Use a while loop with an exit condition that enables the user to play the game.

    - Create a Scanner object and prompt the user to press enter to take their turn.

    - Call the inherited CardGame class dealCard method to return the card at the top of the deck.

        - Store the returned Card type object in the currentCard field of the Snap class constructor.

        - Print the returned Card type object to the console.

    - If the Rank of the currentCard field matches the Rank of the previousCard field, the player wins and the game ends.



## Stage 4

- Create a Player class in order for Player objects to engage with the Snap class, enabling a single-player and multi-player modes.

- Create a Snap class promptSnapInput method that challenges the winner to input the word 'snap' in a set amount of time.

    - Failure to input the word 'snap' in the set amount of time results in the continuation of the game.



- Instantiation of a Snap class object:

  - Instantiates a Player class object or Player class objects.

  - Generates a 'deck' ArrayList of 52 Card objects.

  - Generates an empty 'pile' ArrayList.
 
    - The 'pile' ArrayList accumulates Card objects played by the players.

    - The Snap class getCurrentCard method accesses the first Card object in the pile.

    - The Snap class getPreviousCard method accesses the second Card object in the pile.

- The Snap class playSinglePlayerGame and playMultiPlayerGame methods initialise the game itself.

  - The deck is shuffled 

  - The 52 Card objects are dealt to the 'hand' ArrayList of the Player object, or divided amongst the 'hand' ArrayLists of the Player objects.



- The game logic sequence is as follows:
    
  - promptPlayerToPressEnter(player) --> playerTakesTurn(player) --> turnLogic(card) --> isSnap(currentCard, previousCard)

    - If isSnap returns true, true is returned back along the call stack, and the player wins.

    - If isSnap returns false, false is returned back along the call stack, and the game continues.



- The Snap class promptPlayerToPressEnter method:

  - Returns when the player responds to the prompt and presses the enter key to take their turn.
  
- The Snap class playerTakesTurn method:

  - The first Card object from the Player object 'hand' ArrayList is removed. 

  - The turnLogic method is called with this Card object as an argument.
  
    - If the turnLogic method returns true, the player has won, and the promptSnapInput method is called.

    - If the turnLogic method returns false, the player has not won, and the promptPlayerToPressEnter method is called again.

- The Snap class turnLogic method:

  - On the first turn:

    - Calls the addCardToPile method, and returns false.
  
  - All subsequent turns:

    - Calls the addCardToPile method.

    - Calls the isSnap method, and returns true if the winning condition has been met.

- The Snap class isSnap method:

  - Compares the 'symbol' instance variables of the current and previous Card objects from the Snap object 'pile' ArrayList.

    - Returns true if the 'symbol' instance variables match.

    - Returns false if the 'symbol' instance variables do not match.

- The Snap class promptSnapInput method:

  - Creates a new single thread to handle the 'snap' input task.

  - Creates a new Scanner object to read the result of the 'snap' input task from the new single thread.

  - Creates a Future contract to record the result of the 'snap' input task from the new single thread.

    - If the user completes the 'snap' input task, the promptSnapInput method returns true, and the player wins.

    - If the user fails to complete the 'snap' input task, the promptSnapInput method returns false, and the game continues.



- The game logic sequence simulates all actions from a real-life game of Snap:

  - A Snap object is instantiated.

  - All 52 Card objects are generated and stored in the 'deck' ArrayList instance variable.

  - A Player object or Player objects are instantiated.

    - In single-player mode, all 52 Card objects are moved to the Player object 'hand' ArrayList instance variable.

    - In multi-player mode, all 52 Card objects are divided between the two Player objects 'hand' ArrayList instance variables.

  - The Player objects add the Card objects to the Snap object 'pile' ArrayList instance variable.

  - This sequence continues until:
  
    - A Player calls 'snap' and wins the game.

    - All Card objects are played and the game ends.
  
  - At the end of each game:

    - All remaining Card objects are transferred from the Player object 'hand' ArrayList to the Snap object 'pile' ArrayList.
  
    - All 52 Card objects are transferred from the Snap object 'pile' ArrayList to the Snap object 'deck' ArrayList.
  
  - The 52 Card objects sequence is as follows:

    - Snap.deck --> Player.hand --> Snap.pile --> Snap.deck
