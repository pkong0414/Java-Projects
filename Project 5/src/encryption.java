/* Project 5
*  Patrick Kong
*  CS2261
*  
*  encryption.java
*  
*  	This program will prompt the user to enter int values from -128 to 127.
*  The value will be used as an encryption key.
*  User will then enter a message to be encrypted.
*  Lastly the user will be asked to enter the file name
*  The file will then be encrypted and will be output to an encrypted file with 
*  a .encrypted file extension
*  
*/

import java.io.*;
import java.util.Scanner;

public class encryption{
	public static void main( String[] args ) throws IOException {
		
		//this will be used to take in the encryption key
		//and also the message for the encryption
		Scanner input = new Scanner( System.in );
		int encryptionKey;
		
		//prompting user for the encryption key
		do {
			System.out.print( "Please enter the number for the encryption key(-128 to 127): " );
			encryptionKey = input.nextInt();
		}while( encryptionKey < -128 || encryptionKey > 127 );
		//prompting user for the encrypted filename
		System.out.println( "Please enter the filename you would like this message to go to" );
		System.out.print( "filename: " );
		String fileName = input.next();
		
		input.nextLine();
	
		//prompting user for the message
		System.out.println( "Please enter the message you would like to encrypt:" );
		System.out.print( "message: " );
		String message = input.nextLine();
		
		//getting the message character size
		int count = 0;
		char ch;
		
		byte encryptedMessage[] = new byte[ message.length() ]; 
		System.out.println( "Encrypting message..." );
		while( count < message.length() ) {
			
			//taking a character before converting it to a byte with encryption key.
			ch = message.charAt( count );
			encryptedMessage[ count ] = (byte)( ch + encryptionKey );
			
			//incrementing count
			count++;
			
		}
		
		//creating a new file called plaintext.encrypted
		File file = new File( "./" + fileName + ".encrypted" );
		
		try( 
			FileOutputStream fileOutput = new FileOutputStream( "./" + fileName + ".encrypted" );
		) {
			//writing the byte characters into the file
			for( int i = 0; i < count; i++ ) {
				fileOutput.write( encryptedMessage[ i ] );
			}
			
			//closing fileOutput
			fileOutput.close();
		}
		
		System.out.println( "Done!" );
		System.out.println( "The file: " + fileName + ".encrypted will contain the encrypted message" );
		
		//closing input
		input.close();
	}
}