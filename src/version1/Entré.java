package version1;

/**
 * Class holding the main(String[] args) method.
 * Makes Java enter the game.
 * 
 * 
 * @version 23.11.2017
 * <h1>Complete</h1>
 * @author Acarturk
 *
 */
public class Entré {

  public static void main(String[] args) {

    BulkCode game = new BulkCode();
    
    if( !game.moveOn )
      System.out.println( "Game over." );

  }

}
