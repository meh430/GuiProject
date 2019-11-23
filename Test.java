import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Test {
    private JPanel testPanel = new JPanel(null);

    private JLabel mainLabel = new JLabel("TEST");
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

    private ButtonGroup answerGroup1 = new ButtonGroup();

    private JTextField nameField = new JTextField();
    private JLabel nameLabel = new JLabel("Name: ");

    public Test() {
        testPanel.setPreferredSize(new Dimension(Driver.intPanelWidth, Driver.intPanelHeight));
        initializeLabels();
        initializeRadioButtons();
        initializeQuestions();
    }

    private void initializeQuestions() {
        question1Label.setSize(500, 25);
        question1Label.setLocation(15, 70);
        question1Label.setText("1) " + testQuestions[0].getQuestion());
        System.out.println(testQuestions[0].getQuestion());

        testPanel.add(question1Label);
    }

    private void initializeRadioButtons() {
        String [] strRandomAnswers1 = testQuestions[0].getAnswerChoices();
        for(int i = 0; i < 4; i++) {
            answerRadio1[i] = new JRadioButton();
            answerRadio1[i].setSize(50, 25);
            answerRadio1[i].setLocation(20 + (i*100), 100);
            answerRadio1[i].setText(strRandomAnswers1[i]);
            testPanel.add(answerRadio1[i]);
            answerGroup1.add(answerRadio1[i]);
        }

        String [] strRandomAnswers2 = testQuestions[1].getAnswerChoices();
        for(int i = 0; i < 4; i++) {
            
        }

        String [] strRandomAnswers3 = testQuestions[2].getAnswerChoices();
        for(int i = 0; i < 4; i++) {
            
        }

        String [] strRandomAnswers4 = testQuestions[3].getAnswerChoices();
        for(int i = 0; i < 4; i++) {
            
        }

        String [] strRandomAnswers5 = testQuestions[4].getAnswerChoices();
        for(int i = 0; i < 4; i++) {
            
        }
    }

    private void initializeLabels() {
        mainLabel.setSize(100,25);
        mainLabel.setLocation(10, 10);

        nameLabel.setSize(50, 25);
        nameLabel.setLocation(10, 30);

        nameField.setSize(150, 25);
        nameField.setLocation(60, 30);

        testPanel.add(mainLabel);
        testPanel.add(nameLabel);
        testPanel.add(nameField);
    }

    public JPanel getTestPanel() {
        return testPanel;
    }
}