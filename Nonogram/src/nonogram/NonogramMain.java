/* TO-DO:
 * - Use GUI to implement the grid for the webapp.
 * - Develop a menu for the grid screen with tools to use for editing
 * - There will be two types of grids: Solving and Creating
 *   - Solving: The user inputs the parameters to have the webapp solve it
 *   - Creating: The user draws the nonogram and the webapp creates the parameters
 * - Maybe start with the menu first if it will be implemented.
 */

package nonogram;

import java.awt.*; // basic awt classes
import java.awt.event.*; // event classes (needed for ActionListener)
import javax.swing.*; // imports swing GUI libraries

public class NonogramMain {

  public static Nonogram nonogram;
  public NonogramMain() {
    nonogram = new Nonogram();
  }
  
  public static class ButtonListener implements ActionListener {
    private int nEvents = 0;
    
    public void actionPerformed(ActionEvent e) {
      nEvents++;
      System.out.println(e.getActionCommand() + " " + nEvents);
    }
  }
  
  public static void main(String[] args) {
    System.out.println("Starting...");
    
    // create main frame
    JFrame frame1 = new JFrame("Ye Olde Nonogram Nannick");
    frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    ButtonListener listen = new ButtonListener();
    //JTextField text = new JTextField("");
    
    // create the buttons and make them move to new screens
    
    // solve
    JButton solveButton = new JButton("Solve");
    solveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(frame1, "Not yet implemented :(");
      }
    });
    
    // create (probably won't be implemented)
    JButton createButton = new JButton("Create");
    createButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(frame1, "Coming (no where near) soon!");
      }
    });
    
    // settings (default grid, ...)
    JButton settingsButton = new JButton("Settings");
    settingsButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // variables for settings screen
        int l = nonogram.getLength();
        int w = nonogram.getWidth();

        // create settings frame
        JFrame frameSettings = new JFrame("Settings");
        
        // create settings buttons and extra text fields
        JButton defaultGridButton = new JButton("Default Grid Size");
        defaultGridButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
            int le = Integer.parseInt(JOptionPane.showInputDialog("Enter the Default Grid Length:", ""));
            int wi = Integer.parseInt(JOptionPane.showInputDialog("Enter the Default Grid Width:", ""));
            nonogram.setLength(le);
            nonogram.setWidth(wi);
            JOptionPane.showMessageDialog(frameSettings, "The Default Grid size was updated.");
          }
        });
        
        JTextField defaultGrid = new JTextField("The default grid size is " + l + " x " + w + ".");
        
        // add buttons and fields, show settings frame
        frameSettings.setLayout(null); // absolute layout
        frameSettings.add(defaultGridButton);
        defaultGridButton.setBounds(192,10,400,75); // x, y, l, w
        frameSettings.add(defaultGrid);
        
        
        frameSettings.setSize(800, 600);
        frameSettings.setVisible(true);
      }
    });
    
    // draw the main frame 
    frame1.setLayout(null); // absolute layout for complete control
    frame1.add(solveButton);
    solveButton.setBounds(5,5,375,325); // x pos, y pos, length, width
    frame1.add(createButton);
    createButton.setBounds(400,5,375,325);
    frame1.add(settingsButton);
    settingsButton.setBounds(5,350,770,190);
    
    frame1.setSize(800, 600); // intention: make the webapp 800x600
                              // makes it visible on most monitors
    frame1.setVisible(true); // makes frame1 visible on startup
    
    System.out.println("Closing...");
  }
  
}
