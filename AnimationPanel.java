import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class AnimationPanel extends JPanel {
    public AnimationPanel() {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        drawPlatform(g);
        drawSky(g);

        if(Animation.weight.isMoving()) {
            Animation.weight.moveWeight(g);
            Animation.weight.drawRope(g);
        } else if(!Animation.weight.isMoving()) {
            Animation.weight.moveWeight(g);
            Animation.weight.drawRope(g);
        } else if(Animation.weight != null) {
            Animation.weight.drawWeight(g);
        }

        if(Animation.cart.isMoving()) {
            Animation.cart.moveCart(g);
            Animation.cart.drawMovingRope(g);
        } else if(Animation.cart.stopped()) {
            Animation.cart.drawCartEnd(g);
            Animation.cart.drawRope(g);
        } else {
            Animation.cart.drawCart(g);
            Animation.cart.drawRope(g);
        }
    }

    private void drawPlatform(Graphics g) {
        g.drawLine(0, 250, 700, 250);
        g.drawLine(700, 250, 700, 150);
        g.drawLine(700, 150, 750, 150);
        g.drawLine(750, 150, 750, 175);
        g.drawLine(750, 175, 725, 175);
        g.drawLine(725, 175, 725, 540);
    }

    private void drawSky(Graphics g) {
        g.setColor(new Color(12, 215, 242));
        int [] intXPoints = {0, 0, 700, 700, 750, 750, 725, 725, 960, 960, 0};
        int [] intYPoints = {0, 250, 250, 150, 150, 175, 175, 540, 540, 0, 0};
        g.fillPolygon(intXPoints, intYPoints, 11);
    }
}