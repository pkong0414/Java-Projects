Project 3 readme

Project 3 is a game called WumpusWorld. The aim of the game is to find the gold in a 4 x 4 board.
There are danger along the way as the player will have to avoid a creature called the Wumpus and pits.
The player can only see what is on his current square and any danger will alert the player.
The Wumpus will give off a stench on adjacent squares and pitfalls will have breeze on adjacent squares.

There are two classes running this game:
	*WumpusWorld handles the operations (using Square's methods) and makes ruling (using Square's attributes) of the game,

	*Square contain all the attributes and methods to manipulate or read each square.

The main function will call an object from WumpusWorld. On creation of WumpusWorld, it will generate
a 2 dimensional Square objects forming a 4 x 4 gameboard. The main function will then initialize the game
using an initialize function to propagate objects into the game. A loop will be set to give the player control
and rule to deal out consequences. The game will end when rule function determines win or lose condition.
All the squares on the gameboard will be reset and the player will be prompt to play again. 
If 'y' is entered the game will start all over and if 'n' is answered then the program will terminate.