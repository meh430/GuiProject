import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MainMenu implements ActionListener {
    private final int intButtWidth = 300, intButtLength = 50;
    private JPanel mainPanel;
    private JPanel menuPanel = new JPanel();

    private JLabel titleLabel = new JLabel("ACCELERATION");

    private JButton startButton = new JButton("START");
    private JButton testButton = new JButton("TEST");
    private JButton helpButton = new JButton("HELP");
    private JButton scoreButton = new JButton("SCORES");
    private JButton aboutButton = new JButton("ABOUT");

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public MainMenu() {
        menuPanel.setPreferredSize(new Dimension(960, 540));
        menuPanel.setLayout(null);

        titleLabel.setSize(200, 100);
        titleLabel.setLocation(380, 50);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);


        startButton.setSize(intButtWidth, intButtLength);
        startButton.setLocation(330, 200);
        startButton.addActionListener(this);

        testButton.setSize(intButtWidth, intButtLength);
        testButton.setLocation(330, 260);
        testButton.addActionListener(this);

        helpButton.setSize(intButtWidth, intButtLength);
        helpButton.setLocation(330, 320);
        helpButton.addActionListener(this);

        scoreButton.setSize(intButtWidth, intButtLength);
        scoreButton.setLocation(330, 380);
        scoreButton.addActionListener(this);

        aboutButton.setSize(intButtWidth, intButtLength);
        aboutButton.setLocation(330, 440);
        aboutButton.addActionListener(this);

        menuPanel.add(titleLabel);
        menuPanel.add(startButton);
        menuPanel.add(testButton);
        menuPanel.add(helpButton);
        menuPanel.add(scoreButton);
        menuPanel.add(aboutButton);

        mainPanel = menuPanel;
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
//Collections.sort(Database.arrayList, (o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate()));