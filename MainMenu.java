import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

//This class implements the Main Menu screen and takes user to all other screens
public class MainMenu implements ActionListener {
    //Properties
    public static JFrame frame;

    //JButton dimensions
    private final int intButtWidth = 300, intButtHeight = 50;

    private JPanel menuPanel = new JPanel();
    private JLabel titleLabel = new JLabel("Acceleration and Pulleys");
    private JButton startButton = new JButton("START");
    private JButton testButton = new JButton("TEST");
    private JButton helpButton = new JButton("HELP");
    private JButton scoreButton = new JButton("SCORES");
    private JButton aboutButton = new JButton("ABOUT");

    //Methods
    @Override
    public void actionPerformed(ActionEvent e) {
        //Set JFrame content depending on the button chosen  
        if(e.getSource() == startButton) {
            Utility.changePanel(new Animation().getAnimationPanel());
        } else if(e.getSource() == testButton) {
            Utility.changePanel(new Test().getTestPanel());
        } else if(e.getSource() == helpButton) {
            Utility.changePanel(new Help().getHelpPanel());
        } else if(e.getSource() == scoreButton) {
            Utility.changePanel(new Scores().getScorePanel());
        } else if(e.getSource() == aboutButton) {
            Utility.changePanel(new About().getAboutPanel());
        }
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    //Constructor
    //Initialize the panel and all the JComponents
    public MainMenu() {
        menuPanel.setPreferredSize(Utility.panelDimensions);
        menuPanel.setLayout(null);
        menuPanel.setBackground(Color.BLACK);

        titleLabel.setSize(500, 100);
        titleLabel.setLocation(230, 50);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);

        startButton.setSize(intButtWidth, intButtHeight);
        startButton.setLocation(330, 200);
        startButton.addActionListener(this);

        testButton.setSize(intButtWidth, intButtHeight);
        testButton.setLocation(330, 260);
        testButton.addActionListener(this);

        helpButton.setSize(intButtWidth, intButtHeight);
        helpButton.setLocation(330, 380);
        helpButton.addActionListener(this);

        scoreButton.setSize(intButtWidth, intButtHeight);
        scoreButton.setLocation(330, 320);
        scoreButton.addActionListener(this);

        aboutButton.setSize(intButtWidth, intButtHeight);
        aboutButton.setLocation(330, 440);
        aboutButton.addActionListener(this);

        menuPanel.add(titleLabel);
        Utility.setLabelStyle(titleLabel, 42);
        menuPanel.add(startButton);
        Utility.setButtonStyle(startButton, 16);
        menuPanel.add(testButton);
        Utility.setButtonStyle(testButton, 16);
        menuPanel.add(helpButton);
        Utility.setButtonStyle(helpButton, 16);
        menuPanel.add(scoreButton);
        Utility.setButtonStyle(scoreButton, 16);
        menuPanel.add(aboutButton);
        Utility.setButtonStyle(aboutButton, 16);
    }
}
