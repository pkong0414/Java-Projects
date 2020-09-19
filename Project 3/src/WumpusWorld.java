	/* This class contains the gameboard. This 
	 * will store a single instance of WumpusWorld game
	 * It will contain a 2 dimensional array of Square.
	 * 3 pits will spawn in random places, and adjacent squares will
	 * contain breeze thereafter.
	 * The Wumpus will spawn in a random location and ourselves in the bottom left Square[0][0].
	 */
import java.util.Scanner;

class WumpusWorld extends Square {
	int winStatus = 0;			//win status will be: 0 for nothing, 1 for win, 2 for lose
	int locX = 0;
	int locY = 0;
	boolean debug = false;
	
	//gold location
	int glocX = 0;
	int glocY = 0;
	
	//pit locations
	int pit1X = 0;
	int pit1Y = 0;
	int pit2X = 0;
	int pit2Y = 0;
	int pit3X = 0;
	int pit3Y = 0;
	
	//wumpus location
	int wlocX = 0;
	int wlocY = 0;
	Square[][] gameBoard = new Square[ 4 ][ 4 ];
	
	public WumpusWorld(){
		//contains the location of object
		
		for( int x = 3 ; x >= 0 ; x-- ) {
			for( int y = 3 ; y >= 0 ; y-- ) {
				gameBoard[ x ][ y ] = new Square();
			}
		}
	}
	
	
	//initialize game function
	public void initialize() {
		int count = 0;
		//generating the random coordinates for the objects on the board
		
		do {
			
			//random number is assigned to locX and locY [0, 4)
			//It will keep any object from propagating at the player's spawn
			do {
				locX = (int)( Math.random() * ( 4 - 0 ) );
				locY = (int)( Math.random() * ( 4 - 0 ) );
			}while( locX == 0 | locY == 0);
			
			
			//an assigned check is done to make sure something isn't already set.
			//lastly propagation of Wumpus
			if( count == 4 & gameBoard[ locX ][ locY ].getAssigned() == false ) {
				gameBoard[ locX ][ locY ].setWumpus();
				
				if( locX + 1 <= 3 && gameBoard[ locX + 1 ][ locY ].getAssigned() == false )
					gameBoard[ locX + 1 ][ locY ].setStench();
				
				if( locX - 1 >= 0 && gameBoard[ locX - 1 ][ locY ].getAssigned() == false )
					gameBoard[ locX - 1 ][ locY ].setStench();
				
				if( locY + 1 <= 3 && gameBoard[ locX ][ locY + 1 ].getAssigned() == false )
					gameBoard[ locX ][ locY + 1 ].setStench();
				
				if( locY - 1 >= 0 && gameBoard[ locX ][ locY - 1 ].getAssigned() == false )
					gameBoard[ locX ][ locY - 1 ].setStench();
				
				wlocX = locX;
				wlocY = locY;
				/*
				//debugging output
				System.out.println( "Wumpus loc: " + "(" + wlocX + ", " + wlocY + ")" );
				*/
				count++;
			}
			
			//second propagation of gold
			if( count == 3 & gameBoard[ locX ][ locY ].getAssigned() == false ) {
				gameBoard[ locX ][ locY ].setGold();
				
				/*
				//debugging output
				System.out.println( "gold loc: " + "(" + locX + ", " + locY + ")" );
				*/
				
				glocX = locX;
				glocY = locY;
				count++;
			}
			
			//first propagation of pits first
			if( count < 3 & gameBoard[ locX ][ locY ].getAssigned() == false ){
				gameBoard[ locX ][ locY ].setPit();
				
				//propagating breeze
				if( locX + 1 <= 3 && gameBoard[ locX + 1 ][ locY ].getAssigned() == false )
					gameBoard[ locX + 1 ][ locY ].setBreeze();
				
				if( locX - 1 >= 0 && gameBoard[ locX - 1 ][ locY ].getAssigned() == false )
					gameBoard[ locX - 1 ][ locY ].setBreeze();
				
				if( locY + 1 <= 3 && gameBoard[ locX ][ locY + 1 ].getAssigned() == false )
					gameBoard[ locX ][ locY + 1 ].setBreeze();
				
				if( locY - 1 >= 0 && gameBoard[ locX ][ locY - 1 ].getAssigned() == false )
					gameBoard[ locX ][ locY - 1 ].setBreeze();
				
				if( count == 0 ) {
					pit1X = locX;
					pit1Y = locY;
				}
				else if( count == 1 ) {
					pit2X = locX;
					pit2Y = locY;
				}
				else if( count == 2 ) {
					pit3X = locX;
					pit3Y = locY;
				}
				
				/*
				//debugging output
				System.out.println( "pit loc: " + "(" + locX + ", " + locY + ")" );
				*/
				count++;
			}
			
		} while(count < 5);
		
		//setting player before game begins
		//objectLoc will be used to keep track of the player now
		locX = 0;
		locY = 0;
		gameBoard[ 0 ][ 0 ].setPlayer();
	}
	
