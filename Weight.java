import java.awt.*;
import javax.swing.*;
public class Weight {
    private final int intDimensions = 30, intStartX = 735, intStartY = 175;
    private int intRope = 0,  intRopeX = 750, intRopeY = 150;
    private double dblGravity, dblMass, dblForceGravity, dblNetForce, dblAcceleration, dblTension, dblVelocity = 0;
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

    public void setForceGravity(double dblForceGravity) {
        this.dblForceGravity = dblForceGravity;
    }

    public double getForceGravity() {
        return dblForceGravity;
    }

    public void setNetForce(double dblNetForce) {
        this.dblNetForce = dblNetForce;
    }

    public double getNetForce() {
        return dblNetForce;
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

    public void moveWeight(Graphics g) {
        g.fillRect(intStartX, intStartY + (int)dblVelocity, intDimensions, intDimensions);
    }

    public void drawWeight(Graphics g) {
        g.fillRect(intStartX, intStartY, intDimensions, intDimensions);
    }

    public void drawRope(Graphics g) {
        intRopeY += (int)dblVelocity;
        g.drawLine(intRopeX, intRopeY, intRopeX, intRopeY + (int)dblVelocity);
        if(intRope >= Animation.intRopeLength) {
            blnMoving = false;
        }
    }
}