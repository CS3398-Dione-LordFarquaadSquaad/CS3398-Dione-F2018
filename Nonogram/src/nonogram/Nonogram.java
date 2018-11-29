package nonogram;

import java.awt.*; // basic awt classes
import java.awt.geom.*;
import java.awt.event.*; // event classes (needed for ActionListener)
import javax.swing.*; // imports swing GUI libraries
import java.lang.*;

public class Nonogram extends JPanel {
  // variables
  private int len;
  private int hei;
  private String color;
  private int maxParam;
  private int elemSize;

  public Nonogram() {
    len = 5;
    hei = 5;
    color = "Black";
    maxParam = 2;
    elemSize = 25;
  }
  
  // setters
  public void setLength(int l){len = l;}
  public void setHeight(int h){hei = h;}
  public void setColor(String c){color = c;}
  public void setMaxParam(int p){maxParam = p;}
  public void setElemSize(int s){elemSize = s;}
  
  // getters
  public int getLength(){return len;}
  public int getHeight(){return hei;}
  public String getColor(){return color;}
  public int getMaxParam(){return maxParam;}
  public int getElemSize(){return elemSize;}
}
