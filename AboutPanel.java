import javax.swing.*;
import java.awt.*;

//Implements the JPanel used in the About screen
public class AboutPanel extends JPanel {

    //Methods
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawImages(g);
    }

    private void drawImages(Graphics g) {
        //draw the St A logo to the panel
        g.drawImage(Utility.loadImage("stALogo.png"), 20, 50, null);
    }

    //Constructor
    public AboutPanel() {
        //Initialize default JPanel properties
        super();
    }
}