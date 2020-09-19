package application;

import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Battleship extends Application {
	@Override
	public void start( Stage primaryStage ) {
		
		//javaFX attributes
		//creates a new GridPane called board
		GridPane board = new GridPane();
		board.setAlignment( Pos.CENTER );
		board.setPadding( new Insets( 11.5, 12.5, 13.5, 14.5 ) );
		board.setHgap( 5.5 );
		board.setVgap( 5.5 );
		int hitValue = 0;
		int missValue = 0;
		int sunkValue = 0;
		Button button = new Button( "0" );
		
		String textPrint = "Select a square.";
		
		for( int x = 1; x <= 10; x++ ) {
			for( int y = 1; y <= 10; y++ ) {
				board.addColumn( x, button );
				GridPane.setValignment( button, VPos.BOTTOM );
			}
		}
		
		//This is the top label text for the game
		board.add( new Label( textPrint ), 5 , 0);
		
		//This is the left top side label of hits
		board.add( new Label( "Hits" ), 0, 1 );
		board.add( new Label( Integer.toString( hitValue ) ), 0, 2 );
		
		//This is the left middle side label of Misses
		board.add( new Label( "Misses" ), 0, 3 );
		board.add( new Label( Integer.toString( missValue ) ), 0, 4 );
		
		//This is the left bottom side label of ships sunk
		board.add( new Label( "Sunk" ), 0, 5 );
		board.add( new Label( Integer.toString( sunkValue ) ), 0, 6 );
		
		
		
		//making the scene and stage
		Scene scene = new Scene( board );
		primaryStage.setTitle( "Battleship" );
		primaryStage.setScene( scene );
		primaryStage.show();
		
	}
}