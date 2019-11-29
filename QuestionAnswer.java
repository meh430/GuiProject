import java.util.ArrayList;

//This class is a blueprint for a question in the test module
public class QuestionAnswer {
    private String strQuestion;
    private String strAnswer;
    //A list of all the other filler choices
    private ArrayList<String> mockAnswerList = new ArrayList<>();

    public QuestionAnswer(String strQ, String strA) {
        this.strQuestion = strQ;
        this.strAnswer = strA;
        mockAnswerList.add("4.74");
        mockAnswerList.add("5.21");
        mockAnswerList.add("8.59");
        mockAnswerList.add("9.35");
        mockAnswerList.add("6.92");
        mockAnswerList.add("23.85");
        mockAnswerList.add("53.16");
        mockAnswerList.add("25.65");
        mockAnswerList.add("86.23");
        mockAnswerList.add("5.34");
        mockAnswerList.add("53.75");
        mockAnswerList.add("8.42");
        mockAnswerList.add("7.58");
        mockAnswerList.add("2.06");
        mockAnswerList.add("95.89");
        mockAnswerList.add("76.85");
        mockAnswerList.add("35.96");
        mockAnswerList.add("73.87");
        mockAnswerList.add("8.37");
        mockAnswerList.add("9.25");
        mockAnswerList.add("1.74");
        mockAnswerList.add("7.36");
        mockAnswerList.add("4.36");
        mockAnswerList.add("2.49");
        mockAnswerList.add("27.34");
        mockAnswerList.add("86.46");
        mockAnswerList.add("12.85");
        mockAnswerList.add("15.21");
        mockAnswerList.add("9.45");
        mockAnswerList.add("23.86");
        mockAnswerList.add("97.43");
        mockAnswerList.add("3.67");
        mockAnswerList.add("4.76");
    }

    public String getQuestion() {
        return strQuestion;
    }

    public String getAnswer() {
        return strAnswer;
    }

    //Returns an array of Strings with the answer and other random mock answers
    public String[] getAnswerChoices() {
        ArrayList<Integer> indexList = new ArrayList<>();
        String[] answerChoices = new String[4];
        int intRandomIndex = (int)(Math.random()*answerChoices.length);
        for(int i = 0; i < 4; i++) {
            int intRandomAnswer = (int)(Math.random()*mockAnswerList.size());
            while(indexList.contains(intRandomAnswer)) {
                intRandomAnswer = (int)(Math.random()*mockAnswerList.size());   
            }
            indexList.add(intRandomAnswer);
            answerChoices[i] = mockAnswerList.get(intRandomAnswer);
        }
        answerChoices[intRandomIndex] = strAnswer;

        return answerChoices;
    }
}