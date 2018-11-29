package nonogram;

// ryan's imports
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.Hashtable;

import java.awt.*; // basic awt classes
import java.awt.geom.*;
import java.awt.event.*; // event classes (needed for ActionListener)
import javax.swing.*; // imports swing GUI libraries

// hunter's imports
//import javazoom.jl.player.Player;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javax.swing.*;
import javafx.stage.Stage;
//import Menu.Rectangle; 

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.Spring.height;
import javax.swing.WindowConstants;
import javafx.scene.shape.Rectangle;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.event.ChangeEvent;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;



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
    
    // first load of settings from config file
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
      String sStr = read.next();
      int s = Integer.parseInt(sStr);
          
      nonogram.setLength(l);
      nonogram.setHeight(h);
      nonogram.setMaxParam(p);
      nonogram.setColor(c);
      nonogram.setElemSize(s);
          
      read.close();
      bin.close();
      fin.close();
    }
    catch(Exception ex){
      System.out.println("config.txt not found. loading default settings.");
    }
    
    // create main frame
    JFrame frame1 = new JFrame("Ye Olde Nonogram Nannick");
    frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    ButtonListener listen = new ButtonListener();
    //JTextField text = new JTextField("");
    
    // solve
    JButton solveButton = new JButton("Solve");
    solveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        //JOptionPane.showMessageDialog(frame1, "Not fully implemented, so enjoy this grid.");
        
        JFrame frameSolve = new JFrame("Solve");
        //frameSolve.setLayout(null);
        
        // First, gather the basic nonogram data
        DrawNonogram grid = new DrawNonogram();
        try {
          int l = Integer.parseInt(JOptionPane.showInputDialog("(1/3) Enter the grid length:", nonogram.getLength()));
          int h = Integer.parseInt(JOptionPane.showInputDialog("(2/3) Enter the grid width:", nonogram.getHeight()));
          int p = Integer.parseInt(JOptionPane.showInputDialog("(3/3) Enter the maximum number of parameters:", nonogram.getMaxParam()));
          int s = nonogram.getElemSize();
        
          // Next, draw the grid
          grid.length = l;
          grid.height = h;
          grid.maxParam = p;
          grid.color = nonogram.getColor();
          grid.elemSize = nonogram.getElemSize();
          frameSolve.add(grid);
          grid.setBounds(0,0,1000,1000);
        
          frameSolve.setLayout(null);
        
          // Next, draw the text boxes
          JTextField[][] tpFields = new JTextField[l][p];
          JTextField[][] spFields = new JTextField[h][p];
        
          // x and y pos trackers
          int x = 120;
          int y = 95;
        
          for(int i = 0; i < l; i++){
            y = 95;
            for(int j = p-1; j >= 0; j--){
              tpFields[i][j] = new JTextField("0");
              frameSolve.add(tpFields[i][j]);
              tpFields[i][j].setBounds(x,y,s,s);
              y -= s;
            }
            x += s;
          }
        
          x = 95;
          y = 120;
        
          for(int i = 0; i < h; i++){
            x = 95;
            for(int j = p-1; j >= 0; j--){
              spFields[i][j] = new JTextField("0");
              frameSolve.add(spFields[i][j]);
              spFields[i][j].setBounds(x,y,s,s);
              x -= s;
            } 
            y += s;
          }
         
          // Next, make a solve button
          JButton solverButton = new JButton("Enter the parameters above, and then click here for the solution!");
          solverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {   
              // print the parameters to a file and send to solveAlg
              try {
                JFrame frameSol = new JFrame();
                
                FileWriter fout = new FileWriter("specs.txt", false); // true = add to file, false = rewrite file
                BufferedWriter outf = new BufferedWriter(fout);
                
                // dimensions
                outf.write(Integer.toString(h)); // height (numRows)
                outf.newLine();
                outf.write(Integer.toString(l)); // length (numCols)
                outf.newLine();
                outf.write(Integer.toString(p)); // maxParam (numRowMarkers)
                outf.newLine();
                outf.write(Integer.toString(p)); // maxParam (numColMarkers)
                outf.newLine(); outf.newLine(); // new lines for parameters below
                                
                // parameters
                for(int i = 0; i < l; i++) {
                  for(int j = 0; j < p; j++) {
                    /*if(j == p-1)
                      outf.write(tpFields[i][j].getText() + ", ");
                    else*/
                      outf.write(tpFields[i][j].getText() + " ");         
                  }
                }
                
                outf.newLine();
                
                for(int i = 0; i < h; i++) {
                  for(int j = 0; j < p; j++) {
                    /*if(j == p-1)
                      outf.write(spFields[i][j].getText() + ", ");
                    else*/
                      outf.write(spFields[i][j].getText() + " ");
                  }
                }
              
                outf.close();
                fout.close();
              
                // <TODO> Call solving algorithm
                
                DrawSolution sol = new DrawSolution();
                sol.length = l;
                sol.height = h;
                sol.maxParam = p;
                sol.color = nonogram.getColor();
                sol.elemSize = s;
                
                frameSol.add(sol);
                sol.setBounds(0,0,1000,1000);
                
                frameSol.setLayout(null);
                
                frameSol.setSize(1024,900);
                frameSol.setVisible(true);
              }
              catch(Exception ex) {
                System.out.println("specs.txt not found");
              }
            
              // take in file with the solution
            
            
              // pass file to a class that will draw the solution in a new frame
            
             
            }
          });
          
          // help button
          JButton solveHelpButton = new JButton("Help");
          solveHelpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
              JOptionPane.showMessageDialog(frameSolve, "(1/3) Enter the markers into the text fields above and click the solve button to get the solution.");
              JOptionPane.showMessageDialog(frameSolve, "(2/3) The fastest method to enter the markers is to double click a marker and then type the number.");
              JOptionPane.showMessageDialog(frameSolve, "(3/3) If there is a viable solution, you will be brought to a new screen with the soltuion.");
            }
          });
          
          frameSolve.add(solverButton);
          solverButton.setBounds(0,813,806,40); 
          frameSolve.add(solveHelpButton);
          solveHelpButton.setBounds(811,813,195,40);
          // Final frame adjustments
          frameSolve.setSize(1024,900);        
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
        int length; 
                int width;
                int columnmarker;
                int rowmarker;
                JFrame testGrid = new JFrame();
                
                while(true) 
                {
                  try 
                  {
                    length = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the length of the nanogram:"));
                    if (length <= 0) 
                    {
                      JOptionPane.showMessageDialog(frame1, "Invalid price. "
                        + "The length cannot be smaller than 0.");
                      continue;
                    }
                    
                } catch (Exception e) 
                {
                  JOptionPane.showMessageDialog(frame1,"Illegal input: Must input an integer.");
                  //logger.log(Level.SEVERE, e.getMessage(), e);
                  continue;
                }
                break;
              }
                
                while(true) 
                {
                  try 
                  {
                    width = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the width of the nanogram."));
                    if (width <= 0) 
                    {
                      JOptionPane.showMessageDialog(frame1, "Invalid price. "
                        + "The width cannot be smaller than 0.");
                      continue;
                    }
                    
                } catch (Exception e) 
                {
                  JOptionPane.showMessageDialog(frame1,"Illegal input: Must input an integer.");
                  //logger.log(Level.SEVERE, e.getMessage(), e);
                  continue;
                }
                break;
              }
                
              while(true) 
                {
                  try 
                  {
                    columnmarker = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the column markers of the nanogram."));
                    if (columnmarker <= 0) 
                    {
                      JOptionPane.showMessageDialog(frame1, "Invalid price. "
                        + "The row markers cannot be smaller than 0.");
                      continue;
                    }
                    
                } catch (Exception e) 
                {
                  JOptionPane.showMessageDialog(frame1,"Illegal input: Must input an integer.");
                  //logger.log(Level.SEVERE, e.getMessage(), e);
                  continue;
                }
                break;
              }
              
              while(true) 
                {
                  try 
                  {
                    rowmarker = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the row markers of the nanogram."));
                    if (columnmarker <= 0) 
                    {
                      JOptionPane.showMessageDialog(frame1, "Invalid price. "
                        + "The column markers cannot be smaller than 0.");
                      continue;
                    }
                    
                } catch (Exception e) 
                {
                  JOptionPane.showMessageDialog(frame1,"Illegal input: Must input an integer.");
                  //logger.log(Level.SEVERE, e.getMessage(), e);
                  continue;
                }
                break;
              }
              
               
              int wi = width; 
              int le = length;
              
              //testGrid.getContentPane().add(new Menu());
              testGrid.setBounds(30,30,800,800); 
              //graph2D.drawRect(170, y, 20, 50); 
              testGrid.setVisible(true); 
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
          String sStr = read.next();
          int s = Integer.parseInt(sStr);
          
          nonogram.setLength(l);
          nonogram.setHeight(h);
          nonogram.setMaxParam(p);
          nonogram.setColor(c);
          nonogram.setElemSize(s);
          
          read.close();
          bin.close();
          fin.close();
        }
        catch(Exception ex){
          JOptionPane.showMessageDialog(frame1, "Could not find config.txt. A new file will be written upon saving.");
        }
        // variables for settings screen
        int l = nonogram.getLength();
        int h = nonogram.getHeight();
        int p = nonogram.getMaxParam();
        int s = nonogram.getElemSize();

        // create settings frame
        JFrame frameSettings = new JFrame("Settings");
        
        JTextField defaultGrid = new JTextField("The default grid size is " + l + " x " + h + ".");
        JTextField defaultPara = new JTextField("The default maximum number of parameters is " + p + ".");
        JTextField colSel = new JTextField("Current color: " + nonogram.getColor());
        JTextField sizeField = new JTextField("The current zoom level is " + s + ".");

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
            
            // JLabel for instruction       
            JLabel instr = new JLabel("Pick a color:");
            
            // drop down menu for selection from one of many colors
            JComboBox color = new JComboBox(colors);
            color.setSelectedIndex(0);
            color.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent event) {
                String colorSelect = (String)color.getSelectedItem();
                nonogram.setColor(colorSelect);
                colSel.setText("Current color: " + nonogram.getColor());
              }
            });
            
            // close window button
            JButton colCloseButton = new JButton("Return to Settings");
            colCloseButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent event) {
                frameColor.dispose();
              }
            });
            
            // add elements, draw frame
            frameColor.setLayout(null);
            frameColor.add(instr);
            instr.setBounds(470,360,200,25);
            frameColor.add(color);
            color.setBounds(432,390,150,25);
            frameColor.add(colCloseButton);
            colCloseButton.setBounds(432,420,150,50);
            
            frameColor.setSize(1024,900);
            frameColor.setVisible(true);
          }
        });
        
        // resize solve menu elements (range: 20 - 30)
        JButton resizeButton = new JButton("Grid/Text Field Size");
        resizeButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
            JFrame frameResize = new JFrame();
            // label with quick instructions
            JLabel inst = new JLabel("Select your preferred size:");
            
            // create a slider that lets the user select between size 20 - 30
            JSlider sizeSlide = new JSlider(20, 30);
            
            // slider ticks
            sizeSlide.setMajorTickSpacing(5);
            sizeSlide.setMinorTickSpacing(1);
            sizeSlide.setPaintTicks(true);
            
            // slider labels
            sizeSlide.setPaintLabels(true);
            Hashtable pos = new Hashtable();
            pos.put(20, new JLabel("20"));
            pos.put(25, new JLabel("25"));
            pos.put(30, new JLabel("30"));
            sizeSlide.setLabelTable(pos);
            
            // close window button
            JButton resCloseButton = new JButton("Return to Settings");
            resCloseButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent event) {
                nonogram.setElemSize(sizeSlide.getValue());
                sizeField.setText("The current zoom level is: " + nonogram.getElemSize() + ".");
                frameResize.dispose();
              }
            });
            
            // add elements, set up frame
            frameResize.setLayout(null);
            frameResize.add(inst);
            inst.setBounds(430,360,200,25);
            frameResize.add(sizeSlide);
            sizeSlide.setBounds(350,390,300,100);
            frameResize.add(resCloseButton);
            resCloseButton.setBounds(430,490,150,50);
            
            frameResize.setSize(1024,900);
            frameResize.setVisible(true);
          }
        });

        // help button
        JButton settingsHelpButton = new JButton("Help");
        settingsHelpButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(frameSettings, "(1/5) Change the length and width of the blank grid when entering a menu using Default Grid Size.");
            JOptionPane.showMessageDialog(frameSettings, "(2/5) Depending on how many markers there are per row, you can change the amount\navailable using Max # of Parameters.");
            JOptionPane.showMessageDialog(frameSettings, "(3/5) Try some different colors using Colors!");
            JOptionPane.showMessageDialog(frameSettings, "(4/5) You can change the size of the grid and text fields with Grid/Text Field Size\nto make them easier to see, or to fit more on the screen at once. ");
            JOptionPane.showMessageDialog(frameSettings, "(5/5) When done adjusting settings, choose Save and Close to go back to the main menu.");
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
              outf.write(Integer.toString(nonogram.getElemSize())); // writes size
              outf.write(" ");
              
              outf.close();
              fout.close();
              
              JOptionPane.showMessageDialog(frameSettings, "Settings saved!\nReturning to Main Menu");
              frameSettings.dispatchEvent(new WindowEvent(frameSettings, WindowEvent.WINDOW_CLOSING));
            }
            catch (Exception ex) {
              JOptionPane.showMessageDialog(frame1, "Could not find config.txt. A new file will be written upon saving.");
            }
          }
        });
        
        // add buttons and fields, show settings frame
        frameSettings.setLayout(null); // absolute layout
        frameSettings.add(defaultGridButton); // default grid button
        defaultGridButton.setBounds(58,10,400,75); // x, y, l, w
        frameSettings.add(defaultGrid); // default grid text field
        defaultGrid.setBounds(58,85,400,25);
        
        frameSettings.add(paraButton); // parameter max button
        paraButton.setBounds(547,10,400,75);
        frameSettings.add(defaultPara);
        defaultPara.setBounds(547,85,400,25);
        
        frameSettings.add(colorButton); // custom color button
        colorButton.setBounds(58,140,400,75);
        frameSettings.add(colSel);
        colSel.setBounds(58,215,400,25);
        
        frameSettings.add(resizeButton); // resize button
        resizeButton.setBounds(547,140,400,75);
        frameSettings.add(sizeField);
        sizeField.setBounds(547,215,400,25);
        
        frameSettings.add(saveButton);
        saveButton.setBounds(302,770,400,75);
        
        frameSettings.add(settingsHelpButton);
        settingsHelpButton.setBounds(923,770,75,75);
        
        frameSettings.setSize(1024, 900);
        frameSettings.setVisible(true);
      }
    });
    
    // help
    JButton helpButton = new JButton("Help");
    helpButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event){
        JOptionPane.showMessageDialog(frame1, "(1/4) Welcome to Ye Olde Nonogram Nannick, where you can get solutions or create your own nonograms!");
        JOptionPane.showMessageDialog(frame1, "(2/4) In Solve, you can input the markers of a nonogram and then Ye Olde Nonogram Nannick will solve it for you.");
        JOptionPane.showMessageDialog(frame1, "(3/4) In Create, you can create your own nonograms! Ye Olde Nonogram Nannick will print the markers when you are finished. (Assuming it can be completed, of course!)");
        JOptionPane.showMessageDialog(frame1, "(4/4) Don't forget to click settings to personalize the application and make it more to your suiting. Keep an eye out for the help button on the other screens, too!");
      }
    });
    
    // draw the main frame 
    frame1.setLayout(null); // absolute layout for complete control
    frame1.add(solveButton);
    solveButton.setBounds(5,200,490,453); // x pos, y pos, length, width
    frame1.add(createButton);
    createButton.setBounds(505,200,497,453);
    frame1.add(settingsButton);
    settingsButton.setBounds(5,658,770,190);
    frame1.add(helpButton);
    helpButton.setBounds(781,658,221,190);
    
    frame1.setSize(1024, 900); // intention: make the webapp 1024x900
                              // makes it visible on most monitors
    frame1.setVisible(true); // makes frame1 visible on startup
  } 
}
