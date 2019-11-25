import java.awt.*;
import javax.swing.*;

public class Cart {
    private final int intCartLength = 100, intCartHeight = 75, intRopeEndX= 750, intRopeEndY = 150, intRopeY = 150, intY = 150, 
                     intWheelDimensions = 25, intWheelY = 225;
    private int intX = 300, intWheel1X = 300, intWheel2X = 375, intRope = 300, intRopeX = 400;

    private double dblMass, dblAcceleration, dblVelocity = 0, dblTime = 0;
    private boolean blnMoving = false, blnStopped = false;

    public Cart(double dblMass) {
        this.dblMass = dblMass;
    }

    public double getTime() {
        return dblTime;
    }

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

    public void drawCart(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(intX, intY, intCartLength, intCartHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(intWheel1X, intWheelY, intWheelDimensions, intWheelDimensions);
        g.fillOval(intWheel2X, intWheelY, intWheelDimensions, intWheelDimensions);
    }

    public void moveCart(Graphics g) {
        if(blnMoving) {
            dblVelocity += (dblAcceleration * 5)/48.0;
            //intX += (int)dblVelocity;
            //intWheel1X += (int)dblVelocity;
            //intWheel2X += (int)dblVelocity;
            intX += Math.round(dblVelocity);
            intWheel1X += Math.round(dblVelocity);
            intWheel2X += Math.round(dblVelocity);
        }

        
        g.setColor(Color.RED);
        g.fillRect(intX, intY, intCartLength, intCartHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(intWheel1X, intWheelY, intWheelDimensions, intWheelDimensions);
        g.fillOval(intWheel2X, intWheelY, intWheelDimensions, intWheelDimensions);
        
    }

    public void drawCartEnd(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(600, intY, intCartLength, intCartHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(600, intWheelY, intWheelDimensions, intWheelDimensions);
        g.fillOval(675, intWheelY, intWheelDimensions, intWheelDimensions);
    }

    public void drawMovingRope(Graphics g) {
        if(blnMoving) {
            //intRope -= (int)dblVelocity;
            //intRopeX += (int)dblVelocity;
            intRope -= Math.round(dblVelocity);
            intRopeX += Math.round(dblVelocity);
        }
        
        g.setColor(Color.BLACK);

        g.drawLine(intRopeX, 150, intRopeEndX, intRopeEndY);
        if(intRope <= 0) {
            blnMoving = false;
            blnStopped = true;
        }
    }

    public void drawRope(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(intRopeX, intRopeY, intRopeEndX, intRopeEndY);
    }
}