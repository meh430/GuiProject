import java.awt.*;
import javax.swing.*;

public class Cart {
    private int intCartLength = 100, intCartHeight = 75, intStartX = 300, intStartY = 150,
    intWheelDimensions = 25, intWheel1StartX = 300, intWheel2StartX = 375, intWheelStartY = 225, intRope = 300,
    intRopeX = 400, intRopeY = 150, intRopeEndX= 750, intRopeEndY = 150;

    private double dblMass, dblAcceleration, dblVelocity = 0;
    private boolean blnMoving = false, blnStopped = false;
    double dblTime = 0;

    public Cart(double dblMass) {
        this.dblMass = dblMass;
    }

    public double getTime() {
        return dblTime;
    }

    public void incrementTime() {
        dblTime += (1000.0/60.0);
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
        g.fillRect(intStartX, intStartY, intCartLength, intCartHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(intWheel1StartX, intWheelStartY, intWheelDimensions, intWheelDimensions);
        g.fillOval(intWheel2StartX, intWheelStartY, intWheelDimensions, intWheelDimensions);
    }

    public void moveCart(Graphics g) {
        if(blnMoving) {
            dblVelocity += (dblAcceleration * 5)/60.0;
            intStartX += (int)dblVelocity;
            intWheel1StartX += (int)dblVelocity;
            intWheel2StartX += (int)dblVelocity;
        }

        
        g.setColor(Color.RED);
        g.fillRect(intStartX, intStartY, intCartLength, intCartHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(intWheel1StartX, intWheelStartY, intWheelDimensions, intWheelDimensions);
        g.fillOval(intWheel2StartX, intWheelStartY, intWheelDimensions, intWheelDimensions);
        
    }

    public void drawCartEnd(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(600, intStartY, intCartLength, intCartHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(600, intWheelStartY, intWheelDimensions, intWheelDimensions);
        g.fillOval(675, intWheelStartY, intWheelDimensions, intWheelDimensions);
    }

    public void drawMovingRope(Graphics g) {
        if(blnMoving) {
            intRope -= (int)dblVelocity;
            intRopeX += (int)dblVelocity;
        }
        
        g.setColor(Color.BLACK);

        g.drawLine(intRopeX, 150, 750, 150);
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