/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

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


/**
 *
 * @author Hunter
 */
public class Menu extends JPanel implements ActionListener{

    static int le;
    static int wi; 
    
    static BufferedImage img;  
    static BufferedImage img2;
    static AudioStream MenuHolder;
    
    //ImageIO.read(getClass().getResource("spookd.jpg"));
    
    
    public void paint(Graphics graph2D) {
    for (int i=0; i<le; i++) 
        for (int k = 0; k < wi; k++){
        int height = 80;
        if ((i%2==0 && k%2==0) || (i%2==1 && k%2==1)) {
            graph2D.drawImage(img, 80 + k*height, 80 + i*height, 80, 80, null); 
        } else {
            graph2D.drawImage(img2, 80 + k*height, 80 + i*height, 80, 80, null);
        }
        
    }
}
    
    public static void main(String[] args) throws IOException, URISyntaxException, UnsupportedAudioFileException, LineUnavailableException {
        
        File file = new File("C://Users//Hunter//Desktop//Menu//src//menu/moses.png"); 
        File file2 = new File("C://Users//Hunter//Desktop//Menu//src//menu/lamp.jpg");
        File file3 = new File("C://Users//Hunter//Desktop//Menu//src//menu/spookd.jpg");
        File file4 = new File("C://Users//Hunter//Desktop//Menu//src//menu/smokee.jpg");
        File file5 = new File("C://Users//Hunter//Desktop//Menu//src//menu/jesus.jpg");
        File file6 = new File("C://Users//Hunter//Desktop//Menu//src//menu/aww.jpg");
        
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
        
        AudioPlayer MGP = AudioPlayer.player;
        
        final AudioStream Menu1, Menu2, Menu3, Menu4, Menu5;
        //AudioData MD;
        //ContinuousAudioDataStream loop=true;
        Menu1 = new AudioStream(new FileInputStream("C://Users//Hunter//Desktop//Menu//src//menu/melee.wav"));//enter the sound directory and name here
        Menu2 = new AudioStream(new FileInputStream("C://Users//Hunter//Desktop//Menu//src//menu/meee.wav"));
        Menu3 = new AudioStream(new FileInputStream("C://Users//Hunter//Desktop//Menu//src//menu/flat.wav"));
        
        MenuHolder = Menu1;
        AudioPlayer.player.start(MenuHolder);
        
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
              
               
              wi = width; 
              le = length;
              
              testGrid.getContentPane().add(new Menu());
              testGrid.setBounds(30,30,800,800); 
              //graph2D.drawRect(170, y, 20, 50); 
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
                
                ChangeMusic.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                        JFrame music = new JFrame(); 
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
                        //JScrollPane scrollPane = new JScrollPane();
                        avatar.setLayout(new FlowLayout());  
                        //ImageIcon imageI = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                        //ImageIcon imageI2 = new ImageIcon(new ImageIcon(image2).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                        //ImageIcon imageI3 = new ImageIcon(new ImageIcon(image3).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                        //ImageIcon imageI4 = new ImageIcon(new ImageIcon(image4).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                        //ImageIcon imageI5 = new ImageIcon(new ImageIcon(image5).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                        //ImageIcon imageI6 = new ImageIcon(new ImageIcon(image6).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                        
                        //JLabel I1 = new JLabel(imageI);
                        //JLabel I2 = new JLabel(imageI2);
                        //JLabel I3 = new JLabel(imageI3);
                        //JLabel I4 = new JLabel(imageI4);
                        //JLabel I5 = new JLabel(imageI5);
                        //JLabel I6 = new JLabel(imageI6);
                        
                        //avatar.add(I1);
                        //avatar.add(I2);
                        //avatar.add(I3);
                        //avatar.add(I4);
                        //avatar.add(I5);
                        //avatar.add(I6);
                        //avatar.add(select);
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
