import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MainMenu implements ActionListener {
    public static JFrame frame;// = new JFrame("ACCELERATION");

    private final int intButtWidth = 300, intButtLength = 50;
    private JPanel menuPanel = new JPanel();
    private JLabel titleLabel = new JLabel("ACCELERATION");

    private JButton startButton = new JButton("START");
    private JButton testButton = new JButton("TEST");
    private JButton helpButton = new JButton("HELP");
    private JButton scoreButton = new JButton("SCORES");
    private JButton aboutButton = new JButton("ABOUT");

    //private Animation anime = new Animation();

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
            Driver.changePanel(new MainMenu().getMenuPanel());
        } else if(e.getSource() == scoreButton) {
            System.out.println("SCORE");
        } else if(e.getSource() == aboutButton) {
            System.out.println("ABOUT");
        }
    }

    public MainMenu() {
        menuPanel.setPreferredSize(new Dimension(Driver.intPanelWidth, Driver.intPanelHeight));
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
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }
}
//Collections.sort(Database.arrayList, (o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate()));