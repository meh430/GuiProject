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
        } else if(Animation.cart != null) {
            Animation.cart.drawCart(g);
            Animation.cart.drawRope(g);
        } 
    }

    public void drawPlatform(Graphics g) {
        g.drawLine(0, 250, 700, 250);
        g.drawLine(700, 250, 700, 150);
        g.drawLine(700, 150, 750, 150);
        g.drawLine(750, 150, 750, 175);
        g.drawLine(750, 175, 725, 175);
        g.drawLine(725, 175, 725, 540);
        //g.drawLine();
    }
}