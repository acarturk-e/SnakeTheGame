package version1;

/**
 * A class which its objects hold a sorted tuple of integers.
 * 
 * @version 23.11.2017
 * <a>Without bugs</a>
 * @author Acarturk
 *
 */
public class Pair {

  public int i; public int j;
  
  /**
   * The constructor by which sets the values of the numbers.
   * 
   * @param i
   * @param j
   */
  Pair( int i, int j) {
    this.i = i;
    this.j = j;
  }
  
  /**
   * Method comparing two Pair objects with regard to the values
   * of their int i and int j fields.
   * 
   * @param Pair otherPair
   * @return Whether are these two pairs equivalent or not.
   */
  boolean equals( Pair otherPair ) {
    return ( this.i == otherPair.i ) && ( this.j == otherPair.j );
  }
  
}
