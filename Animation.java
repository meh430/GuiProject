import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Animation implements ActionListener, ChangeListener {
    public static final int intRopeLength = 400;
    public static Weight weight;
    public static Cart cart;

    private final String strCartMass = "Cart Mass: ", strWeight = "Weight Mass: ", strGravity = "Gravity: ",
                    strAcceleration = "Acceleration of System: ", strTension = "Force of Tension: ",
                    strGravityForce = "Force of Gravity: ", strMass = "Mass of System: ", strNetForce = "Net Force on Weight: ";
    private final int intSlideLength = 250, intSlideHeight = 20, intVarLabelX = 425, intSlideLabelX = 25;
    private AnimationPanel animatePanel = new AnimationPanel();

    private Timer mainTimer = new Timer(1000/60, this);

    private JButton backButton = new JButton("<- BACK");
    private JButton goButton = new JButton("GO");

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
        if(e.getSource() == backButton) {
            Driver.changePanel(Driver.menuScreen.getMenuPanel());
        } else if(e.getSource() == goButton) {
            weight.startMoving();
            //start simulation
        }
    }

    @Override 
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == cartMassSlide) {
            cartMassLabel.setText(strCartMass + cartMassSlide.getValue());
        } else if(e.getSource() == weightSlide) {
            weightLabel.setText(strWeight + weightSlide.getValue());
        } else if(e.getSource() == gravitySlide) {
            gravityLabel.setText(strGravity + gravitySlide.getValue());
        }
    }

    public Animation() {
        animatePanel.setPreferredSize(new Dimension(Driver.intPanelWidth, Driver.intPanelHeight));
        animatePanel.setLayout(null);
        initializeButtons();
        initializeLabels();
        initializeSliders();
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
        cart = new Cart();

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

        animatePanel.add(goButton);
        animatePanel.add(backButton);
    }

    private void initializeLabels() {
        titleLabel.setSize(100, 25);
        titleLabel.setLocation(525, 300);

        accelerationLabel.setSize(150, 25);
        accelerationLabel.setLocation(intVarLabelX, 325);

        massLabel.setSize(150, 25);
        massLabel.setLocation(intVarLabelX, 350);

        tensionLabel.setSize(150, 25);
        tensionLabel.setLocation(intVarLabelX, 375);

        gravityForceLabel.setSize(150, 25);
        gravityForceLabel.setLocation(intVarLabelX, 400);

        netForceLabel.setSize(150, 25);
        netForceLabel.setLocation(intVarLabelX, 425);

        cartMassLabel.setSize(150, 25);
        cartMassLabel.setLocation(intSlideLabelX, 300);
        cartMassLabel.setText(strCartMass + cartMassSlide.getValue());
        
        weightLabel.setSize(150, 25);
        weightLabel.setLocation(intSlideLabelX, 350);
        weightLabel.setText(strWeight + weightSlide.getValue());

        gravityLabel.setSize(150, 25);
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