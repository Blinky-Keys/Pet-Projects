/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciphers;

import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author Nathan Ellison
 */
public interface cipher {

    public enum Strength {
        Weak, Moderate, Strong
    }

    public ArrayList alphabet = new ArrayList<>( Arrays.asList( 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' ) );

    String encrypt( String plainText, String key );

    String decrypt( String cipherText, String key );
}
