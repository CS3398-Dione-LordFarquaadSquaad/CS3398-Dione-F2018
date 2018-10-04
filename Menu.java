/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

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
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
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

/**
 *
 * @author Hunter
 */
public class Menu extends JPanel implements ActionListener{

    public void start(Stage stage, int x, int y) {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        int columns = 20, rows = 10 , horizontal = 20, vertical = 20;
        Rectangle rect = null;
        for(int i = 0; i < x; ++i)
        {//Iterate through columns
            for(int j = 0; j < y; ++j)
            {//Iterate through rows
//              Color choice = chooseColor(rectColors);
                //Method that chooses a color

                rect = new Rectangle(horizontal*j, vertical*i, horizontal, vertical);
                //Create a new rectangle(PosY,PosX,width,height)

                rect.setStroke(javafx.scene.paint.Color.RED);
                //Give rectangles an outline so I can see rectangles

                root.getChildren().add(rect);
                //Add Rectangle to board

            }
        }
        scene.setRoot(root);
        stage.show();

    }
    
    public static void main(String[] args) {
        
        
        
        
        //Rectangle rect = null;
       
        JFrame frame = new JFrame("Main Menu Test");
        frame.getContentPane().setBackground( Color.red );
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JButton CreateSelect = new JButton("Create Level");  
        JButton StageSelect = new JButton("Play a Level"); 
        JButton Options = new JButton("Options");
        
        CreateSelect.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
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
                      JOptionPane.showMessageDialog(frame, "Invalid price. "
                        + "The length cannot be smaller than 0.");
                      continue;
                    }
                    
                } catch (Exception e) 
                {
                  JOptionPane.showMessageDialog(frame,"Illegal input: Must input an integer.");
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
                      JOptionPane.showMessageDialog(frame, "Invalid price. "
                        + "The width cannot be smaller than 0.");
                      continue;
                    }
                    
                } catch (Exception e) 
                {
                  JOptionPane.showMessageDialog(frame,"Illegal input: Must input an integer.");
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
                      JOptionPane.showMessageDialog(frame, "Invalid price. "
                        + "The row markers cannot be smaller than 0.");
                      continue;
                    }
                    
                } catch (Exception e) 
                {
                  JOptionPane.showMessageDialog(frame,"Illegal input: Must input an integer.");
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
                      JOptionPane.showMessageDialog(frame, "Invalid price. "
                        + "The column markers cannot be smaller than 0.");
                      continue;
                    }
                    
                } catch (Exception e) 
                {
                  JOptionPane.showMessageDialog(frame,"Illegal input: Must input an integer.");
                  //logger.log(Level.SEVERE, e.getMessage(), e);
                  continue;
                }
                break;
              }
              
             for (int i = 0; i < length; i++){
                 for (int k = 0; k < width; k++){
                     Rectangles r = new Rectangles(i,k);
                     testGrid.add(r);
                 }
             }
              
            
             testGrid.setVisible(true); 
               }
                  
            }); 
        
        StageSelect.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JOptionPane.showMessageDialog(null, "You know how to click a button :]");
            }
        });
        
        Options.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JOptionPane.showMessageDialog(null, "You know how to click a button :]");
                
                JFrame Options = new JFrame(); 
                JButton ChangeMusic = new JButton("Change the music");
                JButton ChangeColor = new JButton("Change the colors");
                JButton ChangeAvatar = new JButton("Change the avatar");
                
                Options.setSize(600,200); 
                //Options.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                Options.setLayout(new GridLayout(0,1));
                Options.add(ChangeMusic);
                Options.add(ChangeColor);
                Options.add(ChangeAvatar);
                Options.setVisible(true); 
                
            }
        });
        
        frame.setLayout(new GridLayout(0,1)); 
        frame.setSize(500, 200);
        frame.add(CreateSelect); 
        frame.add(StageSelect);
        frame.add(Options);
        //frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
