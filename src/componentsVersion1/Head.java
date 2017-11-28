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
public class Head extends JComponent {

  /**
   * 
   */
  private static final long serialVersionUID = -7201075810520427594L;

  int i, j;
  
  public Head( int i, int j ) {

    this.i = i;
    this.j = j;

  }
  
  public void paintComponent( Graphics g ) {

    g.setColor(Color.BLACK);
    g.fillOval(50*j+5, 50*i+5, 44, 44);
    
    g.setColor(Color.CYAN);
    g.fillOval(50*j+7, 50*i+7, 40, 40);

  }

}
