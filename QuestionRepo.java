import java.util.ArrayList;
public class QuestionRepo {
    //create user repo with alist, load() and save() and addUser() so epicccc 
    //use array lists for user storing! - name, score, time, tstamp
    //use arrays to store radiobuttons
    //iterate through to get the selected one and get its text to get it to the answer alist or array
    //check answers with questions at the end
    ArrayList<QuestionAnswer> questionList = new ArrayList<>();

    public QuestionRepo() {
        questionList.add(new QuestionAnswer("Question 1", "1"));
        questionList.add(new QuestionAnswer("Question 2", "2"));

    }

    public QuestionAnswer[] getRandomQuestions() {
        QuestionAnswer [] questions = new QuestionAnswer[5];
        ArrayList<Integer> indexList = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            int intRandomQuestion = (int)(Math.random()*questionList.size());
            while(indexList.contains(intRandomQuestion)) {
                intRandomQuestion = (int)(Math.random()*questionList.size());
            }
            indexList.add(intRandomQuestion);
            questions[i] = questionList.get(intRandomQuestion);
        }

        return questions;
    }
}