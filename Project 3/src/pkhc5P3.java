/* 
 * Patrick Kong
 * CS 2261
 * 
 * Wumpus world will have a 4x4 square
 * each square will have either have nothing by default
 * if the square has a pit it will trap the player
 * on entry, every square adjacent to the pit will have a breeze
 * any square that is adjacent to the Wumpus will have a stench
 * one square will contain gold, the player that finds the gold wins.
 */
import java.util.Scanner;

public class pkhc5P3{
	//main method for project 3
	public static void main( String[] args ) {
		
		//game object WumpusWorld
		WumpusWorld game = new WumpusWorld();
		int gameStatus = 0;
		char choice = ' ';
		boolean quit = false;
		Scanner input = new Scanner(System.in);
		
		do {
			game.initialize();
			do {
				
				game.control();
				gameStatus = game.rule();
				
			}while( gameStatus == 0 );
			do {
				game.resetBoard();
				System.out.println( "Do you want to play again? (y/n)" );
				choice = input.next().charAt( 0 );
				Character.toLowerCase( choice );
				if( choice == 'y' )
					quit = false;
				else if( choice == 'n' )
					quit = true;
				else
					System.out.println( "Invalid input." );
			}while( choice != 'y' && choice != 'n' );
		}while( quit == false );
		System.out.println( "Thanks for playing!" );
		input.close();
	}
}