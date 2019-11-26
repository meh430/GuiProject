import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

//TODO: disable go button
//TODO: add more checks to cart and weight

public class Animation implements ActionListener, ChangeListener {
    public static final int intRopeLength = 400;
    public static Weight weight;
    public static Cart cart;
    private double dblAcceleration;

    private final String strCartMass = "Cart Mass: ", strWeight = "Weight Mass: ", strGravity = "Gravity: ",
                    strAcceleration = "Acceleration of System: ", strTension = "Force of Tension: ",
                    strGravityForce = "Force of Gravity: ", strMass = "Mass of System: ", strNetForce = "Net Force on Weight: ",
                    strVelocity = "Velocity: ", strTime  = "Time: ", strAccelUnits = " m/s^2", strTimeUnits = " s", strMassUnits = " kg", 
                    strVelocUnits = " m/s", strForceUnits = " N";
    private final int intSlideLength = 265, intSlideHeight = 20, intVarLabelX = 425, intSlideLabelX = 25, intLabelWidth = 250, intLabelHeight = 25;
    private AnimationPanel animatePanel = new AnimationPanel();

    private Timer mainTimer = new Timer(1000/48, this);

    private JButton backButton = new JButton("<- BACK");
    private JButton goButton = new JButton("GO");
    private JButton resetButton = new JButton("RESET");

    private JSlider cartMassSlide = new JSlider(1, 125);
    private JLabel cartMassLabel = new JLabel(strCartMass);
    private JSlider weightSlide = new JSlider(1, 125);
    private JLabel weightLabel = new JLabel(strWeight);
    private JSlider gravitySlide = new JSlider(1, 125, 49);
    private JLabel gravityLabel = new JLabel(strGravity);

