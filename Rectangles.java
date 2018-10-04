import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rectangles extends JPanel {

  
    
    public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    //g2d.setColor(new Color(212, 212, 212));
    //g2d.drawRect(10, 15, 90, 60);


    g2d.setColor(new Color(31, 21, 1));
    g2d.fillRect(10*l, 10*w, 20, 20);

  }

  public static void main(String[] args) {
    Rectangles rects = new Rectangles();
    JFrame frame = new JFrame("Rectangles");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(rects);
    frame.setSize(360, 300);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
  
  private int l;
  private int w;
}
