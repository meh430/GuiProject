import java.util.Enumeration;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Test implements ActionListener {
    private Timer countTimer = new Timer(1000, this);
    private int intTime = 0;
    private final int intQuestionWidth = 500, intQuestionHeight = 25, intRadioWidth = 50;

    private JPanel testPanel = new JPanel(null);

    private JLabel mainLabel = new JLabel("TEST");
    private JLabel timeLabel = new JLabel("Time Taken: 0s");
    private JLabel scoreLabel = new JLabel("Score: 5/5");
    private JLabel question1Label = new JLabel("Question 1");
    private JLabel question2Label = new JLabel("Question 2");
    private JLabel question3Label = new JLabel("Question 3");
    private JLabel question4Label = new JLabel("Question 4");
    private JLabel question5Label = new JLabel("Question 5");

    private JRadioButton [] answerRadio1 = new JRadioButton[4];
    private JRadioButton [] answerRadio2 = new JRadioButton[4];
    private JRadioButton [] answerRadio3 = new JRadioButton[4];
    private JRadioButton [] answerRadio4 = new JRadioButton[4];
    private JRadioButton [] answerRadio5 = new JRadioButton[4];

    private QuestionAnswer [] testQuestions = new QuestionRepo().getRandomQuestions();
    private String [] strActualAnswers = new String[5];

    private ButtonGroup [] answerGroups = new ButtonGroup[5];

    private JButton backButton = new JButton("<- BACK");
    private JButton submitButton = new JButton("SUBMIT");

    private JTextField nameField = new JTextField();
    private JLabel nameLabel = new JLabel("Name: ");

    private UserRepo users = new UserRepo();

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            Driver.changePanel(Driver.menuScreen.getMenuPanel());
        } else if(e.getSource() == submitButton) {
            submitButton.setEnabled(false);
            String strName = nameField.getText();
            if(strName == null || strName.equalsIgnoreCase("")) {
                strName = User.getRandomName();
            }
            int intScore = checkAnswers();
            scoreLabel.setVisible(true);
            scoreLabel.setText("Score: " + intScore + "/5");
            users.addUser(new User(strName, intScore, intTime + "", new SimpleDateFormat("MM-dd-yyyy 'at' hh:mm:ss", Locale.CANADA).format(new Date())));
            users.saveUsers();
        }

        if(e.getSource() == countTimer) {
            intTime++;
            timeLabel.setText("Time Taken: " + intTime + "s");
        }
    }

    public Test() {
        testPanel.setPreferredSize(new Dimension(Driver.intPanelWidth, Driver.intPanelHeight));
        initializeLabels();
        initializeRadioButtons();
        initializeQuestions();
        initializeButtons();
        countTimer.start();

        for(int i = 0; i < 5; i++) {
            strActualAnswers[i] = testQuestions[i].getAnswer();
        }
    }

    private void initializeButtons() {
        submitButton.setSize(300, 50);
        submitButton.setLocation(35, 395);
        submitButton.addActionListener(this);
        
        backButton.setSize(300, 50);
        backButton.setLocation(35, 455);
        backButton.addActionListener(this);

        testPanel.add(backButton);
        testPanel.add(submitButton);
    }

    private void initializeQuestions() {
        question1Label.setSize(intQuestionWidth, intQuestionHeight);
        question1Label.setLocation(15, 70);
        question1Label.setText("1) " + testQuestions[0].getQuestion());
        testPanel.add(question1Label);

        question2Label.setSize(intQuestionWidth, intQuestionHeight);
        question2Label.setLocation(15, 130);
        question2Label.setText("2) " + testQuestions[1].getQuestion());
        testPanel.add(question2Label);

        question3Label.setSize(intQuestionWidth, intQuestionHeight);
        question3Label.setLocation(15, 190);
        question3Label.setText("3) " + testQuestions[2].getQuestion());
        testPanel.add(question3Label);

        question4Label.setSize(intQuestionWidth, intQuestionHeight);
        question4Label.setLocation(15, 250);
        question4Label.setText("4) " + testQuestions[3].getQuestion());
        testPanel.add(question4Label);

        question5Label.setSize(intQuestionWidth, intQuestionHeight);
        question5Label.setLocation(15, 310);
        question5Label.setText("5) " + testQuestions[4].getQuestion());
        testPanel.add(question5Label);
    }

    private void initializeRadioButtons() {
        String [] strRandomAnswers1 = testQuestions[0].getAnswerChoices();

        for(int i = 0; i < 5; i++) {
            answerGroups[i] = new ButtonGroup();
        }

        for(int i = 0; i < 4; i++) {
            answerRadio1[i] = new JRadioButton();
            answerRadio1[i].setSize(intRadioWidth, intQuestionHeight);
            answerRadio1[i].setLocation(20 + (i*100), 100);
            answerRadio1[i].setText(strRandomAnswers1[i]);
            testPanel.add(answerRadio1[i]);
            answerGroups[0].add(answerRadio1[i]);
        }

        String [] strRandomAnswers2 = testQuestions[1].getAnswerChoices();
        for(int i = 0; i < 4; i++) {
            answerRadio2[i] = new JRadioButton();
            answerRadio2[i].setSize(intRadioWidth, intQuestionHeight);
            answerRadio2[i].setLocation(20 + (i*100), 160);
            answerRadio2[i].setText(strRandomAnswers2[i]);
            testPanel.add(answerRadio2[i]);
            answerGroups[1].add(answerRadio2[i]);
        }

        String [] strRandomAnswers3 = testQuestions[2].getAnswerChoices();
        for(int i = 0; i < 4; i++) {
            answerRadio3[i] = new JRadioButton();
            answerRadio3[i].setSize(intRadioWidth, intQuestionHeight);
            answerRadio3[i].setLocation(20 + (i*100), 220);
            answerRadio3[i].setText(strRandomAnswers3[i]);
            testPanel.add(answerRadio3[i]);
            answerGroups[2].add(answerRadio3[i]);
        }

        String [] strRandomAnswers4 = testQuestions[3].getAnswerChoices();
        for(int i = 0; i < 4; i++) {
            answerRadio4[i] = new JRadioButton();
            answerRadio4[i].setSize(intRadioWidth, intQuestionHeight);
            answerRadio4[i].setLocation(20 + (i*100), 280);
            answerRadio4[i].setText(strRandomAnswers4[i]);
            testPanel.add(answerRadio4[i]);
            answerGroups[3].add(answerRadio4[i]);
        }

        String [] strRandomAnswers5 = testQuestions[4].getAnswerChoices();
        for(int i = 0; i < 4; i++) {
            answerRadio5[i] = new JRadioButton();
            answerRadio5[i].setSize(intRadioWidth, intQuestionHeight);
            answerRadio5[i].setLocation(20 + (i*100), 340);
            answerRadio5[i].setText(strRandomAnswers5[i]);
            testPanel.add(answerRadio5[i]);
            answerGroups[4].add(answerRadio5[i]);
        }

        answerGroups[0].setSelected(answerRadio1[0].getModel(), true);
        answerGroups[1].setSelected(answerRadio2[0].getModel(), true);
        answerGroups[2].setSelected(answerRadio3[0].getModel(), true);
        answerGroups[3].setSelected(answerRadio4[0].getModel(), true);
        answerGroups[4].setSelected(answerRadio5[0].getModel(), true);
    }

    private void initializeLabels() {
        mainLabel.setSize(100,25);
        mainLabel.setLocation(10, 10);

        nameLabel.setSize(50, 25);
        nameLabel.setLocation(10, 30);

        nameField.setSize(150, 25);
        nameField.setLocation(60, 30);

        timeLabel.setSize(100, 25);
        timeLabel.setLocation(600, 10);

        scoreLabel.setVisible(false);
        scoreLabel.setSize(100, 25);
        scoreLabel.setLocation(600, 30);

        testPanel.add(mainLabel);
        testPanel.add(nameLabel);
        testPanel.add(nameField);
        testPanel.add(timeLabel);
        testPanel.add(scoreLabel);
    }

    private int checkAnswers() {
        countTimer.stop();
        int intScore = 0;

        String [] strUserAnswers = new String[5];

        for(int i = 0; i < 5; i++) {
            strUserAnswers[i] = getButtonText(answerGroups[i]);
            if(strUserAnswers[i].equalsIgnoreCase(strActualAnswers[i])) {
                intScore++;
            }
        }

        return intScore;
    }

    private String getButtonText(ButtonGroup answerGroup) {
    for (Enumeration radioButtons = answerGroup.getElements(); radioButtons.hasMoreElements();) {
        Object radioButton = radioButtons.nextElement();
        if (((JRadioButton)radioButton).isSelected()) {
            return ((JRadioButton)radioButton).getText();
        }
    }

    return null;
    }

    public JPanel getTestPanel() {
        return testPanel;
    }
}