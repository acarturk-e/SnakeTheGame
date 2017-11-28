package version1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * The designated part of code responsible for constructing
 * an graphical user interface, also known as the 'GUI'.
 * 
 * @version 23.11.2017
 * @author Acarturk
 *
 */
public class guiVersion1 {

  JFrame frame = new JFrame();
  
  /**
   * Empty constructor for class guiVersion1.
   * Sets up the frame when an object class is constructed.
   */
  public guiVersion1() {

    frame.setSize(965, 988);
    frame.setTitle("Snake the Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JComponent component = new JComponent() {

      /**
       * 
       */
      private static final long serialVersionUID = 3618690118992608545L;
      
      public void paintComponent( Graphics g ) {

        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 950, 950);
        
        g.setColor(Color.BLACK);
        g.fillRect(5, 5, 940, 940);
        
        g.setColor(Color.CYAN);
        g.fillRect(50, 50, 850, 850);

      }
      
    };
    
    frame.add(component);
    frame.setVisible(true);

  }
  
  /**
   * Method drawing the given map.
   * 
   * @param map
   */
  void display( int[][] map, Pair head, Pair bait) {

    for( int i=0; i<17; i++) {
      for( int j=0; j<17; j++) {
        if( head.equals( new Pair(i,j) ) )
          frame.add( new componentsVersion1.Head(i+1, j+1) );
        else if( bait.equals( new Pair(i,j) ) )
          frame.add( new componentsVersion1.Bait(i+1, j+1) );
        else if( map[i][j] != 0)
          frame.add( new componentsVersion1.Snake(i+1, j+1) );
        else
          frame.add( new componentsVersion1.Empty(i+1, j+1) );
        
      }
      
    }

  }

}
