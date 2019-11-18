import java.awt.*;
import javax.swing.*;

public class Driver {
    private static JFrame frame;

    public Driver() {
        frame = new JFrame("ACCELERATION");
        frame.setContentPane(null);//get from main menu
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void main(String[]args) {
        new Driver();
    }
}