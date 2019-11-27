import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.image.BufferedImage;

public class About implements ActionListener {

    private AboutPanel aboutPanel = new AboutPanel();
    private JButton backButton = new JButton("<- BACK");
    private JLabel mainLabel = new JLabel("About The Programmer");
    private JLabel schoolLabel = new JLabel("Special Thanks To Mr. Cadawas");

    private JLabel [] aboutProgrammerLabels = new JLabel[3];
    private JLabel aboutSchoolLabel = new JLabel("- For running an informative and all-round fun class!");


    public About() {
        aboutPanel.setLayout(null);
        aboutPanel.setPreferredSize(new Dimension(Driver.intPanelWidth, Driver.intPanelHeight));
        aboutPanel.setBackground(Color.BLACK);
        initializeComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            Driver.changePanel(Driver.menuScreen.getMenuPanel());
        }
    }

    private void initializeComponents() {
        MainMenu.setButtonStyle(backButton, 14);
        backButton.addActionListener(this);
        backButton.setSize(100,25);
        backButton.setLocation(20, 20);

        MainMenu.setLabelStyle(mainLabel, 20);
        mainLabel.setSize(300, 25);
        mainLabel.setLocation(545, 20);

        MainMenu.setLabelStyle(schoolLabel, 20);
        schoolLabel.setSize(300, 25);
        schoolLabel.setLocation(545, 200);

        MainMenu.setLabelStyle(aboutSchoolLabel, 16);
        aboutSchoolLabel.setSize(450, 25);
        aboutSchoolLabel.setLocation(535, 220);

        for(int i = 0; i < 3; i++) {
            aboutProgrammerLabels[i] = new JLabel();
            MainMenu.setLabelStyle(aboutProgrammerLabels[i], 16);
            aboutProgrammerLabels[i].setSize(500, 25);
            aboutProgrammerLabels[i].setLocation(450, 50 + (i*30));
            aboutPanel.add(aboutProgrammerLabels[i]);
        }

        aboutProgrammerLabels[0].setText("- This app was made by Mehul Pillai");
        aboutProgrammerLabels[1].setText("- A cool guy with good looks. A loveable, caring man with a good heart");
        aboutProgrammerLabels[2].setText("- Gets irritating sometimes. (All according to Urban Dictionary)");

        aboutPanel.add(backButton);
        aboutPanel.add(mainLabel);
        aboutPanel.add(schoolLabel);
        aboutPanel.add(aboutSchoolLabel);
    }

    public JPanel getAboutPanel() {
        return aboutPanel;
    }
}