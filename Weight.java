import java.awt.*;
import javax.swing.*;
public class Weight {
    private int intDimensions = 30, intStartX = 735, intStartY = 175;
    private int intRope = 0,  intRopeX = 750, intRopeY = 175;
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
            dblVelocity += (dblAcceleration * 5)/60.0;
            intStartY += (int)dblVelocity;
        }
        g.setColor(Color.BLACK);
        g.fillRect(735, intStartY, intDimensions, intDimensions);
    }

    public void drawWeight(Graphics g) {
        g.fillRect(intStartX, intStartY, intDimensions, intDimensions);
    }

    public void drawRope(Graphics g) {
        if(blnMoving) {
            intRope += (int)dblVelocity;
            intRopeY += (int)dblVelocity;
        }
        g.setColor(Color.BLACK);
        g.drawLine(750, 175, 750, intRopeY);
        if(intRope >= 300) {
            blnMoving = false;
        }
    }
}