/*  Project 5
 *  Patrick Kong
 *  
 *  keyfinder.java
 *  
 *  The goal of the keyfinder is to take an encrypted file and find the
 *  decrypt key for it. Idea is to have a word list to cross reference
 *  the decryption. To ensure a good decryption, each successful decrypt
 *  will increment a decryptCount and associate with a decryptKey. After
 *  values (-128 to 127) is finished the decryptKey with the associated
 *  value will be used in the final comparison process.
 *  
 */

import java.io.*;
import java.util.Scanner;

public class keyfinder{
public static void main( String[] args ) throws IOException {
		
		//this will be used to take in the file name
		Scanner input = new Scanner( System.in );
		
		//decryptionKey will contain 2 things.
		//1st dim array will be for the decryption key values
		//2nd dim array will be the count associated with the key
		int[] decryptionKey = new int [ 256 ];
		int count = -128;
		
		for( int k = 0; k < 256; k++ ) {
			
			//populating decryptionKey values
			decryptionKey[ k ] = count;
			count++;
		}
		
		//populating an array of strings called wordList
		File load = null;
		FileInputStream fileLoad = new FileInputStream( load = new File( "wordList.txt" ) );
		while( fileLoad.read() != -1 ) {
			
		}
		
		
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
		//int count = 0;
		
		System.out.println( "decrypting message..." );
		while( count < decryptByte.length ) {
			
			//taking a character before converting it to a byte with encryption key.
			//decryptByte[ count ] = (byte)( decryptByte[ count ] - decryptionKey );
			
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