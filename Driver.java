import java.awt.*;
import javax.swing.*;

public class Driver {
    public static final int intPanelWidth = 960, intPanelHeight = 540;
    public static MainMenu menuScreen = new MainMenu();

    public static void changePanel(JPanel panel) {
        MainMenu.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenu.frame.setResizable(false);
        MainMenu.frame.setContentPane(panel);
        MainMenu.frame.pack();
        MainMenu.frame.setVisible(true);
    }
    
    public static void main(String[]args) {
        MainMenu.frame = new JFrame("ACCELERATION");
        MainMenu.frame.setResizable(false);
        MainMenu.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenu.frame.setContentPane(menuScreen.getMenuPanel());
        MainMenu.frame.pack();
        MainMenu.frame.setVisible(true);
    }
}
