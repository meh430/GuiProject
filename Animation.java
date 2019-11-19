import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Animation implements ActionListener {
    private AnimationPanel animatePanel = new AnimationPanel();

    private JButton backButton = new JButton("<- BACK");

    private JSlider cartMassSlide = new JSlider(0, 20);
    private JSlider weightSlide = new JSlider(0, 20);

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            Driver.changePanel(Driver.menuScreen.getMenuPanel());
        } 
    }

    public Animation() {
        animatePanel.setPreferredSize(new Dimension(Driver.intPanelWidth, Driver.intPanelHeight));
        animatePanel.setLayout(null);

        backButton.setSize(100, 50);
        backButton.setLocation(25, 25);
        backButton.addActionListener(this);

        animatePanel.add(backButton);
    }

    public AnimationPanel getAnimationPanel() {
        return animatePanel;
    }
}