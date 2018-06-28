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
public class CaesarCipher implements cipher {

    private final String name = "Casear Cipher";
    private int key;

    @Override
    public String encrypt( String plainText, String key ) {
        try {
            this.key = Integer.parseInt( key );
            String cipherText = "";

            for( int i = 0; i < plainText.length(); i++ ) {
                cipherText += alphabet.get( plainText.charAt( i ) - 'a' + this.key );
            }

            return cipherText;

        } catch( NumberFormatException e ) {
            return "Please enter a valid integer key";
        }

    }

    @Override
    public String decrypt( String cipherText, String key ) {
        try {
            this.key = Integer.parseInt( key );
            String plainText = "";

            for( int i = 0; i < cipherText.length(); i++ ) {
                plainText += (char) (cipherText.charAt( i ) - this.key);
            }

            return plainText;

        } catch( NumberFormatException e ) {
            return "Please enter a valid integer key";
        } catch( ArrayIndexOutOfBoundsException e ) {
            System.out.println( "Array index out of bounds" );
        }
        return null;
    }
}
