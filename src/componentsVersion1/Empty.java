package componentsVersion1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * MAY HAVE MISTAKES!!!!!!!!!!!!!!!!!!!
 * on the orientation of the x-y axes.
 * 
 * @author Acarturk
 *
 */
public class Empty extends JComponent {

  /**
   * 
   */
  private static final long serialVersionUID = -7201075810520427594L;

  int i, j;
  
  public Empty( int i, int j ) {

    this.i = i;
    this.j = j;

  }
  
  public void paintComponent( Graphics g ) {

    g.setColor(Color.CYAN);
    g.fillRect(50*j, 50*i, 50, 50);

  }

}
