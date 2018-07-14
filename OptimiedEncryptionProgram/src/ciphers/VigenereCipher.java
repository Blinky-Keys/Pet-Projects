/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciphers;

import java.util.ArrayList;

/**
 *
 * @author Nathan Ellison
 */
public class VigenereCipher implements cipher {

    private String name = "Vigenere Cipher";

    private char cipherTable[][] = new char[26][26];

    /**
     * This method first takes the length of the plaintext and then repeats the
     * key word for until it is of equal length.
     *
     * @param plainText
     * @param key
     *
     * @return
     */
    public String encrypt( String plainText, String key ) {
        fillTable();

        String cipherText = "";
        String repeatedKey = "";
        int count = 0;
        int keyCharacterPos = 0;

        //Repeat the key word until the length is equal to the length
        //of the plain text
        while( count <= plainText.length() ) {
            if( keyCharacterPos < key.length() ) {
                repeatedKey += key.charAt( keyCharacterPos );
                keyCharacterPos++;
            } else {
                keyCharacterPos = 0;
            }
            count++;
        }

        //Debugging
        System.out.println( "Repeated key: " + repeatedKey );

        //Navigate to the point in the cipher table where the current letters
        //of the key and the plaintext intersect and add the letter at that
        //position to the ciphertext output string
        for( int i = 0; i < plainText.length(); i++ ) {

            int plainTextCharacterPos = (int) plainText.charAt( i ) - 'a';
            int repeatedKeyCharacterPos = (int) repeatedKey.charAt( i ) - 'a';

            //Debugging
            System.out.println( plainTextCharacterPos );
            System.out.println( repeatedKeyCharacterPos );

            cipherText += cipherTable[plainTextCharacterPos][repeatedKeyCharacterPos];
        }

        return cipherText;
    }

    public String decrypt( String cipherText, String key ) {
        fillTable();

        return null;
    }

    /**
     * This method fills the 2D array that represents the Vigenere cipher table.
     * The cursor refers to the point
     */
    public void fillTable() {
        char tempArray[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        int cursor = 0;
        int bump = 0;

        for( int i = 0; i < cipherTable.length; i++ ) {
            for( int j = 0; j < cipherTable[i].length; j++ ) {
                cipherTable[i][j] = tempArray[cursor];
                if( cursor < 25 ) {
                    cursor++;
                } else {
                    cursor = 0;
                }
            }
            if( bump < 25 ) {
                cursor = 1 + (bump++);
            } else {
                bump = 0;
            }
        }

        //Print the cipher table
        for( int i = 0; i < cipherTable.length; i++ ) {
            for( int j = 0; j < cipherTable[i].length; j++ ) {
                System.out.print( cipherTable[i][j] + " " );
            }
            System.out.println( "" );
        }
    }
}
