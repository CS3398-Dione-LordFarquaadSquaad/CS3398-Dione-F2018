package nonogram;
import java.lang.*;

public class Nonogram {
  // variables
  private int len;
  private int wid;
  private String lengthStr;
  private String widthStr;

  public Nonogram() {
    len = 3;
    wid = 3;
    lengthStr = "3";
    widthStr = "3";
  }
  
  // setters
  public void setLength(int l){len = l;}
  public void setLengthFromStr(String l) {
    lengthStr = l;
    len = Integer.parseInt(lengthStr);
  }
  public void setWidth(int w){wid = w;}
  public void setWidthFromStr(String w) {
    widthStr = w;
    wid = Integer.parseInt(widthStr);
  }
  // getters
  public int getLength(){return len;}
  public int getWidth(){return wid;}
}
