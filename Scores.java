import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.Collections;

//This class implements the Score display screen
public class Scores implements ActionListener {
    //Properties
    private UserRepo users = new UserRepo();
    //Get all the users loaded in from the text file
    private ArrayList<User> userList = users.getUserList();

    private JPanel scorePanel = new JPanel(null);
    private JButton backButton = new JButton("<- BACK");
    private JTextArea scoreArea = new JTextArea();
    private JScrollPane scoreScroll = new JScrollPane(scoreArea);

    private JMenuBar menuBar = new JMenuBar();
    private JMenu sortMenu = new JMenu("Sort");
    private JMenuItem scoreAscItem = new JMenuItem("Score ASC");
    private JMenuItem scoreDescItem = new JMenuItem("Score DESC");
    private JMenuItem clearScoresItem = new JMenuItem("Clear Scores");

    //Methods
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            //Switch back to the Main Menu when back button is pressed
            Utility.changePanel(Driver.menuScreen.getMenuPanel());
        } else if(e.getSource() == scoreAscItem) {
            //Sort the list of users in ascending order according to their score
            Collections.sort(userList, (user1, user2) -> Integer.toString(user1.getScore()).compareTo(Integer.toString(user2.getScore())));
        } else if(e.getSource() == scoreDescItem) {
            //Sort the list of users in descending order according to their score
            Collections.sort(userList, (user1, user2) -> Integer.toString(user2.getScore()).compareTo(Integer.toString(user1.getScore())));
        } else if(e.getSource() == clearScoresItem) {
            userList.clear();
            users.clearUsers();
        }
        printScores();
    }

    //Prints user information from the list to the text area
    private void printScores() {
        scoreArea.setText("");
        scoreArea.append(" Scores: \n\n");
        for(User user:userList) {
            scoreArea.append("**************************************************************************************************************************************\n");
            scoreArea.append(" Name: " + user.getName() + "\n");
            scoreArea.append(" Score: " + user.getScore() + "/5\n");
            scoreArea.append(" Finish Time: " + user.getTimeTaken() + "s\n");
            scoreArea.append(" Time Stamp: " + user.getTimeStamp() + "\n\n");
        }
    }

    //Sets locations and sizes for all of the JComponents
    private void initializeComponents() {
        backButton.setSize(100, 20);
        backButton.setLocation(0,0);
        backButton.addActionListener(this);
        Utility.setButtonStyle(backButton, 14);

        scoreArea.setEditable(false);
        scoreArea.setFont(Utility.getFont().deriveFont(Font.PLAIN, 16));
        scoreArea.setBackground(Color.BLACK);
        scoreArea.setForeground(Color.WHITE);
        scoreScroll.setSize(960, 520);
        scoreScroll.setLocation(0, 20);

        menuBar.setSize(860, 20);
        menuBar.setLocation(100, 0);

        sortMenu.add(scoreAscItem);
        scoreAscItem.addActionListener(this);
        sortMenu.add(scoreDescItem);
        scoreDescItem.addActionListener(this);
        sortMenu.add(clearScoresItem);
        clearScoresItem.addActionListener(this);

        menuBar.add(sortMenu);

        scorePanel.add(backButton);
        scorePanel.add(menuBar);
        scorePanel.add(scoreScroll);
    }

    public JPanel getScorePanel() {
        return scorePanel;
    }
    
    //Constructor
    public Scores() {
        scorePanel.setPreferredSize(Utility.panelDimensions);
        initializeComponents();
        printScores();
    }
}