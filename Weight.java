import java.awt.*;
import javax.swing.*;
public class Weight {
    private final int intDimensions = 30, intX = 735, intRopeX = 750;
    private int intY = 175, intRope = 0;
    private double dblGravity, dblMass, dblAcceleration, dblVelocity = 0;
    private boolean blnMoving = false;

    public Weight(double dblMass, double dblGravity) {
        this.dblMass = dblMass;
        this.dblGravity = dblGravity;
    }

    public void startMoving() {
        blnMoving = true;
    }

    public boolean isMoving() {
        return blnMoving;
    }

    public void setGravity(double dblGravity) {
        this.dblGravity = dblGravity;
    }

    public double getGravity() {
        return dblGravity;
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

    public double getVelocity() {
        return dblVelocity;
    }

    public void moveWeight(Graphics g) {
        if(blnMoving) {
            dblVelocity += (dblAcceleration * 5)/48.0;
            intY += Math.round(dblVelocity);
        }
        g.setColor(Color.GRAY);
        g.fillRect(intX, intY, intDimensions, intDimensions);
    }

    public void drawWeight(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(intX, intY, intDimensions, intDimensions);
    }

    public void drawRope(Graphics g) {
        if(blnMoving) {
            intRope += Math.round(dblVelocity);
        }
        g.setColor(new Color(120, 48, 19));
        g.drawLine(intRopeX, 150, intRopeX, intY);
        if(intRope >= 300) {
            blnMoving = false;
        }
    }
}