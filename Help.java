import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class Help implements ActionListener {
    private JPanel helpPanel = new JPanel(null);
    private JTextArea helpArea = new JTextArea();
    private JScrollPane helpScroll = new JScrollPane(helpArea);
    private JButton backButton = new JButton("<- BACK");

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            Driver.changePanel(Driver.menuScreen.getMenuPanel());
        }
    }

    public Help() {
        helpPanel.setPreferredSize(new Dimension(Driver.intPanelWidth, Driver.intPanelHeight));
        helpPanel.setBackground(Color.BLACK);
        helpArea.setEditable(false);
        helpArea.setBackground(Color.BLACK);
        helpArea.setForeground(Color.WHITE);
        helpArea.setFont(Driver.getFont().deriveFont(Font.PLAIN, 24));
        backButton.setSize(100, 20);
        backButton.setLocation(0,0);
        MainMenu.setButtonStyle(backButton, 14);
        backButton.addActionListener(this);
        helpScroll.setSize(960, 520);
        helpScroll.setLocation(0, 20);
        helpPanel.add(backButton);
        helpPanel.add(helpScroll);
        printGuide();
    }

    private void printGuide() {
        BufferedReader reader = Driver.getReader("help.txt");
        String strContents = Driver.readLine(reader);
        while(strContents!=null) {
            helpArea.append(strContents + "\n");
            strContents = Driver.readLine(reader);
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
}