import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

//disable go button
//add more checks to cart and weight

public class Animation implements ActionListener, ChangeListener {
    public static final int intRopeLength = 400;
    public static Weight weight;
    public static Cart cart;
    private double dblAcceleration;

    private final String strCartMass = "Cart Mass: ", strWeight = "Weight Mass: ", strGravity = "Gravity: ",
                    strAcceleration = "Acceleration of System: ", strTension = "Force of Tension: ",
                    strGravityForce = "Force of Gravity: ", strMass = "Mass of System: ", strNetForce = "Net Force on Weight: ";
    private final int intSlideLength = 250, intSlideHeight = 20, intVarLabelX = 425, intSlideLabelX = 25;
    private AnimationPanel animatePanel = new AnimationPanel();

    private Timer mainTimer = new Timer(1000/60, this);

    private JButton backButton = new JButton("<- BACK");
    private JButton goButton = new JButton("GO");
    private JButton resetButton = new JButton("RESET");

    private JSlider cartMassSlide = new JSlider(1, 20);
    private JLabel cartMassLabel = new JLabel(strCartMass);
    private JSlider weightSlide = new JSlider(1, 20);
    private JLabel weightLabel = new JLabel(strWeight);
    private JSlider gravitySlide = new JSlider(1, 20);
    private JLabel gravityLabel = new JLabel(strGravity);

    private JLabel titleLabel = new JLabel("VARIABLES");
    private JLabel accelerationLabel = new JLabel(strAcceleration);
    private JLabel tensionLabel = new JLabel(strTension);
    private JLabel gravityForceLabel = new JLabel(strGravityForce);
    private JLabel massLabel = new JLabel(strMass);
    private JLabel netForceLabel = new JLabel(strNetForce);

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mainTimer) {
            animatePanel.repaint();
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
            cartMassLabel.setText(strCartMass + cartMassSlide.getValue());
            cart.setMass(cartMassSlide.getValue());
        } else if(e.getSource() == weightSlide) {
            weightLabel.setText(strWeight + weightSlide.getValue());
            weight.setMass(weightSlide.getValue());
        } else if(e.getSource() == gravitySlide) {
            gravityLabel.setText(strGravity + gravitySlide.getValue());
            weight.setGravity(gravitySlide.getValue());
        }

        initializeVariables();
    }

    public Animation() {
        animatePanel.setPreferredSize(new Dimension(Driver.intPanelWidth, Driver.intPanelHeight));
        animatePanel.setLayout(null);
        initializeButtons();
        initializeLabels();
        initializeSliders();
        initializeVariables();
    }

    private void initializeVariables() {
        dblAcceleration = Calculations.calculateAcceleration(weight, cart);
        cart.setAcceleration(dblAcceleration);
        weight.setAcceleration(dblAcceleration);
        //System.out.println(Math.round(Calculations.calculateAcceleration(weight, cart) * 100)/100);
        accelerationLabel.setText(strAcceleration + round(dblAcceleration));
        massLabel.setText(strMass + round(weight.getMass() + cart.getMass()));
        tensionLabel.setText(strTension + round(Calculations.calculateTension(cart)));
        gravityForceLabel.setText(strGravityForce + round(Calculations.calculateForceGravity(weight)));
        netForceLabel.setText(strNetForce + round(Calculations.calculateNetForce(weight, cart)));
    }

    private double round(double dblNum) {
        return Math.round(dblNum * 100.0) / 100.0;
    }

    private void initializeSliders() {
        cartMassSlide.setSize(intSlideLength, intSlideHeight);
        cartMassSlide.setLocation(intSlideLabelX, 325);
        cartMassSlide.addChangeListener(this);

        weightSlide.setSize(intSlideLength, intSlideHeight);
        weightSlide.setLocation(intSlideLabelX, 375);
        weightSlide.addChangeListener(this);

        gravitySlide.setSize(intSlideLength, intSlideHeight);
        gravitySlide.setLocation(intSlideLabelX, 425);
        gravitySlide.addChangeListener(this);

        weight = new Weight(weightSlide.getValue(), gravitySlide.getValue());
        cart = new Cart(cartMassSlide.getValue());

        animatePanel.add(cartMassSlide);
        animatePanel.add(gravitySlide);
        animatePanel.add(weightSlide);
    }

    private void initializeButtons() {
        backButton.setSize(100, 25);
        
        backButton.setLocation(15, 15);
        backButton.addActionListener(this);

        goButton.setSize(100, 25);
        goButton.setLocation(25, 500);
        goButton.addActionListener(this);

        resetButton.setSize(100,25);
        resetButton.setLocation(25, 470);
        resetButton.addActionListener(this);

        animatePanel.add(goButton);
        animatePanel.add(backButton);
        animatePanel.add(resetButton);
    }

    private void initializeLabels() {
        titleLabel.setSize(100, 25);
        titleLabel.setLocation(525, 300);

        accelerationLabel.setSize(200, 25);
        accelerationLabel.setLocation(intVarLabelX, 325);

        massLabel.setSize(200, 25);
        massLabel.setLocation(intVarLabelX, 350);

        tensionLabel.setSize(200, 25);
        tensionLabel.setLocation(intVarLabelX, 375);

        gravityForceLabel.setSize(200, 25);
        gravityForceLabel.setLocation(intVarLabelX, 400);

        netForceLabel.setSize(200, 25);
        netForceLabel.setLocation(intVarLabelX, 425);

        cartMassLabel.setSize(200, 25);
        cartMassLabel.setLocation(intSlideLabelX, 300);
        cartMassLabel.setText(strCartMass + cartMassSlide.getValue());
        
        weightLabel.setSize(200, 25);
        weightLabel.setLocation(intSlideLabelX, 350);
        weightLabel.setText(strWeight + weightSlide.getValue());

        gravityLabel.setSize(200, 25);
        gravityLabel.setLocation(intSlideLabelX, 400);
        gravityLabel.setText(strGravity + gravitySlide.getValue());

        animatePanel.add(titleLabel);
        animatePanel.add(accelerationLabel);
        animatePanel.add(massLabel);
        animatePanel.add(tensionLabel);
        animatePanel.add(gravityForceLabel);
        animatePanel.add(netForceLabel);
        animatePanel.add(cartMassLabel);
        animatePanel.add(weightLabel);
        animatePanel.add(gravityLabel);
    }

    public AnimationPanel getAnimationPanel() {
        return animatePanel;
    }
}