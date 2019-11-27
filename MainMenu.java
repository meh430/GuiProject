import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MainMenu implements ActionListener {
    public static JFrame frame;// = new JFrame("ACCELERATION");
    private Color darkGrey = new Color(53, 53, 56);

    private final int intButtWidth = 300, intButtLength = 50;
    private JPanel menuPanel = new JPanel();
    private JLabel titleLabel = new JLabel("ACCELERATION");

    private JButton startButton = new JButton("START");
    private JButton testButton = new JButton("TEST");
    private JButton helpButton = new JButton("HELP");
    private JButton scoreButton = new JButton("SCORES");
    private JButton aboutButton = new JButton("ABOUT");

    @Override
    public void actionPerformed(ActionEvent e) {
        //set mainPanel depending on the button chosen  
        if(e.getSource() == startButton) {
            System.out.println("START");
            Driver.changePanel(new Animation().getAnimationPanel());
        } else if(e.getSource() == testButton) {
            System.out.println("TEST");
            Driver.changePanel(new Test().getTestPanel());
        } else if(e.getSource() == helpButton) {
            System.out.println("HELP");
            Driver.changePanel(new Help().getHelpPanel());
        } else if(e.getSource() == scoreButton) {
            System.out.println("SCORE");
            Driver.changePanel(new Scores().getScorePanel());
        } else if(e.getSource() == aboutButton) {
            System.out.println("ABOUT");
            Driver.changePanel(new About().getAboutPanel());
        }
    }

    public MainMenu() {
        menuPanel.setPreferredSize(new Dimension(Driver.intPanelWidth, Driver.intPanelHeight));
        menuPanel.setLayout(null);
        menuPanel.setBackground(Color.BLACK);

        titleLabel.setSize(500, 100);
        titleLabel.setLocation(230, 50);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);

        startButton.setSize(intButtWidth, intButtLength);
        startButton.setLocation(330, 200);
        startButton.addActionListener(this);

        testButton.setSize(intButtWidth, intButtLength);
        testButton.setLocation(330, 260);
        testButton.addActionListener(this);

        helpButton.setSize(intButtWidth, intButtLength);
        helpButton.setLocation(330, 380);
        helpButton.addActionListener(this);

        scoreButton.setSize(intButtWidth, intButtLength);
        scoreButton.setLocation(330, 320);
        scoreButton.addActionListener(this);

        aboutButton.setSize(intButtWidth, intButtLength);
        aboutButton.setLocation(330, 440);
        aboutButton.addActionListener(this);

        menuPanel.add(titleLabel);
        setLabelStyle(titleLabel, 42);
        menuPanel.add(startButton);
        setButtonStyle(startButton, 16);
        menuPanel.add(testButton);
        setButtonStyle(testButton, 16);
        menuPanel.add(helpButton);
        setButtonStyle(helpButton, 16);
        menuPanel.add(scoreButton);
        setButtonStyle(scoreButton, 16);
        menuPanel.add(aboutButton);
        setButtonStyle(aboutButton, 16);
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public static void setLabelStyle(JLabel label, int intFontSize) {
        label.setFont(Driver.getFont().deriveFont(Font.PLAIN, intFontSize));
        label.setForeground(Color.WHITE);
    }

    public static void setButtonStyle(JButton button, int intFontSize) {
        button.setBackground(new Color(53,53,56));
        button.setForeground(Color.WHITE);
        button.setFont(Driver.getFont().deriveFont(Font.PLAIN, intFontSize));
    }
}
