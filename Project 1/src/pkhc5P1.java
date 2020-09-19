//Patrick Kong
//CS 2261-001
//pkhc5P1.java

import java.util.Scanner;
public class pkhc5P1{		
	public static void main( String[] args ) {
		//gameWon would normally would be bool but I want int for the event of a tie
		//1 is a win, 0 is a loss, and 2 would be a tie.
		//added in tie so player win percentile would be calculated accordingly (a tie isn't a loss).
		int wins = 0, ties = 0;
		
		//statistical variables for the game
		int gameWon = 0;
		int matchCount = 0;
		int lieWin = 1;
		int lieCount = 1;
		double winPercent;
		
		//indicator for the computer's lie
		boolean lied = false;
		
		//a quitting input
		String quitGame = "n";
		
		//This is for inputs
		int cpuInput = 0;
		int userInput = 0;
		
		//This will randomly generate the number
		cpuInput = (int)( ( Math.random() * 3 ) + 1 );
		
		lied = cpuTruth(cpuInput, matchCount, lieCount, lieWin);
		
		//asking user for input
		userInput = playerInput();
		gameWon = inputCompare(userInput, cpuInput);
		
		//will tally up if the computer lied and won.
		if( gameWon == 1 )
			wins += 1;
		else if( gameWon == 2 )
			ties += 1;
		if( lied == true ) {
			lieCount += 1;
			if( gameWon == 0)
				lieWin += 1;
		}
		matchCount += 1;
		
		winPercent = ( double ) wins  / ( matchCount - ties ) * 100;
		
		System.out.println( "\nWin percent: " + winPercent + "%" );
		Scanner input = new Scanner( System.in );
		
		System.out.println( "Would you like to continue? (y or n)" );
		quitGame = input.nextLine();
		quitGame.toLowerCase();
		
		//The whole system repeats as long as player doesn't quit.
		while( quitGame.compareTo("y") == 0 ) {
			cpuInput = cpuDecide(userInput, cpuInput, gameWon, matchCount);
			lied = cpuTruth(cpuInput, matchCount, lieCount, lieWin);
			userInput = playerInput();
			gameWon = inputCompare(userInput, cpuInput);
			if( gameWon == 1 )
				wins += 1;
			else if( gameWon == 2 )
				ties += 1;
			if( lied == true ) {
				lieCount += 1;
				if( gameWon == 0)
					lieWin += 1;
			}
			matchCount += 1;
			
			winPercent = ( double ) wins / ( matchCount - ties ) * 100;
			
			System.out.println( "\nWin percent: " + winPercent + "%");
			System.out.println("Would you like to continue? (y/n)");
			quitGame = input.nextLine();
			quitGame.toLowerCase();
		}
		
		System.out.println("\nGood Game!");
		input.close();
	}
	
	public static int inputCompare(int uInput, int cInput) {
		//this method will compare the input and determine the win, loss, or tie
		int winStatus;
		
		if( (uInput == 1 && cInput == 2) ||
			(uInput == 2 && cInput == 3) ||
			(uInput == 3 && cInput == 1) ) {
			
			//event of a win
			//outputting results
			if(uInput == 1 && cInput == 2)
				System.out.println("\nYour Hunter shoots my Bear.");
			else if(uInput == 2 && cInput == 3)
				System.out.println("\nYour Bear eats my Ninja.");
			else if(uInput == 3 && cInput == 1)
				System.out.println("\nYour Ninja kills my Hunter.");
			System.out.println("You win!");
			winStatus = 1;
		}
		else if( (uInput == 1 && cInput == 3) ||
				 (uInput == 2 && cInput == 1) ||
				 (uInput == 3 && cInput == 2) ) {
			
			//event of a loss
			//outputting results
			if(uInput == 1 && cInput == 3)
				System.out.println("\nMy Ninja kills your Hunter.");
			else if(uInput == 2 && cInput == 1)
				System.out.println("\nMy Hunter kills your Bear.");
			else if(uInput == 3 && cInput == 2)
				System.out.println("\nMy Bear eats your Ninja.");
			System.out.println("You lose.");
			winStatus = 0;
		}
		else {
			
			//event of a tie
			//outputting results
			System.out.println("\nWe tie.");
			winStatus = 2;
		}
			
			
		return winStatus;
	}
	
