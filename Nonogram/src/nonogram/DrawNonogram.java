package nonogram;

import java.io.IOException;

import java.awt.*; // basic awt classes
import java.awt.geom.*;
import java.awt.event.*; // event classes (needed for ActionListener)
import java.awt.Color;
import javax.swing.*; // imports swing GUI libraries
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.GroupLayout.*;

public class DrawNonogram extends JPanel {
  
  // variables (made public for easy editing, this is a bad practice though)
  public int length;
  public int height;
  public String color;
  public int maxParam;
  
  
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    JFrame frame = new JFrame();
    
    Graphics2D g2 = (Graphics2D) g;
    
    // get length and height of grid
    try {
      int l = length;
      int h = height;
      int p = maxParam;
      
      // x and y position trackers
      int x = 120;
      int y = 120;
    
      switch(color){
        case("Black"): g2.setColor(Color.BLACK); break;
        case("Dark Gray"): g2.setColor(Color.DARK_GRAY); break; 
        case("Gray"): g2.setColor(Color.GRAY); break;
        case("Light Gray"): g2.setColor(Color.LIGHT_GRAY); break;
        case("Red"): g2.setColor(Color.RED); break;
        case("Orange"): g2.setColor(Color.ORANGE); break;
        case("Yellow"): g2.setColor(Color.YELLOW); break;
        case("Green"): g2.setColor(Color.GREEN); break;
        case("Blue"): g2.setColor(Color.BLUE); break;
        case("Cyan"): g2.setColor(Color.CYAN); break;
        case("Magenta"): g2.setColor(Color.MAGENTA); break;
        case("Pink"): g2.setColor(Color.PINK); break;
      }

      //draw the grid
      for(int i = 0; i < l; i++) {
        y = 120;
        for(int j = 0; j < h; j++) {
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
