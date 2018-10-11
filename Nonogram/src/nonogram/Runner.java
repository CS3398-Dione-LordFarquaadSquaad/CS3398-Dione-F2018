/* TO-DO:
 * - Use GUI to implement the grid for the webapp.
 * - Develop a menu for the grid screen with tools to use for editing
 * - There will be two types of grids: Solving and Creating
 *   - Solving: The user inputs the parameters to have the webapp solve it
 *   - Creating: The user draws the nonogram and the webapp creates the parameters
 * - Maybe start with the menu first if it will be implemented.
 */

package nonogram;

import java.io.IOException;
import java.util.Scanner;

import java.awt.*; // basic awt classes
import java.awt.geom.*;
import java.awt.event.*; // event classes (needed for ActionListener)
import javax.swing.*; // imports swing GUI libraries

public class Runner {
  
  public static Nonogram nonogram;
  
  public Runner() throws IOException {
    nonogram = new Nonogram();
  }
  
  public static class ButtonListener implements ActionListener {
    private int nEvents = 0;
    
    public void actionPerformed(ActionEvent e) {
      nEvents++;
      System.out.println(e.getActionCommand() + " " + nEvents);
    }
  }
  
  public static void main(String[] args) throws Exception {
    
    Runner blah = new Runner();
    
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
        JOptionPane.showMessageDialog(frame1, "Not fully implemented, so enjoy this grid.");
        
        JFrame frameSolve = new JFrame("Solve");
        //JPanel grid = new DrawNonogram();
        
        DrawNonogram grid = new DrawNonogram();
        grid.length = Integer.parseInt(JOptionPane.showInputDialog("Enter the Grid Length:", nonogram.getLength()));
        grid.width = Integer.parseInt(JOptionPane.showInputDialog("Enter the Grid Width:", nonogram.getWidth()));
        grid.color = nonogram.getColor();
        
        frameSolve.add(grid);
        frameSolve.setSize(800,600);
        frameSolve.setVisible(true);
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
        
        JTextField defaultGrid = new JTextField("The default grid size is " + l + " x " + w + ".");
        JTextField colSel = new JTextField("Current color: " + nonogram.getColor());

        // create settings buttons and extra text fields
        
        // change the default grid size upon enterning new menu
        JButton defaultGridButton = new JButton("Default Grid Size");
        defaultGridButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
            try {
              int le = Integer.parseInt(JOptionPane.showInputDialog("Enter the Default Grid Length:", ""));
              int wi = Integer.parseInt(JOptionPane.showInputDialog("Enter the Default Grid Width:", ""));
              nonogram.setLength(le);
              nonogram.setWidth(wi);
              JOptionPane.showMessageDialog(frameSettings, "The Default Grid size was updated.");
              defaultGrid.setText("The default grid size is " + le + " x " + wi + ".");
            }
            catch (Exception e) {
              JOptionPane.showMessageDialog(frameSettings, "Invalid input entered. Cancelled.");
            }
          }
        });
        
        // change the color of the nonogram (if actually implemented)
        JButton colorButton = new JButton("Colors");
        colorButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {          
            //initialize color frame
            JFrame frameColor = new JFrame("Colors");
            
            // string of all possible colors
            final String [] colors = {"Black", "Dark Gray", "Gray", "Light Gray",
                                      "Red", "Orange", "Yellow", "Green", "Blue",
                                      "Cyan", "Magenta", "Pink"};
            
            // set up elements for frame            
            JLabel instr = new JLabel("Pick a color:");
 
            JComboBox color = new JComboBox(colors);
            color.setSelectedIndex(0);
            color.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent event) {
                String colorSelect = (String)color.getSelectedItem();
                nonogram.setColor(colorSelect);
                colSel.setText("Current color: " + nonogram.getColor());
              }
            }); 
            
            // add elements, draw frame
            frameColor.setLayout(null);
            frameColor.add(instr);
            instr.setBounds(105,10,200,25);
            frameColor.add(color);
            color.setBounds(70,40,150,25);
            
            frameColor.setSize(300,200);
            frameColor.setVisible(true);
          }
        });
        
        // change the background music (or turn it off) (if actually impemented)
        JButton musicButton = new JButton("Music");
        musicButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(frameSettings, "Custom music not yet implemented. :(");
          }
        });
        
        
        // add buttons and fields, show settings frame
        frameSettings.setLayout(null); // absolute layout
        frameSettings.add(defaultGridButton); // default grid button
        defaultGridButton.setBounds(192,10,400,75); // x, y, l, w
        frameSettings.add(defaultGrid); // default grid text field
        defaultGrid.setBounds(192,85,400,25);
        frameSettings.add(colorButton); // custom color button
        colorButton.setBounds(192,125,400,75);
        frameSettings.add(colSel);
        colSel.setBounds(192,200,400,25);
        frameSettings.add(musicButton); // custom music button
        musicButton.setBounds(192,240,400,75);
        
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
  }
  
}