    private JLabel titleLabel = new JLabel("VARIABLES");
    private JLabel accelerationLabel = new JLabel(strAcceleration);
    private JLabel tensionLabel = new JLabel(strTension);
    private JLabel gravityForceLabel = new JLabel(strGravityForce);
    private JLabel massLabel = new JLabel(strMass);
    private JLabel netForceLabel = new JLabel(strNetForce);
    private JLabel velocityLabel = new JLabel();
    private JLabel timeLabel = new JLabel();

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mainTimer) {
            animatePanel.repaint();
            if(cart.stopped()) {
                goButton.setEnabled(false);
                mainTimer.stop();
            }
            velocityLabel.setText(strVelocity + Calculations.round(cart.getVelocity()) + strVelocUnits);
            cart.incrementTime();
            timeLabel.setText(strTime + Calculations.round(cart.getTime()/1000.0) + strTimeUnits);
        }

        if(e.getSource() == backButton) {
            Driver.changePanel(Driver.menuScreen.getMenuPanel());
        } else if(e.getSource() == goButton) {
            mainTimer.start();
            weight.startMoving();
            cart.startMoving();
        } else if(e.getSource() == resetButton) {
            Driver.changePanel(new Animation().getAnimationPanel());
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == cartMassSlide) {
            cartMassLabel.setText(strCartMass + (cartMassSlide.getValue() / 5.0) + strMassUnits);
            cart.setMass(cartMassSlide.getValue() / 5.0);
        } else if(e.getSource() == weightSlide) {
            weightLabel.setText(strWeight + (weightSlide.getValue() / 5.0) + strMassUnits);
            weight.setMass(weightSlide.getValue() / 5.0);
        } else if(e.getSource() == gravitySlide) {
            gravityLabel.setText(strGravity + (gravitySlide.getValue() / 5.0) + strAccelUnits);
            weight.setGravity(gravitySlide.getValue() / 5.0);
        }

        initializeVariables();
    }

    public Animation() {
        animatePanel.setPreferredSize(new Dimension(Driver.intPanelWidth, Driver.intPanelHeight));
        animatePanel.setLayout(null);
        animatePanel.setBackground(Color.BLACK);
        initializeButtons();
        initializeSliders();
        initializeLabels();
        initializeVariables();
    }

    private void initializeVariables() {
        dblAcceleration = Calculations.calculateAcceleration(weight, cart);
        cart.setAcceleration(dblAcceleration);
        weight.setAcceleration(dblAcceleration);
        accelerationLabel.setText(strAcceleration + Calculations.round(dblAcceleration) + strAccelUnits);
        massLabel.setText(strMass + Calculations.round(weight.getMass() + cart.getMass()) + strMassUnits);
        tensionLabel.setText(strTension + Calculations.round(Calculations.calculateTension(cart)) + strForceUnits);
        gravityForceLabel.setText(strGravityForce + Calculations.round(Calculations.calculateForceGravity(weight)) + strForceUnits);
        netForceLabel.setText(strNetForce + Calculations.round(Calculations.calculateNetForce(weight, cart)) + strForceUnits);
    }

    private void initializeSliders() {
        cartMassSlide.setSize(intSlideLength, intSlideHeight);
        cartMassSlide.setLocation(intSlideLabelX, 325);
        cartMassSlide.addChangeListener(this);
        cartMassSlide.setBackground(Color.BLACK);

        weightSlide.setSize(intSlideLength, intSlideHeight);
        weightSlide.setLocation(intSlideLabelX, 375);
        weightSlide.addChangeListener(this);
        weightSlide.setBackground(Color.BLACK);

        gravitySlide.setSize(intSlideLength, intSlideHeight);
        gravitySlide.setLocation(intSlideLabelX, 425);
        gravitySlide.addChangeListener(this);
        gravitySlide.setBackground(Color.BLACK);

        weight = new Weight(weightSlide.getValue() / 5.0, gravitySlide.getValue() / 5.0);
        cart = new Cart(cartMassSlide.getValue() / 5.0);

        animatePanel.add(cartMassSlide);
        animatePanel.add(gravitySlide);
        animatePanel.add(weightSlide);
    }

    private void initializeButtons() {
        backButton.setSize(100, 25);
        backButton.setLocation(15, 15);
        backButton.addActionListener(this);
        MainMenu.setButtonStyle(backButton, 16);

        goButton.setSize(100, 25);
        goButton.setLocation(25, 500);
        goButton.addActionListener(this);
        MainMenu.setButtonStyle(goButton, 16);

        resetButton.setSize(100,25);
        resetButton.setLocation(25, 470);
        resetButton.addActionListener(this);
        MainMenu.setButtonStyle(resetButton, 16);

        animatePanel.add(goButton);
        animatePanel.add(backButton);
        animatePanel.add(resetButton);
    }

    private void initializeLabels() {
        titleLabel.setSize(100, 25);
        titleLabel.setLocation(525, 300);
        MainMenu.setLabelStyle(titleLabel, 16);

        accelerationLabel.setSize(intLabelWidth, intLabelHeight);
        accelerationLabel.setLocation(intVarLabelX, 325);
        MainMenu.setLabelStyle(accelerationLabel, 14);

        massLabel.setSize(intLabelWidth, intLabelHeight);
        massLabel.setLocation(intVarLabelX, 350);
        MainMenu.setLabelStyle(massLabel, 14);

        tensionLabel.setSize(intLabelWidth, intLabelHeight);
        tensionLabel.setLocation(intVarLabelX, 375);
        MainMenu.setLabelStyle(tensionLabel, 14);

        gravityForceLabel.setSize(intLabelWidth, intLabelHeight);
        gravityForceLabel.setLocation(intVarLabelX, 400);
        MainMenu.setLabelStyle(gravityForceLabel, 14);

        netForceLabel.setSize(intLabelWidth, intLabelHeight);
        netForceLabel.setLocation(intVarLabelX, 425);
        MainMenu.setLabelStyle(netForceLabel, 14);

        velocityLabel.setSize(intLabelWidth, intLabelHeight);
        velocityLabel.setLocation(intVarLabelX, 450);
        velocityLabel.setText(strVelocity + cart.getVelocity() + strVelocUnits);
        MainMenu.setLabelStyle(velocityLabel, 14);

        timeLabel.setSize(intLabelWidth, intLabelHeight);
        timeLabel.setLocation(intVarLabelX, 475);
        timeLabel.setText(strTime + cart.getTime() + strTimeUnits);
        MainMenu.setLabelStyle(timeLabel, 14);

        cartMassLabel.setSize(200, 25);
        cartMassLabel.setLocation(intSlideLabelX, 300);
        cartMassLabel.setText(strCartMass + (cartMassSlide.getValue() / 5.0) + strMassUnits);
        MainMenu.setLabelStyle(cartMassLabel, 14);
        
        weightLabel.setSize(200, 25);
        weightLabel.setLocation(intSlideLabelX, 350);
        weightLabel.setText(strWeight + (weightSlide.getValue() / 5.0) + strMassUnits);
        MainMenu.setLabelStyle(weightLabel, 14);

        gravityLabel.setSize(200, 25);
        gravityLabel.setLocation(intSlideLabelX, 400);
        gravityLabel.setText(strGravity + (gravitySlide.getValue() / 5.0) + strAccelUnits);
        MainMenu.setLabelStyle(gravityLabel, 14);

        animatePanel.add(titleLabel);
        animatePanel.add(accelerationLabel);
        animatePanel.add(massLabel);
        animatePanel.add(tensionLabel);
        animatePanel.add(gravityForceLabel);
        animatePanel.add(netForceLabel);
        animatePanel.add(cartMassLabel);
        animatePanel.add(weightLabel);
        animatePanel.add(gravityLabel);
        animatePanel.add(velocityLabel);
        animatePanel.add(timeLabel);
    }

    public AnimationPanel getAnimationPanel() {
        return animatePanel;
    }
}