	//this function allows the player to move through the gameboard
	public void control() {
		
		boolean move = false;
		char direction = ' ';
		Scanner input = new Scanner(System.in);
		
		do {
			if( debug == true ) {
				System.out.println( "Pit 1 loc: " + "(" + pit1X + ", " + pit1Y + ")" );
				System.out.println( "Pit 2 loc: " + "(" + pit2X + ", " + pit2Y + ")" );
				System.out.println( "Pit 3 loc: " + "(" + pit3X + ", " + pit3Y + ")" );
				System.out.println( "Gold loc: " + " (" + glocX + ", " + glocY + ")" );
				System.out.println( "Wumpus loc: " + "(" + wlocX + ", " + wlocY + ")" );
			}
			System.out.println( "You are at: (" + locX + ", " + locY + ") " );
			System.out.println( "Use W,A,S,D to move: Up, Left, Down, Right" );
			if( debug == false )
				System.out.println( "press c to enable cheat");
			
			direction = input.next().charAt( 0 );
			Character.toLowerCase( direction );
			if( direction != 'w' && direction != 'a' &&
				direction != 's' && direction != 'd' &&
				direction != 'c' ) {
				move = false;
			}
			else if( ( locX == 0 && direction == 'a' ) || 
					 ( locX == 3 && direction == 'd' ) ||
					 ( locY == 3 && direction == 'w' ) ||
					 ( locY == 0 && direction == 's' )) {
				System.out.println( "Your character is at the border." );
				move = false;
			}
			else {	//the conditions for moving the characters
				if( direction == 'w' ) {
					gameBoard[ locX ][ locY ].unsetPlayer();
					//incrementing y by 1
					locY += 1;
					gameBoard[ locX ][ locY ].setPlayer();
					move = true;
				}
				else if( direction == 'a' ) {
					gameBoard[ locX ][ locY ].unsetPlayer();
					//decrementing x by 1
					locX -= 1;
					gameBoard[ locX ][ locY ].setPlayer();
					move = true;
				}
				else if( direction == 's' ) {
					gameBoard[ locX ][ locY ].unsetPlayer();
					//decrementing y by 1
					locY -= 1;
					gameBoard[ locX ][ locY ].setPlayer();
					move = true;
				}
				else if( direction == 'd' ) {
					gameBoard[ locX ][ locY ].unsetPlayer();
					//incrementing x by 1
					locX += 1;
					gameBoard[ locX ][ locY ].setPlayer();
					move = true;
				}
				else if( direction == 'c' & debug == false) {
					debug = true;
				}
			}
		
		}while( move != true );
		
		//these are the wall conditions
	}
	
	//This function will dictate win or lose and will alert the player of any danger
	public int rule() {
		int report = 0;
		
		//the loss condition if player bumps into the Wumpus
		if( gameBoard[ locX ][ locY ].getWumpus() == true ) {
			 System.out.println( "You walked into the Wumpus. You lose." );
			 report = 2;
			 return report;
		}
		else if( gameBoard[ locX ][ locY ].getPit() == true ) {
			System.out.println( "You walked into a pit and fell to your death. You lose." );
			report = 2;
			return report;
		}
		//the win condition if the player finds the gold
		if( gameBoard [ locX ][ locY ].getGold() == true ) {
			System.out.println( "You find gold. You win!" );
			report = 1;
			return report;
		}
		
		
		//the neutral conditions that require an alert
		if( gameBoard[ locX ][ locY ].getBreeze() == true ) {
			System.out.println( "You feel a breeze." );
		}
		if( gameBoard[ locX ][ locY ].getStench() == true ) {
			System.out.println( "Your nose caught a smelly odor." );
		}
		
		return report;
	}
	
	public void resetBoard() {
		//This function will reset the board
		for( int x = 0 ; x < 4 ; x++ ) {
			for( int y = 0 ; y < 4 ; y++ ) {
				gameBoard[ x ][ y ].gameReset();
			}
		}
	}
	
}