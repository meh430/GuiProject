import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

//This class implements the Help screen
public class Help implements ActionListener {
    //Properties
    private JPanel helpPanel = new JPanel(null);
    private JTextArea helpArea = new JTextArea();
    private JScrollPane helpScroll = new JScrollPane(helpArea);
    private JButton backButton = new JButton("<- BACK");

    //Methods
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            //Switch back to the Main Menu when back button is pressed
            Utility.changePanel(Driver.menuScreen.getMenuPanel());
        }
    }
    
    //Read help from text file and print it to the JTextArea
    private void printGuide() {
        BufferedReader reader = Utility.getReader("help.txt");
        String strContents = Utility.readLine(reader);
        while(strContents!=null) {
            helpArea.append(strContents + "\n");
            strContents = Utility.readLine(reader);
        }
        try {
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
            helpArea.append("\nHuhhh, looks like something went wrong reading the help file");
        }
    }

    public JPanel getHelpPanel() {
        return helpPanel;
    }

    //Constructor
    //Initialize the panel and all the JComponents
    public Help() {
        helpPanel.setPreferredSize(Utility.panelDimensions);
        helpPanel.setBackground(Color.BLACK);
        helpArea.setEditable(false);
        helpArea.setBackground(Color.BLACK);
        helpArea.setForeground(Color.WHITE);
        helpArea.setFont(Utility.getFont().deriveFont(Font.PLAIN, 24));
        backButton.setSize(100, 20);
        backButton.setLocation(0,0);
        Utility.setButtonStyle(backButton, 14);
        backButton.addActionListener(this);
        helpScroll.setSize(960, 520);
        helpScroll.setLocation(0, 20);
        helpPanel.add(backButton);
        helpPanel.add(helpScroll);
        printGuide();
    }
}