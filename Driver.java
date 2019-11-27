import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

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

    public static BufferedImage loadImage(String strImage) {
        try {
            BufferedImage image = ImageIO.read(new File(strImage));
            return image;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PrintWriter getWriter(String strFile) {
        try {
            return new PrintWriter(new FileWriter(strFile));
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static BufferedReader getReader(String strFile) {
        try {
            return new BufferedReader(new FileReader(strFile));
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String readLine(BufferedReader reader) {
        try {
            return reader.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
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
