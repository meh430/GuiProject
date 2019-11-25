import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class Scores implements ActionListener {
    private ArrayList<User> userList = new UserRepo().getUserList();
    private JPanel scorePanel = new JPanel(null);
    
    private JButton backButton = new JButton("<- BACK");
    
    private JMenuBar menuBar = new JMenuBar();
    private JMenu sortMenu = new JMenu("Sort");
    
    private JMenuItem sortScoreAsc = new JMenuItem("Score ASC");
    private JMenuItem sortScoreDesc = new JMenuItem("Score DESC");
    private JMenuItem sortTimeAsc = new JMenuItem("Time ASC");
    private JMenuItem sortTimeDesc = new JMenuItem("Time DESC");

    private JTextArea scoreArea = new JTextArea();
    private JScrollPane scoreScroll = new JScrollPane(scoreArea);

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            Driver.changePanel(Driver.menuScreen.getMenuPanel());
        } else if(e.getSource() == sortScoreAsc) {
            Collections.sort(userList, (user1, user2) -> Integer.toString(user1.getScore()).compareTo(Integer.toString(user2.getScore())));
        } else if(e.getSource() == sortScoreDesc) {
            Collections.sort(userList, (user1, user2) -> Integer.toString(user2.getScore()).compareTo(Integer.toString(user1.getScore())));
        } else if(e.getSource() == sortTimeAsc) {
            Collections.sort(userList, (user1, user2) -> Integer.toString(user1.getTimeTaken()).compareTo(Integer.toString(user2.getTimeTaken())));
        } else if(e.getSource() == sortTimeDesc) {
            Collections.sort(userList, (user1, user2) -> Integer.toString(user2.getTimeTaken()).compareTo(Integer.toString(user1.getTimeTaken())));
        }
        printScores();
    }

    public Scores() {
        scorePanel.setPreferredSize(new Dimension(Driver.intPanelWidth, Driver.intPanelHeight));
        initializeComponents();
        printScores();
    }

    private void printScores() {
        scoreArea.setText("");
        scoreArea.append("Scores: \n\n");
        for(User user:userList) {
            scoreArea.append("************************************************\n");
            scoreArea.append("Name: " + user.getName() + "\n");
            scoreArea.append("Score: " + user.getScore() + "/5\n");
            scoreArea.append("Finish Time: " + user.getTimeTaken() + "\n");
            scoreArea.append("Time Stamp: " + user.getTimeStamp() + "\n\n");
        }
    }

    private void initializeComponents() {
        backButton.setSize(100, 20);
        backButton.setLocation(0,0);
        backButton.addActionListener(this);

        scoreArea.setEditable(false);
        scoreScroll.setSize(960, 520);
        scoreScroll.setLocation(0, 20);

        menuBar.setSize(860, 20);
        menuBar.setLocation(100, 0);

        sortMenu.add(sortScoreAsc);
        sortScoreAsc.addActionListener(this);
        sortMenu.add(sortScoreDesc);
        sortScoreDesc.addActionListener(this);
        sortMenu.add(sortTimeAsc);
        sortTimeAsc.addActionListener(this);
        sortMenu.add(sortTimeDesc);
        sortTimeDesc.addActionListener(this);

        menuBar.add(sortMenu);

        scorePanel.add(backButton);
        scorePanel.add(menuBar);
        scorePanel.add(scoreScroll);
    }

    public JPanel getScorePanel() {
        return scorePanel;
    }
}