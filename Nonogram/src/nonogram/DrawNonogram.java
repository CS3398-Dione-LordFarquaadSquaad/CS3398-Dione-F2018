package nonogram;

import java.io.IOException;

import java.awt.*; // basic awt classes
import java.awt.geom.*;
import java.awt.event.*; // event classes (needed for ActionListener)
import javax.swing.*; // imports swing GUI libraries

public class DrawNonogram extends JPanel {
  
  // variables (made public for easy editing, this is a bad practice though)
  public int length;
  public int width;
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    JFrame frame = new JFrame();
    
    Graphics2D g2 = (Graphics2D) g;
    
    // get length and width of grid
    try {
      int l = length;
      int w = width;
      
      // x and y trackers
      int x = 80;
      int y = 80;
    
      g2.setColor(Color.black);
    
      //draw the grid
      for(int i = 0; i < l; i++) {
        y = 80;
        for(int j = 0; j < w; j++) {
          g2.drawRect(x,y,22,22);
          y += 22;
        }
        x += 22;
      }
    }
    
    catch (Exception e) {
      JOptionPane.showMessageDialog(frame, "Invalid Input. Cancelled.");
    }
      
      
  }
}
