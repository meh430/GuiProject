import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * <h1>AnimationPanel</h1>
 * This class handles the animation/drawing for the GUI assignment<br>
 * It models a pulley system with a cart and a hanging weight meant to demonstrate Newton's second law of motion and acceleration<br>
 * <p>
 * 
 * @author Mehul Pillai
 * @version 1.0
 * @since 2019-11-29
 */
public class AnimationPanel extends JPanel {

    //Methods
    /** Draws the platform on which the cart is placed
      * @param g Graphics object provided by JPanel
      */
    public void drawPlatform(Graphics g) {
        g.drawLine(0, 250, 700, 250);
        g.drawLine(700, 250, 700, 150);
        g.drawLine(700, 150, 750, 150);
        g.drawLine(750, 150, 750, 175);
        g.drawLine(750, 175, 725, 175);
        g.drawLine(725, 175, 725, 540);
    }

    /** Draws a blue polygon representing the sky
      * @param g Graphics object provided by JPanel
      */
    public void drawSky(Graphics g) {
        g.setColor(new Color(31, 16, 163));
        int [] intXPoints = {0, 0, 700, 700, 750, 750, 725, 725, 960, 960, 0};
        int [] intYPoints = {0, 250, 250, 150, 150, 175, 175, 540, 540, 0, 0};
        g.fillPolygon(intXPoints, intYPoints, 11);
    }

    /** Draws the cart and the weight to the panel
      * @param g Graphics object provided by JPanel
      */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        drawPlatform(g);
        drawSky(g);

        if(Animation.weight.isMoving()) {
            Animation.weight.moveWeight(g);
            Animation.weight.drawRope(g);
        } else if(Animation.weight != null) {
            //Draw stationary weight  when not moving
            Animation.weight.drawWeight(g);
            Animation.weight.drawRope(g);
        }

        if(Animation.cart.isMoving()) {
            Animation.cart.moveCart(g);
            Animation.cart.drawMovingRope(g);
        } else if(Animation.cart.stopped()) {
            //Force the cart to be drawn at end position because sometimes,
            //the cart may overshoot and clip with the wall 
            Animation.cart.drawCartEnd(g);
            Animation.cart.drawRope(g);
        } else if(Animation.cart != null) {
            //draw cart at starting position
            Animation.cart.drawCart(g);
            Animation.cart.drawRope(g);
        }
    }

    //Constructor
    /** Create an AnimationPanel with default JPanel properties and animations
      */
    public AnimationPanel() {
        super();
    }
}