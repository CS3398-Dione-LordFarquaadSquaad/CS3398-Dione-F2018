/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.Arrays;
import javafx.scene.layout.Border;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import static menu.Menu.Checker;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


// ryan's imports
import java.io.FileWriter;
import java.io.BufferedWriter;


/**
 *
 * @author Hunter n the boi Ryan
 */
public class Menu extends JPanel implements ActionListener{

  public static Nonogram nonogram;
  
  public Menu() throws IOException {
    nonogram = new Nonogram();
  }
  
    static int le;
    static int wi; 
    
    static boolean iSelected = false;
    static BufferedImage img;  
    static BufferedImage img2;
    static AudioStream MenuHolder;
    static final boolean[][] Checker = new boolean[100][100]; 
    static final int[][] LMarkerSetter = new int[100][100]; 
    static final int[][] WMarkerSetter = new int[100][100]; 
    static final int[][] LFinalizer = new int[50][50];
    static final int[][] WFinalizer = new int[50][50];
    static int countMarker = 0;
    //Arrays.fill(Checker, Boolean.FALSE);

    public static void main(String[] args) throws IOException, URISyntaxException, UnsupportedAudioFileException, LineUnavailableException {
        
      /*
        File file = new File("C://Users//Ryan//Desktop//ASS//JavaApplication7//src//menu/moses.png"); 
        File file2 = new File("C://Users//Ryan//Desktop//ASS//JavaApplication7//src//menu/lamp.jpg");
        File file3 = new File("C://Users//Ryan//Desktop//ASS//JavaApplication7//src//menu/spookd.jpg");
        File file4 = new File("C://Users//Ryan//Desktop//ASS//JavaApplication7//src//menu/smokee.jpg");
        File file5 = new File("C://Users//Ryan//Desktop//ASS//JavaApplication7//src//menu/jesus.jpg");
        File file6 = new File("C://Users//Ryan//Desktop//ASS//JavaApplication7//src//menu/aww.jpg");
        
        FileInputStream fis = new FileInputStream(file);  
        FileInputStream fis2 = new FileInputStream(file2); 
        FileInputStream fis3 = new FileInputStream(file3); 
        FileInputStream fis4 = new FileInputStream(file4);  
        FileInputStream fis5 = new FileInputStream(file5); 
        FileInputStream fis6 = new FileInputStream(file6); 
        
        BufferedImage image = ImageIO.read(fis); 
        BufferedImage image2 = ImageIO.read(fis2); 
        BufferedImage image3 = ImageIO.read(fis3);
        BufferedImage image4 = ImageIO.read(fis4); 
        BufferedImage image5 = ImageIO.read(fis5); 
        BufferedImage image6 = ImageIO.read(fis6);
        
        img = image;
        img2 = image2;
        String filepath;
        */  
      
        AudioPlayer MGP = AudioPlayer.player;
        
        final AudioStream Menu1, Menu2, Menu3, Menu4, Menu5;
        
        Menu1 = new AudioStream(new FileInputStream("E://Documents//GitHub//CS3398-Dione-F2018//JavaApplication7//src//menu/melee.wav"));//enter the sound directory and name here
        Menu2 = new AudioStream(new FileInputStream("E://Documents//GitHub//CS3398-Dione-F2018//JavaApplication7//src//menu/meee.wav"));
        Menu3 = new AudioStream(new FileInputStream("E://Documents//GitHub//CS3398-Dione-F2018//JavaApplication7//src//menu/melee.wav"));
        
        MenuHolder = Menu1;
        AudioPlayer.player.start(MenuHolder);
        
        JFrame frame = new JFrame("Ye Olde Nonogram Nannick");
        frame.getContentPane().setBackground( Color.red );
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton CreateSelect = new JButton("Create");  
        JButton StageSelect = new JButton("Solve"); 
        JButton Options = new JButton("Options");
        
        CreateSelect.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                int length; 
                int width;
                int columnmarker;
                int rowmarker;
                JFrame testGrid = new JFrame("Create");
                
                while(true) 
                {
                  try 
                  {
                    length = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the length of the nonogram:"));
                    if (length <= 0) 
                    {
                      JOptionPane.showMessageDialog(frame, "Invalid length. "
                        + "The length cannot be smaller than 0.");
                      continue;
                    }
                    
                } catch (Exception e) 
                {
                  JOptionPane.showMessageDialog(frame,"Illegal input: Must input an integer.");
                  continue;
                }
                break;
              }
                
                while(true) 
                {
                  try 
                  {
                    width = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the width of the nonogram:"));
                    if (width <= 0) 
                    {
                      JOptionPane.showMessageDialog(frame, "Invalid width. "
                        + "The width cannot be smaller than 0.");
                      continue;
                    }
                    
                } catch (Exception e) 
                {
                  JOptionPane.showMessageDialog(frame,"Illegal input: Must input an integer.");
                  continue;
                }
                break;
              }
                
              while(true) 
                {
                  try 
                  {
                    columnmarker = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the max number of markers per column:"));
                    if (columnmarker <= 0) 
                    {
                      JOptionPane.showMessageDialog(frame, "Invalid maximum. "
                        + "The row markers cannot be smaller than 0.");
                      continue;
                    }
                    
                } catch (Exception e) 
                {
                  JOptionPane.showMessageDialog(frame,"Illegal input: Must input an integer.");
                  continue;
                }
                break;
              }
              
              while(true) 
                {
                  try 
                  {
                    rowmarker = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the max number of markers per row:"));
                    if (columnmarker <= 0) 
                    {
                      JOptionPane.showMessageDialog(frame, "Invalid maximum. "
                        + "The column markers cannot be smaller than 0.");
                      continue;
                    }
                    
                } catch (Exception e) 
                {
                  JOptionPane.showMessageDialog(frame,"Illegal input: Must input an integer.");
                  continue;
                }
                break;
              }
              
              wi = width; 
              le = length;
              
                
                //Arrays.fill(Checker, Boolean.FALSE);
              for (int i=0;i<length;i++){
                for (int k = 0; k < width; k++){
                    final int ii = i;
                    final int kk = k; 
                    JButton temp = new JButton("Test"); 
                    temp.setForeground(Color.black);
                    temp.setBackground(Color.blue);
                    javax.swing.border.Border border = BorderFactory.createLineBorder(Color.RED, 1);
                    temp.setBorder(border);
                    temp.setOpaque(true);
                    temp.setSize(70, 70);
                    temp.setLocation(50 + 70*i, 50 + 70*k);
                    
                    temp.addMouseListener(new MouseAdapter(){
                       public void mouseClicked(MouseEvent e){
                           
                           boolean tweak = true;
                           Checker[ii][kk] = flip(Checker[ii][kk]);
                           
                           if (Checker[ii][kk])
                               temp.setBackground(Color.green);
                           else if (!Checker[ii][kk])
                            temp.setBackground(Color.red);
                            
                            
                       }
                   });
                    
                    
                    testGrid.add(temp);
            }
              }      
                //testGrid.getContentPane().add(new Menu());
              //testGrid.add(setter);
              testGrid.setLayout(null); 
              testGrid.setBounds(30,30,500,500); 
              JButton finish = new JButton("Finalize");
              finish.setOpaque(true);
              finish.setLocation(25 + le*70, 55 + wi*70);
              finish.setSize(150, 30);
              testGrid.add(finish); 
              testGrid.setVisible(true); 
               
            finish.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    
                    int LMarker = 0;
                    int WMarker = 0;
                    
                    for (int l = 0; l < le; l++){
                        for (int w = 0; w < wi; w++){
                            if (Checker[l][w] == true && w != wi-1)
                            {
                                countMarker++;
                                //System.out.println(countMarker); 
                            }
                            else if (Checker[l][w] == true && w == wi-1)
                                {
                                    countMarker++; 
                                    //System.out.println(countMarker);
                                    WMarkerSetter[l][WMarker] = countMarker; 
                                    countMarker = 0;
                                    WMarker++;
                                }
                                else{
                                    WMarkerSetter[l][WMarker] = countMarker; 
                                    countMarker = 0;
                                    WMarker++;
                                }
                        
                    }      
                }
                    
                    for (int w = 0; w < wi; w++){
                        for (int l = 0; l < le; l++){
                            if (Checker[l][w] == true && l != le-1)
                            {
                                countMarker++;
                                //System.out.println(countMarker); 
                            }
                            else if (Checker[l][w] == true && l == le-1)
                                {
                                    countMarker++; 
                                    //System.out.println(countMarker);
                                    LMarkerSetter[LMarker][w] = countMarker; 
                                    countMarker = 0;
                                    LMarker++;
                                }
                                else{
                                    LMarkerSetter[LMarker][w] = countMarker; 
                                    countMarker = 0;
                                    LMarker++;
                                }
                        
                    }      
                }
                    
                    WMarker = 0; 
                    
                    for (int l = 0; l < le; l++){
                        for (int w = 0; w < wi; w++){
                            //WMarker = w%2 + w/2; 
                            //System.out.println(WMarker);
                            //System.out.println(WMarkerSetter[l][w]);
                            if (WMarkerSetter[l][w] != 0){
                                WFinalizer[l][w] = WMarkerSetter[l][w];
                            }
                        }
                    }
                    
                    for (int w = 0; w < wi; w++){
                        for (int l = 0; l < le; l++){
                            LMarker = l%2 + l/2; 
                            //System.out.println(WMarker);
                            //System.out.println(WMarkerSetter[l][w]);
                            if (LMarkerSetter[l][w] != 0){
                                LFinalizer[LMarker][w] = LMarkerSetter[l][w];
                            }
                        }
                }
                    
                    
                    for (int l = 0; l < le/2 + le%2 + 1; l++){
                        for (int w = 0; w < wi/2 + wi%2 + 1; w++){
                            if (LMarkerSetter[l][w] !=0)
                            {
                                System.out.println("Length " + l); 
                                System.out.println("Marker: " + LMarkerSetter[l][w]);
                            }
                            
                            if (WMarkerSetter[l][w] !=0)
                            {
                                System.out.println("Width " + w); 
                                System.out.println("Marker: " + WMarkerSetter[l][w]);
                            }
                                
                            //System.out.println(LFinalizer[l][w]);
                        }
                    }
                     for (int l = 0; l < le; l++){
                        for (int w = 0; w < wi; w++){
                            Checker[l][w] = false;
                        }
                     }
             }
                     
            }); 
              
            }
 });         
        // solve
        StageSelect.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                //JOptionPane.showMessageDialog(null, "You know how to click a button :]");
        //JOptionPane.showMessageDialog(frame, "Not fully implemented, so enjoy this grid.");
        
        JFrame frameSolve = new JFrame("Solve");
        //frameSolve.setLayout(null);
        
        // First, gather the basic nonogram data
        DrawNonogram grid = new DrawNonogram();
        try {
          int l = Integer.parseInt(JOptionPane.showInputDialog("(1/3) Enter the nonogram length:")); // ex
          int h = Integer.parseInt(JOptionPane.showInputDialog("(2/3) Enter the nonogram height:")); // ex
          int p = Integer.parseInt(JOptionPane.showInputDialog("(3/3) Enter the maximum number of parameters\n(rows and columns):")); // ex
          int s = 25;
        
          // Next, draw the grid
          grid.length = l;
          grid.height = h;
          grid.maxParam = p;
          grid.color = "Black"; // ex
          grid.elemSize = s; // ex
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
                JFrame frameSol = new JFrame("Solution (click X to go back)");
                
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
                //Algo.draw();
                
                DrawSolution sol = new DrawSolution();
                sol.length = l;
                sol.height = h;
                sol.maxParam = p;
                sol.color = "Black"; // ex
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
          JOptionPane.showMessageDialog(frame, "Invalid input entered. Cancelled.");
        }              
            }
        });
        
        Options.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                //JOptionPane.showMessageDialog(null, "You know how to click a button :]");
                
                JFrame Options = new JFrame("Options"); 
                JButton ChangeMusic = new JButton("Change the music");
                JButton ChangeColor = new JButton("Change the colors");
                //JButton ChangeAvatar = new JButton("Change the avatar");
                
                Options.setSize(600,200); 
                Options.setLayout(new GridLayout(0,1));
                Options.add(ChangeMusic);
                Options.add(ChangeColor);
                //Options.add(ChangeAvatar);
                Options.setVisible(true); 
                
                ChangeMusic.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                        JFrame music = new JFrame("Change the music"); 
                        music.setSize(400, 200);
                        String musicCombo[] = { "Menu1", "Menu2", "Menu3"};
                        music.setLayout(new FlowLayout());
                        JLabel select = new JLabel("Select the music");
                        
                        JComboBox gg = new JComboBox(musicCombo);
                        
                        gg.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent event){
                                if (gg.getSelectedItem().toString().equals("Menu1")){
                                    AudioPlayer.player.stop(MenuHolder);
                                    MenuHolder = Menu1; 
                                    AudioPlayer.player.start(MenuHolder);
                                }
                                if (gg.getSelectedItem().toString().equals("Menu2")){
                                    AudioPlayer.player.stop(MenuHolder);
                                    MenuHolder = Menu2; 
                                    AudioPlayer.player.start(MenuHolder);
                                }
                                if (gg.getSelectedItem().toString().equals("Menu3")){
                                    AudioPlayer.player.stop(MenuHolder);
                                    MenuHolder = Menu3; 
                                    AudioPlayer.player.start(MenuHolder);
                                }
                            }
                        });
                        
                        music.add(select);
                        music.add(gg); 
                        music.setVisible(true); 
                }
            });
                /*
                ChangeAvatar.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        JFrame avatar = new JFrame();
                        avatar.setSize(400, 200);
                        JLabel imageLabel = new JLabel(new ImageIcon(image));
                        JLabel imageLabel2 = new JLabel(new ImageIcon(image2));
                        JLabel imageLabel3 = new JLabel(new ImageIcon(image3));
                        JLabel imageLabel4 = new JLabel(new ImageIcon(image4));
                        JLabel imageLabel5 = new JLabel(new ImageIcon(image5));
                        JLabel imageLabel6 = new JLabel(new ImageIcon(image6));
                        JLabel select = new JLabel("Select icon 1");
                        
                        avatar.setLayout(new FlowLayout());  
                        
                        String comboBoxItems[] = { "Butters", "Lamp", "Smoke", "Jesus", "Cat", "Surprise"};
                        JLabel l1 = new JLabel("Select texture #1: ");
                        JLabel l2 = new JLabel("Select texture #2: ");
                        
                        JComboBox gg = new JComboBox(comboBoxItems);
                        gg.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                if (gg.getSelectedItem().toString().equals("Butters"))
                                    img = image; 
                                if (gg.getSelectedItem().toString().equals("Lamp"))
                                    img = image2; 
                                if (gg.getSelectedItem().toString().equals("Cat"))
                                    img = image6; 
                                if (gg.getSelectedItem().toString().equals("Smoke"))
                                    img = image4; 
                                if (gg.getSelectedItem().toString().equals("Jesus"))
                                    img = image5; 
                                if (gg.getSelectedItem().toString().equals("Surprise"))
                                    img = image3; 
                            }
                        });
                        
                        
                        JComboBox gg2 = new JComboBox(comboBoxItems);
                        
                        gg2.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                if (gg2.getSelectedItem().toString().equals("Butters"))
                                    img2 = image; 
                                if (gg2.getSelectedItem().toString().equals("Lamp"))
                                    img2 = image2; 
                                if (gg2.getSelectedItem().toString().equals("Cat"))
                                    img2 = image6; 
                                if (gg2.getSelectedItem().toString().equals("Smoke"))
                                    img2 = image4; 
                                if (gg2.getSelectedItem().toString().equals("Jesus"))
                                    img2 = image5; 
                                if (gg2.getSelectedItem().toString().equals("Surprise"))
                                    img2 = image3; 
                            }
                        });
                        
                        avatar.add(l1);
                        avatar.add(gg); 
                        avatar.add(l2);
                        avatar.add(gg2); 
                         
                        avatar.setVisible(true);
                        
                        
                        

                    }
                });
                */
            }
        });
        
        frame.setLayout(new GridLayout(0,1)); 
        frame.setSize(500, 200);         
        frame.add(StageSelect);
        frame.add(CreateSelect);
        frame.add(Options);
        //frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    static boolean flip(boolean flipme){
        if (flipme)
            flipme = false;
        else if (!flipme)
            flipme = true; 
        
       return flipme; 
    }
}
