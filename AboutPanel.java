import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.image.BufferedImage;

public class AboutPanel extends JPanel {
    public AboutPanel() {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);
        drawImages(g);
    }

    private void drawImages(Graphics g) {
        g.drawImage(Driver.loadImage("stALogo.png"), 20, 50, null);
    }
}