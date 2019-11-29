import java.awt.*;
import javax.swing.*;

//This class is a blueprint for creating a cart
public class Cart {
    //Properties
    //Constants for cart dimensions, wheel dimensions, and the y coordinates because the cart only moves horizontally
    private final int intCartLength = 100, intCartHeight = 75, intRopeEndX= 750, intRopeEndY = 150, intRopeY = 150, intY = 150, 
                     intWheelDimensions = 25, intWheelY = 225;
    
    //X coordinates for the cart, wheels, and the rope
    private int intX = 300, intWheel1X = 300, intWheel2X = 375, intRopeX = 400;
    //Amount of rope remaining till the cart hits the wheel in pixels
    private int intRope = 300;

    private double dblMass, dblAcceleration, dblVelocity = 0, dblTime = 0;
    private boolean blnMoving = false, blnStopped = false;

    //Methods
    public double getTime() {
        return dblTime;
    }

    //increment time according the the interval at which the main timer fires action events
    public void incrementTime() {
        dblTime += (1000.0/48.0);
    }

    public void startMoving() {
        blnMoving = true;
    }

    public boolean stopped() {
        return blnStopped;
    }

    public boolean isMoving() {
        return blnMoving;
    }

    public void setMass(double dblMass) {
        this.dblMass = dblMass;
    }

    public double getMass() {
        return dblMass;
    }

    public void setAcceleration(double dblAcceleration) {
        this.dblAcceleration = dblAcceleration;
    }

    public double getAcceleration() {
        return dblAcceleration;
    }

    public double getVelocity() {
        return dblVelocity;
    }

    //Draw the cart at current position
    public void drawCart(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(intX, intY, intCartLength, intCartHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(intWheel1X, intWheelY, intWheelDimensions, intWheelDimensions);
        g.fillOval(intWheel2X, intWheelY, intWheelDimensions, intWheelDimensions);
    }

    public void moveCart(Graphics g) {
        if(blnMoving) {
            //Each meter is 5 pixels, divide by 48 because this is called 48 times a second
            dblVelocity += (dblAcceleration * 5)/48.0;
            //Round up because there cannot be a portion of a pixel
            intX += Math.round(dblVelocity);
            intWheel1X += Math.round(dblVelocity);
            intWheel2X += Math.round(dblVelocity);
        }

        drawCart(g);
        
    }

    //Draw the cart at the end position
    public void drawCartEnd(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(600, intY, intCartLength, intCartHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(600, intWheelY, intWheelDimensions, intWheelDimensions);
        g.fillOval(675, intWheelY, intWheelDimensions, intWheelDimensions);
    }

    public void drawMovingRope(Graphics g) {
        if(blnMoving) {
            //subtract the velocity from the remaining rope
            intRope -= Math.round(dblVelocity);
            intRopeX += Math.round(dblVelocity);
        }
        
        drawRope(g);

        //there is no more rope so the motion has ended
        if(intRope <= 0) {
            blnMoving = false;
            blnStopped = true;
        }
    }

    //draw rope at current position and length
    public void drawRope(Graphics g) {
        g.setColor(new Color(120, 48, 19));
        g.drawLine(intRopeX, intRopeY, intRopeEndX, intRopeEndY);
    }
    
    //Constructor
    public Cart(double dblMass) {
        this.dblMass = dblMass;
    }
}