	public static int playerInput() {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		
		while( choice < 1 || choice > 3 ) {
			//Prompts user for an input.
			System.out.println("\nEnter 1 for Hunter.");
			System.out.println("Enter 2 for Bear.");
			System.out.println("Enter 3 for Ninja.");
			System.out.println("Please enter [1, 2, or 3].");
		
			choice = input.nextInt();
		}
		return choice;
	}
	
	public static int cpuDecide(int uInput, int cInput, int wonGame, int matchCount) {
		int choice = 0;
		
		//if the computer lost, it will decide to play the thing that didn't come up.
		//if the computer won, it will play what the opponent just played.
		//if the game was a tie, the computer will pick at random.
		if(wonGame == 0)
			if( (uInput == 1 && cInput == 3) ||
				(uInput == 3 && cInput == 1) ) {
				choice = 2;
				return choice;
			}
			else if( (uInput == 2 && cInput == 3) ||
					 (uInput == 3 && cInput == 2) ) {
				choice = 1;
				return choice;
			}
			else {
				choice = 3;
				return choice;
			}
		else if(wonGame == 1) {
			choice = uInput;
			return choice;
		}
		else if(wonGame == 2) {
			choice = (int)( (Math.random() * 3) + 1);
			return choice;
		}
		
		return choice;
	}
	
	public static boolean cpuTruth(int cInput, int matchCount, int lieCount, int lieWin) {
		//The computer will attempt to tell the truth, since it can be an effective tool
		//It will occasionally lie as well so that the player doesn't trust the computer completely.
		//The computer will tell the truth the first round before it starts lying.
		//When the computer lies it will either lie more if it wins or dial it back if it loses or ties.
		//If it lies it will return a bool value that indicates it had lied.
		//Effectiveness of the lie will determine if it will try to lie more.
		
		boolean lie = false;
		
		double lieEffect = (double)lieWin / lieCount;						//effectiveness of lying
		double truthAttempt = (double)( (Math.random() * 100) + 1 ) / 100;//the attempt to see if it lies
		double whichLie = (double)( (Math.random() * 100 ) + 1 ) / 100;	//the roll to see which lie it tells
		
		//debugging output
		//System.out.println( "lieWin percent: " + lieEffect );
		//System.out.println( "Truth Attempt roll: " + truthAttempt );
		
		if( matchCount == 0 || ( truthAttempt > lieEffect)) {
			if( cInput == 1 )
				System.out.println( "Comp: I'm going to use Hunter." );
			else if( cInput == 2 )
				System.out.println( "Comp: I'm going to use Bear." );
			else
				System.out.println( "Comp: I'm going to use Ninja." );
		}
		else if(truthAttempt <= lieEffect) {
			//This is the section where the computer lies.
			lie = true;
			
			//it will do a roll to decide which lie to tell
			if( cInput == 1 ) {
				if( whichLie > .5 ) {
					System.out.println( "Comp: I'm going to use Bear." );
				}
				else {
					System.out.println( "Comp: I'm going to use Ninja" );
				}
			}
			else if( cInput == 2 ) {
				if( whichLie > .5 ) {
					System.out.println( "Comp: I'm going to use Hunter." );
				}
				else {
					System.out.println( "Comp: I'm going to use Ninja" );
				}
			}
			else {
				if( whichLie > .5 ) {
					System.out.println( "Comp: I'm going to use Bear." );
				}
				else {
					System.out.println( "Comp: I'm going to use Hunter" );
				}
			}
		}
		
		return lie;
	}
}

