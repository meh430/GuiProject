import java.awt.*;
import javax.swing.*;

public class Cart {
    private int intCartLength = 100, intCartHeight = 75, intStartX = 5, intStartY = 150,
    intWheelDimensions = 25, intWheel1StartX = 5, intWheel2StartX = 80, intWheelStartY = 225, intRope = Animation.intRopeLength,
    intRopeX = 105, intRopeY = 150, intRopeEndX= 750, intRopeEndY = 150;

    private double dblMass, dblAcceleration, dblTension, dblVelocity = 0;
    private boolean blnMoving = false;

    public Cart(double dblMass) {
        this.dblMass = dblMass;
    }

    public void startMoving() {
        blnMoving = true;
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

    public void setTension(double dblTension) {
        this.dblTension = dblTension;
    }

    public double getTension() {
        return dblTension;
    }

    public void setVelocity(double dblVelocity) {
        this.dblVelocity = dblVelocity;
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
        g.setColor(Color.RED);
        g.fillRect(intStartX + (int)dblVelocity, intStartY, intCartLength, intCartHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(intWheel1StartX + (int)dblVelocity, intWheelStartY, intWheelDimensions, intWheelDimensions);
        g.fillOval(intWheel2StartX + (int)dblVelocity, intWheelStartY, intWheelDimensions, intWheelDimensions);
    }

    public void drawMovingRope(Graphics g) {
        g.setColor(Color.BLACK);
        intRopeX -= (int)dblVelocity;
        g.drawLine(intRopeX, intRopeY, intRopeEndX, intRopeEndY);
        if(intRope <= 0) {
            blnMoving = false;
        }
    }

    public void drawRope(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(intRopeX, intRopeY, intRopeEndX, intRopeEndY);
    }
}