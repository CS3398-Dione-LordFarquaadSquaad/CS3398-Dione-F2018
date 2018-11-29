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

/**
 *
 * @author Hunter
 */
public class Menu extends JPanel implements ActionListener{

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
                    width = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the width of the nanogram."));
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
    
    static boolean flip(boolean flipme){
        if (flipme)
            flipme = false;
        else if (!flipme)
            flipme = true; 
        
       return flipme; 
    }
}
