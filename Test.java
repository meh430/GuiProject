import java.util.Enumeration;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

//This class implements the Test screen
public class Test implements ActionListener {
    //Properties
    private Timer countTimer = new Timer(1000, this);
    private int intTime = 0;
    //Dimensions for the question labels and the radiobuttons
    private final int intQuestionWidth = 800, intQuestionHeight = 25, intRadioWidth = 75;

    private JPanel testPanel = new JPanel(null);

    private JLabel mainLabel = new JLabel("TEST");
    private JLabel timeLabel = new JLabel("Time Taken: 0s");
    private JLabel scoreLabel = new JLabel("Score: 5/5");
    private JLabel [] correctionLabels = new JLabel[5];
    private JLabel question1Label = new JLabel("Question 1");
    private JLabel question2Label = new JLabel("Question 2");
    private JLabel question3Label = new JLabel("Question 3");
    private JLabel question4Label = new JLabel("Question 4");
    private JLabel question5Label = new JLabel("Question 5");

    //An array of 5 ButtonGroups, one for each question
    private ButtonGroup [] answerGroups = new ButtonGroup[5];
    
    //An array of 4 JRadioButtons for each question
    private JRadioButton [] answerRadio1 = new JRadioButton[4];
    private JRadioButton [] answerRadio2 = new JRadioButton[4];
    private JRadioButton [] answerRadio3 = new JRadioButton[4];
    private JRadioButton [] answerRadio4 = new JRadioButton[4];
    private JRadioButton [] answerRadio5 = new JRadioButton[4];

    //An array of 5 JLabels, one for each question
    private JLabel [] questionLabels = new JLabel[5];

    //Initialize array of questions with random ones
    private QuestionAnswer [] testQuestions = new QuestionRepo().getRandomQuestions();

    private String [] strActualAnswers = new String[5];

    private JButton backButton = new JButton("<- BACK");
    private JButton submitButton = new JButton("SUBMIT");

    private JTextField nameField = new JTextField();
    private JLabel nameLabel = new JLabel("Name: ");

    private UserRepo users = new UserRepo();

