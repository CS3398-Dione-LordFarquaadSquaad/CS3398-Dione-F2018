package nonogram;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
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
        //frameSolve.setLayout(null);
        
        // First, gather the basic nonogram data
        DrawNonogram grid = new DrawNonogram();
        try {
          int l = Integer.parseInt(JOptionPane.showInputDialog("(1/3) Enter the grid length:", nonogram.getLength()));
          int h = Integer.parseInt(JOptionPane.showInputDialog("(2/3) Enter the grid width:", nonogram.getHeight()));
          int p = Integer.parseInt(JOptionPane.showInputDialog("(3/3) Enter the maximum number of parameters:", nonogram.getMaxParam()));
        
          // Next, draw the grid
          grid.length = l;
          grid.height = h;
          grid.maxParam = p;
          grid.color = nonogram.getColor();
          frameSolve.add(grid);
          grid.setBounds(0,0,1000,1000);
        
          frameSolve.setLayout(null);
        
          // Next, draw the text boxes
          JTextField[][] tpFields = new JTextField[l][p];
          JTextField[][] spFields = new JTextField[h][p];
        
          // x and y pos trackers
          int x = 120;
          int y = 98;
        
          for(int i = 0; i < l; i++){
            y = 98;
            for(int j = 0; j < p; j++){
              tpFields[i][j] = new JTextField("0");
              frameSolve.add(tpFields[i][j]);
              tpFields[i][j].setBounds(x,y,22,22);
              y -= 22;
            }
            x += 22;
          }
        
          x = 98;
          y = 120;
        
          for(int i = 0; i < h; i++){
            x = 98;
            for(int j = 0; j < p; j++){
              spFields[i][j] = new JTextField("0");
              frameSolve.add(spFields[i][j]);
              spFields[i][j].setBounds(x,y,22,22);
              x -= 22;
            } 
            y += 22;
          }
         
          // Next, make a solve button
          JButton solverButton = new JButton("Enter the parameters above, and then click here for the solution!");
          solverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              // print the parameters to a file and send to solveAlg
              try {
                FileWriter fout = new FileWriter("param.txt", false); // true = add to file, false = rewrite file
                BufferedWriter outf = new BufferedWriter(fout);
              
                for(int i = 0; i < l; i++) {
                  for(int j = 0; j < p; j++) {
                    outf.write(tpFields[i][j].getText() + " ");
                  }
                  outf.newLine();
                }
                outf.newLine();
              
                for(int i = 0; i < h; i++) {
                  for(int j = 0; j < p; j++) {
                    outf.write(spFields[i][j].getText() + " ");
                  }
                  outf.newLine();
                }
              
                outf.close();
                fout.close();
              
                JOptionPane.showMessageDialog(frameSolve, "Still not implemented, but parameters are saved in param.txt.");
              }
              catch(Exception ex) {
                JOptionPane.showMessageDialog(frameSolve, "Critical Error: Could not open param.txt. Terminating program.");
                System.exit(1);
              }
            
              // take in file with the solution
            
            
              // pass file to a class that will draw the solution in a new frame
            
             
            }
          });
          frameSolve.add(solverButton);
          solverButton.setBounds(0,513,782,40); 
        
          // Final frame adjustments
          frameSolve.setSize(800,600);        
          frameSolve.setVisible(true); 
        }
        catch (Exception ex) {
          JOptionPane.showMessageDialog(frame1, "Invalid input entered. Cancelled.");
        }
      }
    });
    
    // create (probably won't be implemented)
    JButton createButton = new JButton("Create");
    createButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(frame1, "Coming (no where near) soon!");
      }
    });
    
    // settings
    JButton settingsButton = new JButton("Settings");
    settingsButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // load settings from text file
        try {
          FileReader fin = new FileReader("config.txt");
          BufferedReader bin = new BufferedReader(fin);
          Scanner read = new Scanner(bin);
          
          String lStr = read.next();
          int l = Integer.parseInt(lStr);
          String hStr = read.next();
          int h = Integer.parseInt(hStr);
          String pStr = read.next();
          int p = Integer.parseInt(pStr);
          String c = read.next();
          
          nonogram.setLength(l);
          nonogram.setHeight(h);
          nonogram.setMaxParam(p);
          nonogram.setColor(c);
          
          read.close();
          bin.close();
          fin.close();
        }
        catch(Exception ex){
          JOptionPane.showMessageDialog(frame1, "Critcal Error: Could not open config.txt. Terminating program.");
          System.exit(1);
        }
        // variables for settings screen
        int l = nonogram.getLength();
        int h = nonogram.getHeight();
        int p = nonogram.getMaxParam();

        // create settings frame
        JFrame frameSettings = new JFrame("Settings");
        
        JTextField defaultGrid = new JTextField("The default grid size is " + l + " x " + h + ".");
        JTextField defaultPara = new JTextField("The default maximum number of parameters is " + p + ".");
        JTextField colSel = new JTextField("Current color: " + nonogram.getColor());

        // create settings buttons and extra text fields
        
        // change the default grid size upon enterning new menu
        JButton defaultGridButton = new JButton("Default Grid Size");
        defaultGridButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
            try {
              int le = Integer.parseInt(JOptionPane.showInputDialog("(1/2) Enter the default grid length:", ""));
              int he = Integer.parseInt(JOptionPane.showInputDialog("(2/2) Enter the default grid width:", ""));
              nonogram.setLength(le);
              nonogram.setHeight(he);
              JOptionPane.showMessageDialog(frameSettings, "The default grid size was updated.");
              defaultGrid.setText("The default grid size is " + le + " x " + he + ".");
            }
            catch (Exception e) {
              JOptionPane.showMessageDialog(frameSettings, "Invalid input entered. Cancelled.");
            }
          }
        });
        
        // change the default maximum parameters
        JButton paraButton = new JButton("Max # of Parameters");
        paraButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
            try {
              int pa = Integer.parseInt(JOptionPane.showInputDialog("Enter the default maximum of parameters:", ""));
              nonogram.setMaxParam(pa);
              JOptionPane.showMessageDialog(frameSettings, "The defaut maximum of parameters was updated.");
              defaultPara.setText("The default maximum number of parameters is " + pa + ".");
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
        
        // save settings and close settings menu
        JButton saveButton = new JButton("Save and Close");
        saveButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
            try {
              FileWriter fout = new FileWriter("config.txt", false);
              BufferedWriter outf = new BufferedWriter(fout);
              
              outf.write(Integer.toString(nonogram.getLength())); // writes length
              outf.write(" ");
              outf.write(Integer.toString(nonogram.getHeight())); // writes height
              outf.write(" ");
              outf.write(Integer.toString(nonogram.getMaxParam())); // writes parameter limit
              outf.write(" ");
              outf.write(nonogram.getColor()); // writes color
              outf.write(" ");
              
              outf.close();
              fout.close();
              
              JOptionPane.showMessageDialog(frameSettings, "Settings saved!");
              frameSettings.dispatchEvent(new WindowEvent(frameSettings, WindowEvent.WINDOW_CLOSING));
            }
            catch (Exception ex) {
              JOptionPane.showMessageDialog(frame1, "Critcal Error: Could not open config.txt. Terminating program.");
              System.exit(1);
            }
          }
        });
        
        // add buttons and fields, show settings frame
        frameSettings.setLayout(null); // absolute layout
        frameSettings.add(defaultGridButton); // default grid button
        defaultGridButton.setBounds(192,10,400,75); // x, y, l, w
        frameSettings.add(defaultGrid); // default grid text field
        defaultGrid.setBounds(192,85,400,25);
        
        frameSettings.add(paraButton);
        paraButton.setBounds(192,125,400,75);
        frameSettings.add(defaultPara);
        defaultPara.setBounds(192,200,400,25);
        
        frameSettings.add(colorButton); // custom color button
        colorButton.setBounds(192,240,400,75);
        frameSettings.add(colSel);
        colSel.setBounds(192,315,400,25);
        
        frameSettings.add(musicButton); // custom music button
        musicButton.setBounds(192,355,400,75);
        
        frameSettings.add(saveButton);
        saveButton.setBounds(192,470,400,75);
        
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
