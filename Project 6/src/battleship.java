/* battleship.java
 * Patrick Kong
 * 
 * 
 * This program will contain a non working model ui of a game battleship.
 * The board will consist of grid in a 10 x 10 configuration.
 * 
 */

import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class battleship extends Application {
	@Override
	public void start( Stage primaryStage ) {
		
		//javaFX attributes
		//creates a new GridPane called board
		GridPane board = new GridPane();
		board.setAlignment( Pos.CENTER );
		board.setPadding( new Insets( 16, 16, 16, 16 ) );
		board.setHgap( 1 );
		board.setVgap( 1 );
		String contextStr = "Select a square.";
		Label cText = new Label( contextStr );
		HBox topBox = new HBox();
		topBox.getChildren().add( cText );
		topBox.setAlignment( Pos.CENTER );
		
		//GridPane.setConstraints( cText, 5, 0, 1, 1, HPos.CENTER,
		//	VPos.TOP , Priority.NEVER, Priority.NEVER, new Insets( 16, 16, 16, 16 ) );
		
		int hits = 0;
		int misses = 0;
		int sunk = 0;
		
		//This is the left top side label of hits
		board.add( new Label( "Hits" ), 0, 5);
		board.add( new Label( Integer.toString( hits ) ), 0, 6 );
		
		//This is the left middle side label of Misses
		board.add( new Label( "Misses" ), 0, 7 );
		board.add( new Label( Integer.toString( misses ) ) , 0, 8 );
		
		//This is the left bottom side label of ships sunk
		board.add( new Label( "Sunk" ), 0, 9 );
		board.add( new Label( Integer.toString( sunk ) ), 0, 10 );
		
		
		//making buttons for the pane
		for( int x = 1; x <= 10; x++ ) {
			for( int y = 5; y <= 14; y++ ) {
				//adding in buttons for the battleship game
				Button button = new Button( "O" );
				board.add( button, x, y );
				
			}
		}
		
		//Implementing a BorderPane
		BorderPane region = new BorderPane();
		region.setCenter( board );
		region.setTop( topBox );
		BorderPane.setAlignment( topBox, Pos.TOP_CENTER );
		
		//making the scene and stage
		Scene scene = new Scene( region );
		primaryStage.setTitle( "battleship" );
		primaryStage.setScene( scene );
		primaryStage.show();
		
	}
	
	public static void main( String[] args ) {
		launch( args );
	}
}