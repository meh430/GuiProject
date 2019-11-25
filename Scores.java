import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Scores implements ActionListener {
    private JPanel scorePanel = new JPanel(null);
    
    private JButton backButton = new JButton();
    
    private JMenuBar menuBar = new JMenuBar();
    private JMenu sortMenu = new JMenu();
    
    private JMenuItem sortScoreAsc = new JMenuItem();
    private JMenuItem sortScoreDesc = new JMenuItem();
    private JMenuItem sortTimeAsc = new JMenuItem();
    private JMenuItem sortTimeDesc = new JMenuItem();

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            Driver.changePanel(Driver.menuScreen.getMenuPanel());
        }
    }

    public Scores() {

    }
}