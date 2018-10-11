package nonogram;

import java.awt.*; // basic awt classes
import java.awt.geom.*;
import java.awt.event.*; // event classes (needed for ActionListener)
import javax.swing.*; // imports swing GUI libraries
import java.lang.*;

public class Nonogram extends JPanel {
  // variables
  private int len;
  private int wid;
  private String color;

  public Nonogram() {
    len = 3;
    wid = 3;
    color = "Black";
  }
  
  // setters
  public void setLength(int l){len = l;}
  public void setWidth(int w){wid = w;}
  public void setColor(String c){color = c;}
  
  // getters
  public int getLength(){return len;}
  public int getWidth(){return wid;}
  public String getColor(){return color;}
}
