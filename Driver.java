import java.awt.*;
import javax.swing.*;
import java.io.File;

public class Driver {
    public static final int intPanelWidth = 960, intPanelHeight = 540;
    public static MainMenu menuScreen = new MainMenu();
    public static Font getFont() {
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("google_regular.ttf"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return font;
    }

    public static void changePanel(JPanel panel) {
        MainMenu.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenu.frame.setResizable(false);
        MainMenu.frame.setContentPane(panel);
        MainMenu.frame.pack();
        MainMenu.frame.setVisible(true);
    }
    
    public static void main(String[]args) {
        MainMenu.frame = new JFrame("ACCELERATION");
        changePanel(menuScreen.getMenuPanel());
    }
}
