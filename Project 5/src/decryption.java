/* Project 5
*  Patrick Kong
*  CS2261
*  
*  This is the decryption program
*  The program will start by prompting user to enter a decryption key (-128 to 127).
*  Next the user will then enter the filename they want to decrypt.
*  The file will then be read and decrypted. The content will be written
*  to a file of the same filename. However, instead will contain a .decrypted
*  file extension.
*  
*/

import java.io.*;
import java.util.Scanner;

public class decryption{
public static void main( String[] args ) throws IOException {
		
		//this will be used to take in the decryption key
		Scanner input = new Scanner( System.in );
		int decryptionKey;
		
		//prompting user for the decryption key
		do {
			System.out.print( "Please enter the number for the encryption key(-128 to 127): " );
		
			decryptionKey = input.nextInt();
		}while( decryptionKey < -128 || decryptionKey > 127 );
		//prompting user for the encrypted file's name
		System.out.println( "Please enter the filename you would like this message to go to" );
		System.out.print( "filename: " );
		String fileName = input.next();
		
		//reading file
		File file = null;
		FileInputStream fileInput = new FileInputStream( file = new File( "./" + fileName + ".encrypted" ) );
		byte[] decryptByte = new byte[ (int) file.length() ];
		
		fileInput.read( decryptByte, 0, decryptByte.length );
		
		//closing fileInput
		fileInput.close();
		
		//this is where the decryption happens
		int count = 0;
		
		System.out.println( "decrypting message..." );
		System.out.print( "message: ");
		
		
		while( count < decryptByte.length ) {
			
			//taking a character before converting it to a byte with encryption key.
			decryptByte[ count ] = (byte)( decryptByte[ count ] - decryptionKey );
			
			//incrementing count
			count++;
		}
		
		char decryptedMessage[] = new char[ count ];
		
		//converting file's byte content to characters
		for( int i = 0; i < count; i++ ) {
			
			decryptedMessage[ i ] = (char)decryptByte[ i ];
			
			//outputting file content
			System.out.print( decryptedMessage[ i ] );
		}
		
		System.out.println();
		
		//after decryption, this message will then be written to a .decrypted file.
		System.out.println( "Writing decrypted message to a new file..." );
		//creating a new file called <fileName>.decrypted
		
		try(
			FileOutputStream fileOutput = new FileOutputStream( "./" + fileName + ".decrypted" );
		) {
			//writing the byte characters into the file
			for( int i = 0; i < count; i++ ) {
				fileOutput.write( decryptedMessage[ i ] );
			}
			
			//closing fileOutput
			fileOutput.close();
		}
		
		System.out.println( "Done!" );
		System.out.println( "The file: " + fileName + ".decrypted will contain the decrypted message" );
		
		//closing input
		input.close();
	}
}