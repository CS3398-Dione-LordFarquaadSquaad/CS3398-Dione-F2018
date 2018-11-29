package nonogram;

import java.io.IOException;

import java.awt.*; // basic awt classes
import java.awt.geom.*;
import java.awt.event.*; // event classes (needed for ActionListener)
import java.awt.Color;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import javax.swing.*; // imports swing GUI libraries
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.GroupLayout.*;

public class DrawSolution extends JPanel{
  // variables
  public int length;
  public int height;
  public String color;
  public int maxParam;
  public int elemSize;
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    JFrame frameSol = new JFrame();
    Graphics2D g2 = (Graphics2D) g;
    
    // get length, height, and color of solution
    try {
      FileReader fin = new FileReader("answer.txt");
      BufferedReader bin = new BufferedReader(fin);
      Scanner read = new Scanner(bin);
      
      int l = length;
      int h = height;
      int p = maxParam;
      int s = elemSize;
      
      // x and y position trackers, read int
      int x = 80;
      int y = 80;
      int r = 0;
      
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
      
      // draw the solution
      for(int i = 0; i < l; i++) {
        x = 80;
        for(int j = 0; j < h; j++) {
          // read next int. if 2, full square. else, blank square
          r = read.nextInt();
          if(r == 2)
            g2.fillRect(x,y,s,s);
          else
            g2.drawRect(x,y,s,s);
          x += s;
        }
        y += s;
      }
      read.close();
      bin.close();
      fin.close();
    }
    catch(Exception e) {
      JOptionPane.showMessageDialog(frameSol, "A fatal error has occured and the program needed to close. Sorry :(");
      System.exit(0);
    }
  }
}