    //Methods
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            //Switch back to the Main Menu when back button is pressed
            Utility.changePanel(Driver.menuScreen.getMenuPanel());
        } else if(e.getSource() == submitButton) {
            //User cannot press submit again
            submitButton.setEnabled(false);
            String strName = nameField.getText();
            if(strName == null || strName.equalsIgnoreCase("")) {
                //If user did not enter name, get a random one
                strName = User.getRandomName();
            }
            int intScore = checkAnswers();

            scoreLabel.setVisible(true);
            scoreLabel.setText("Score: " + intScore + "/5");

            //Add a new user with the given name, score, time, and time stamp
            users.addUser(new User(strName, intScore, intTime, new SimpleDateFormat("MM-dd-yyyy 'at' hh:mm:ss", Locale.CANADA).format(new Date())));
            //Save users to the text file
            users.saveUsers();
        }

        if(e.getSource() == countTimer) {
            //Increment time every second
            intTime++;
            timeLabel.setText("Time Taken: " + intTime + "s");
        }
    }

    //Sets locations and sizes for JButtons
    private void initializeButtons() {
        submitButton.setSize(300, 50);
        submitButton.setLocation(35, 395);
        submitButton.addActionListener(this);
        Utility.setButtonStyle(submitButton, 24);
        
        backButton.setSize(300, 50);
        backButton.setLocation(35, 455);
        backButton.addActionListener(this);
        Utility.setButtonStyle(backButton, 24);

        testPanel.add(backButton);
        testPanel.add(submitButton);
    }

    //Sets locations and sizes for question labels and sets the text of each label
    private void initializeQuestions() {
        for(int i = 0; i < 5; i++) {
            questionLabels[i] = new JLabel((i+1) + ") " + testQuestions[i].getQuestion());
            questionLabels[i].setSize(intQuestionWidth, intQuestionHeight);
            //Space the questions 60 pixels apart vertically
            questionLabels[i].setLocation(15, 70 + (i*60));
            Utility.setLabelStyle(questionLabels[i], 14);
            testPanel.add(questionLabels[i]);
        }
    }

    //Sets locations and sizes for all the JRadioButtons and sets their text
    private void initializeRadioButtons() {
        //Instantiate the five button groups
        for(int i = 0; i < 5; i++) {
            answerGroups[i] = new ButtonGroup();
        }

        String [] strAnswerChoices1 = testQuestions[0].getAnswerChoices();
        //Initialize radiobuttons for question 1
        for(int i = 0; i < 4; i++) {
            answerRadio1[i] = new JRadioButton();
            answerRadio1[i].setSize(intRadioWidth, intQuestionHeight);
            answerRadio1[i].setLocation(20 + (i*100), 100);
            answerRadio1[i].setText(strAnswerChoices1[i]);
            setRadioButtonStyle(answerRadio1[i]);
            testPanel.add(answerRadio1[i]);
            answerGroups[0].add(answerRadio1[i]);
        }

        String [] strAnswerChoices2 = testQuestions[1].getAnswerChoices();
        //Initialize radiobuttons for question 2
        for(int i = 0; i < 4; i++) {
            answerRadio2[i] = new JRadioButton();
            answerRadio2[i].setSize(intRadioWidth, intQuestionHeight);
            answerRadio2[i].setLocation(20 + (i*100), 160);
            answerRadio2[i].setText(strAnswerChoices2[i]);
            setRadioButtonStyle(answerRadio2[i]);
            testPanel.add(answerRadio2[i]);
            answerGroups[1].add(answerRadio2[i]);
        }

        String [] strAnswerChoices3 = testQuestions[2].getAnswerChoices();
        //Initialize radiobuttons for question 3
        for(int i = 0; i < 4; i++) {
            answerRadio3[i] = new JRadioButton();
            answerRadio3[i].setSize(intRadioWidth, intQuestionHeight);
            answerRadio3[i].setLocation(20 + (i*100), 220);
            answerRadio3[i].setText(strAnswerChoices3[i]);
            setRadioButtonStyle(answerRadio3[i]);
            testPanel.add(answerRadio3[i]);
            answerGroups[2].add(answerRadio3[i]);
        }

        String [] strAnswerChoices4 = testQuestions[3].getAnswerChoices();
        //Initialize radiobuttons for question 4
        for(int i = 0; i < 4; i++) {
            answerRadio4[i] = new JRadioButton();
            answerRadio4[i].setSize(intRadioWidth, intQuestionHeight);
            answerRadio4[i].setLocation(20 + (i*100), 280);
            answerRadio4[i].setText(strAnswerChoices4[i]);
            setRadioButtonStyle(answerRadio4[i]);
            testPanel.add(answerRadio4[i]);
            answerGroups[3].add(answerRadio4[i]);
        }

        String [] strAnswerChoices5 = testQuestions[4].getAnswerChoices();
        //Initialize radiobuttons for question 5
        for(int i = 0; i < 4; i++) {
            answerRadio5[i] = new JRadioButton();
            answerRadio5[i].setSize(intRadioWidth, intQuestionHeight);
            answerRadio5[i].setLocation(20 + (i*100), 340);
            answerRadio5[i].setText(strAnswerChoices5[i]);
            setRadioButtonStyle(answerRadio5[i]);
            testPanel.add(answerRadio5[i]);
            answerGroups[4].add(answerRadio5[i]);
        }

        //Select the first radiobutton in each group
        answerGroups[0].setSelected(answerRadio1[0].getModel(), true);
        answerGroups[1].setSelected(answerRadio2[0].getModel(), true);
        answerGroups[2].setSelected(answerRadio3[0].getModel(), true);
        answerGroups[3].setSelected(answerRadio4[0].getModel(), true);
        answerGroups[4].setSelected(answerRadio5[0].getModel(), true);
    }

    //Sets locations and sizes for all the JLabels
    private void initializeLabels() {
        mainLabel.setSize(100,25);
        mainLabel.setLocation(380, 30);
        Utility.setLabelStyle(mainLabel, 32);

        nameLabel.setSize(50, 25);
        nameLabel.setLocation(10, 30);
        Utility.setLabelStyle(nameLabel, 14);

        nameField.setSize(150, 25);
        nameField.setLocation(60, 30);

        timeLabel.setSize(150, 25);
        timeLabel.setLocation(700, 10);
        Utility.setLabelStyle(timeLabel, 16);

        scoreLabel.setVisible(false);
        scoreLabel.setSize(150, 25);
        scoreLabel.setLocation(700, 30);
        Utility.setLabelStyle(scoreLabel, 16);

        testPanel.add(mainLabel);
        testPanel.add(nameLabel);
        testPanel.add(nameField);
        testPanel.add(timeLabel);
        testPanel.add(scoreLabel);
    }

    //Checks how many the user got correct
    private int checkAnswers() {
        countTimer.stop();
        int intScore = 0;

        for(int i = 0; i < 5; i++) {
            String strUserAnswer = getButtonText(answerGroups[i]);
            correctionLabels[i] = new JLabel();
            correctionLabels[i].setSize(250, 20);
            //Space the correction labels 60 pixels appart vertically
            correctionLabels[i].setLocation(650, 70 + (i*60));
            Utility.setLabelStyle(correctionLabels[i], 16);
            //If chosen answer is equal to the actual answer, increase score
            if(strUserAnswer.equalsIgnoreCase(strActualAnswers[i])) {
                intScore++;
                correctionLabels[i].setForeground(Color.GREEN);
                correctionLabels[i].setText("Correct!");
            } else {
                correctionLabels[i].setForeground(Color.RED);
                correctionLabels[i].setText("Wrong! Answer is " + strActualAnswers[i]);
            }
            testPanel.add(correctionLabels[i]);
        }

        return intScore;
    }

    //Gets the text from the selected radiobutton
    private String getButtonText(ButtonGroup answerGroup) {
        //Enumerate through radiobuttons in a ButtonGroup
        for (Enumeration radioButtons = answerGroup.getElements(); radioButtons.hasMoreElements();) {
            Object radioButton = radioButtons.nextElement();
            //Cast Object to JRadioButton to check and see if it is selected
            if (((JRadioButton)radioButton).isSelected()) {
                return ((JRadioButton)radioButton).getText();
            }
        }
        return null;
    }

    //Sets the font, text color, and background color for radiobuttons
    private void setRadioButtonStyle(JRadioButton radioButton) {
        radioButton.setBackground(Color.BLACK);
        radioButton.setForeground(Color.WHITE);
        radioButton.setFont(Utility.getFont().deriveFont(Font.PLAIN, 14));
    }

    public JPanel getTestPanel() {
        return testPanel;
    }

    //Constructor
    public Test() {
        testPanel.setPreferredSize(Utility.panelDimensions);
        testPanel.setBackground(Color.BLACK);
        initializeLabels();
        initializeRadioButtons();
        initializeQuestions();
        initializeButtons();
        countTimer.start();

        for(int i = 0; i < 5; i++) {
            //Initialize the answer key array
            strActualAnswers[i] = testQuestions[i].getAnswer();
        }
    }
}