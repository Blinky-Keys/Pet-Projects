package simplecipher;

/**
 *
 * @author Nathan Ellison
 *
 * Use this source code to encrypt data using a ceasar cipher with a shift value
 * of your choice.
 */
import java.util.Scanner;
import java.util.ArrayList;

public class SimpleCipher {

    private static Scanner input = new Scanner( System.in );
    private static int shift;
    private static ArrayList alphabet = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        // TODO code application logic here
        init();

        while( true ) {
            System.out.println( "Which operation would you like to perform?" );
            System.out.println( "E: Encrypt    D: Decrypt    Q: Quit" );
            System.out.println( "" );
            switch( Character.toLowerCase( input.nextLine().charAt( 0 ) ) ) {
                case 'e':
                    encrypt();
                    break;

                case 'd':
                    decrypt();
                    break;

                case 'q':
                    System.exit( 0 );

                default:
                    System.out.println( "Please enter a valid operation" );
            }
        }
    }

    private static void encrypt() {

        String cipherText = "";
        String plainText = "";

        System.out.println( "Please enter shift value: " );
        shift = Integer.parseInt( input.nextLine() );

        System.out.println( "Please enter a phrase: " );

        plainText = input.nextLine();

        for( int i = 0; i < plainText.length(); i++ ) {
            int temp = (plainText.charAt( i )) - 'a' + shift;
            cipherText += alphabet.get( Integer.parseInt( String.valueOf( temp ) ) );
        }
        System.out.println( cipherText );
    }

    private static void decrypt() {
        String plainText = "";

        System.out.println( "Please enter shift value: " );
        shift = Integer.parseInt( input.nextLine() );

        System.out.println( "Please enter ciphertext: " );
        String cipherText = input.nextLine();

        for( int i = 0; i < cipherText.length(); i++ ) {
            int temp = cipherText.charAt( i );
            plainText += String.valueOf( temp ) + shift + " ";
        }
        System.out.println( plainText );
    }

    private static void init() {
        String[] temp = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for( int i = 0; i < temp.length; i++ ) {
            alphabet.add( temp[i] );
        }
    }
}
