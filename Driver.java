import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/************************************************************************************************************
* Program Header - 
* Name: Mehul Pillai
* Teacher: Mr. Cadawas
* Course: ISC4U1
* Date Of Completion: 11-29-2019
* Description: This program demonstrates a physics concept, specifically Newton's second law, using Java Swing
**************************************************************************************************************/

//This class starts the program
public class Driver {
    public static MainMenu menuScreen = new MainMenu();
    
    public static void main(String[]args) {
        //Instantiate the JFrame and set the panel to the MainMenu
        MainMenu.frame = new JFrame("Acceleration and Pulleys");
        Utility.changePanel(menuScreen.getMenuPanel());
    }
}
