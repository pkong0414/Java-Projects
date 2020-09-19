Project 5 readme

Program 1: encryption.java

	This program will prompt the user for a value from -128 to 127
and use it as the encryption key. The user will then be prompted to enter
the file name that will be used to store the encrypted content. Lastly the
user will be prompted to type a message that will be encrypted.

	The program will convert the message string, character by character and
then a byte array will be used to store an encrypted character value. This byte
array will be used to store in <file name>.encrypted.

Program 2: decryption.java

	This program will prompt the user for the encryption key. The user
will then be prompted to enter the file name. The file will then be opened
and its contents will be decrypted. This process is basically just a reverse of
the encrypting process, meaning the file content will be grabbed in byte form and
using the decryption key will then be stored in a byte array. This byte array will
then be converted to character form and stored in a file with the same file name
entered with a .decrypted file extension.


<not finished --please remove when finished-->
Program 3: keyfinder.java

	This program will start by prompting for a file name. The program will then
begin the decryption process. This process starts by opening up a wordlist.txt
which contains a list of common words used in text as a reference. The decryption
process will take the whole word list and compare it to the decrypted text. If the
word length matches then a comparison will take place, if not it will move on to
the next word. This process will continue on till there is a match for words in
the word list.

Note: https://en.wikipedia.org/wiki/Most_common_words_in_English the word list
uses words that are in this list.