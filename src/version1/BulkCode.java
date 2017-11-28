package version1;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The part of the code making the game playable, excluding
 * the GUI.
 * 
 * @warning Uses java.util.Scanner
 * 
 * @version 23.11.2017
 * @author Acarturk
 *
 */
public class BulkCode {

  private final int WIDTH = 17;
  
  protected boolean moveOn;
  
  private Pair head;
  private Pair bait;
  private int[][] map = new int[WIDTH][WIDTH];
  private int length;
  private boolean baitEaten;
  
  /**
   * As its name suggests, sets the initial conditions.
   * 
   * @EMPTY!!!!!!!!!!!!!!!!!!!!!
   * BTW, no need to call GraphicsOfSnake.display again.
   */
  private void setUp() {

    length = 2;
    map[8][8] = 1;
    map[8][9] = 2;
    head = new Pair(8, 9);
    bait();
    baitEaten = false;
    moveOn = true;

  }
  
  /**
   * Rotates the map clockwise 90 degrees.
   */
  private void rotate() {
    
    int[][] nonRotatedMap = map;
    int nonRotatedHeadI = head.i;
    int nonRotatedHeadJ = head.j;
    int nonRotatedBaitI = bait.i;
    int nonRotatedBaitJ = bait.j;
    
    for( int i=0; i<WIDTH; i++)
      for( int j=0; j<WIDTH; j++)
        map[i][j] = nonRotatedMap[j][WIDTH - 1 - i];
    
    head.i = nonRotatedHeadJ;
    head.j = WIDTH - 1 - nonRotatedHeadI;
    
    bait.i = nonRotatedBaitJ;
    bait.j = WIDTH - 1 - nonRotatedBaitI;
    
  }
  
  /**
   * Throws a bait to somewhere not a part of the snake.
   * Used an ineffective algorithm.
   */
  private void bait() {
    
    bait = new Pair( ThreadLocalRandom.current().nextInt(0, WIDTH),
                     ThreadLocalRandom.current().nextInt(0, WIDTH) );
    
    if( map[bait.i][bait.j] != 0 )
      bait();
    
  }
  
  /**
   * A quite long and frustratingly hard updating, a.k.a.
   * movement, algorithm. PIECE IT DOWN!!!!!!!!!!!!!!!!!!
   * 
   * @param ch, the input char.
   */
  private void update( char ch ) {
    
    switch( ch ) {
    case 'w': case 'W': case '8':
      rotate();
      break;
    case 'a': case 'A': case '4':
      rotate(); rotate();
      break;
    case 's': case 'S': case '2':
      rotate(); rotate(); rotate();
      break;
    default:
      break;
    }
    
    head.j++;
    
    if( head.j == WIDTH || map[head.i][head.j] != 0 ) {
      moveOn = false;
      return;
    }
    
    if( head.equals( bait ) ) {
      length++;
      baitEaten = true;
    }
    
    map[head.i][head.j] = length + 1;
    
    for( int i=0; i<WIDTH; i++)
      for( int j=0; j<WIDTH; j++)
        if( map[i][j] != 0 )
          map[i][j]--;
    
    if( baitEaten )
      bait();
    
    switch( ch ) {
    case 'w': case 'W': case '6':
      rotate(); rotate(); rotate();
      break;
    case 'a': case 'A': case '4':
      rotate(); rotate();
      break;
    case 's': case 'S': case '2':
      rotate();
      break;
    default:
      break;
    }
    
  }
  
  /**
   * Empty constructor for class BulkCode.
   * Plays the game whenever an object is constructed.
   */
  BulkCode() {

    Scanner in = new Scanner( System.in );
    guiVersion1 graphics = new guiVersion1();
    
    setUp();
    
    do {
      
      graphics.display( map, head, bait );
      update( in.next().charAt(0) );
      
    } while( moveOn );
    
    in.close();
    
  }
  
}
