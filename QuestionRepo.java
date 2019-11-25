import java.util.ArrayList;
public class QuestionRepo {
    ArrayList<QuestionAnswer> questionList = new ArrayList<>();

    public QuestionRepo() {
        questionList.add(new QuestionAnswer("A 4kg hanging mass is attached to a 12kg cart. What is the acceleration of the system?", "1"));
        questionList.add(new QuestionAnswer("A 20kg hanging mass is attached to a 23kg cart. What is the acceleration of the system?", "2"));
        questionList.add(new QuestionAnswer("A 3kg hanging mass is attached to a 8kg cart. What is the acceleration of the system?", "3"));
        questionList.add(new QuestionAnswer("A 25kg hanging mass is attached to a 3kg cart. What is the acceleration of the system?", "4"));
        questionList.add(new QuestionAnswer("A 23kg hanging mass is attached to a 13kg cart. What is the tension of the system?", "5"));
        questionList.add(new QuestionAnswer("A 17kg hanging mass is attached to a 21kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 15kg hanging mass is attached to a 8kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 6kg hanging mass is attached to a 9kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 11kg hanging mass is attached to a 22kg cart. What is the tension of the system?", "6"));
        questionList.add(new QuestionAnswer("A 24kg hanging mass is attached to a 8kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 20kg hanging mass is attached to a 21kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 22kg hanging mass is attached to a 2kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 16kg hanging mass is attached to a 14kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 21kg hanging mass is attached to a 1kg cart. What is the tension of the system?", "6"));
        questionList.add(new QuestionAnswer("A 5kg hanging mass is attached to a 5kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 12kg hanging mass is attached to a 18kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 8kg hanging mass is attached to a 21kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 10kg hanging mass is attached to a 10kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 16kg hanging mass is attached to a 21kg cart. What is the tension of the system?", "6"));
        questionList.add(new QuestionAnswer("A 17kg hanging mass is attached to a 25kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 4kg hanging mass is attached to a 10kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 13kg hanging mass is attached to a 14kg cart. What is the acceleration of the system?", "6"));
        questionList.add(new QuestionAnswer("A 18kg hanging mass is attached to a 11kg cart. What is the acceleration of the system?", "6"));
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