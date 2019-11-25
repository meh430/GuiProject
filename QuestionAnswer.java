//Test
//Question/answer
//qa repo - list, getAnswers, getQ
//user - score, time, timestamp
import java.util.ArrayList;
public class QuestionAnswer {
    private String strQuestion;
    private String strAnswer;
    private ArrayList<String> mockAnswerList = new ArrayList<>();

    public QuestionAnswer(String strQ, String strA) {
        this.strQuestion = strQ;
        this.strAnswer = strA;
        mockAnswerList.add("4.7");
        mockAnswerList.add("5.2");
        mockAnswerList.add("8.5");
        mockAnswerList.add("9.3");
        mockAnswerList.add("6.9");
        mockAnswerList.add("23.5");
        mockAnswerList.add("53.6");
        mockAnswerList.add("25");
        mockAnswerList.add("86");
        mockAnswerList.add("53");
    }

    public String getQuestion() {
        return strQuestion;
    }

    public String getAnswer() {
        return strAnswer;
    }

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