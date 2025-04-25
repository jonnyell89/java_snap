# java_snap

## Stage 1:

- public class CardGame
    
    - Class must contain an array list of card type objects containing all 52 playing cards.

        - Define as private, static, array list of card type objects called cards, containing all 52 playing cards.

    - Class must contain a 'name' field in the class Constructor.

    - Class must contain a getDeck method that prints all 52 playing cards.

- public class Card

    - Class must contain a String type 'suit' field:

        - In the CardGame class, define as a private, static, final array list of string type objects called suits, containing the four playing card suits as Unicode characters: ♥, ♣, ♦, ♠
    
    - Class must contain a String type 'symbol' field:

        - In the CardGame class, define as a private, static, final array list of string type objects called symbols, containing the thirteen playing card variations: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A

    - Class must contain an int type 'value' field:

        - In the CardGame class, define as a private, static, final array list of integer primitives called values, containing the thirteen playing card values: 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
    
    - Class must contain a toString method that describes the Card class.

        - Return a formatted string type object, containing the suit, symbol and value, specific to each card type object.

- Create a CardGame class generateDeck method to generate a deck of 52 playing cards:

    - Contains a two-dimensional for loop:
  
        - The outer loop iterates over the length of the suits array list, containing the four playing card suits as Unicode characters.
      
            - Accesses the suits array list at position i.
      
        - The inner loop iterates over the length of the symbols array list and the length of the values array list, as both are the same size.

            - Accesses both the symbols array list and the values array list at position j.

        - At each iteration:

            - A new card type object is instantiated with suits at index position i and symbols and values at position j.
          
            - The card type object is added to the cards array list of the CardGame object.

- Create a Card class toString method to return the fields specific to each playing card.

    - Returns a formatted string type object, containing the fields from the class constructor.

- Create a CardGame class getDeck method to print the fields of all 52 playing cards.

    - Contains a for loop:

        - Iterates over the length of the cards array list, containing all 52 playing cards.

            - Accesses the cards array list a position i.

            - Calls the Card class toString method on each card type object, printing the returned value.



## Stage 2

- Create a Card class dealCard method that returns the last item in the cards array list.

    - Return the item at the index position of the length of the cards array list, minus one to account for indexing.

