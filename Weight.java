import java.awt.*;
import javax.swing.*;

//This class is a blueprint for the hanging weight object
public class Weight {
    //Properties
    //Constants defining the dimensions of the weight and the x coordinates because weight only moves vertically
    private final int intDimensions = 30, intX = 735, intRopeX = 750;
    private int intY = 175;
    //Amount of rope on the weight side
    private int intRope = 0;
    private double dblGravity, dblMass, dblAcceleration, dblVelocity = 0;
    private boolean blnMoving = false;

    //Methods
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

    //Increment veleocity according to the acceleration
    public void moveWeight(Graphics g) {
        if(blnMoving) {
            //Each meter is 5 pixels, divide by 48 because this is called 48 times a second
            dblVelocity += (dblAcceleration * 5)/48.0;
            //Round up because there cannot be a portion of a pixel
            intY += Math.round(dblVelocity);
        }
        drawWeight(g);
    }

    //Draws the current position of the weight
    public void drawWeight(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(intX, intY, intDimensions, intDimensions);
    }

    //Draw the rope and increase its length
    public void drawRope(Graphics g) {
        if(blnMoving) {
            //Increase the amount of rope on the weight side
            intRope += Math.round(dblVelocity);
        }
        g.setColor(new Color(120, 48, 19));
        g.drawLine(intRopeX, 150, intRopeX, intY);
        if(intRope >= 300) {
            blnMoving = false;
        }
    }

    //Constructor
    public Weight(double dblMass, double dblGravity) {
        this.dblMass = dblMass;
        this.dblGravity = dblGravity;
    }

}