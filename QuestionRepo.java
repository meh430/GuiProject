import java.util.ArrayList;
public class QuestionRepo {
    ArrayList<QuestionAnswer> questionList = new ArrayList<>();

    public QuestionRepo() {
        questionList.add(new QuestionAnswer("A 4kg hanging mass is attached to a 12kg cart. What is the acceleration of the system?", "2.45"));
        questionList.add(new QuestionAnswer("A 20kg hanging mass is attached to a 23kg cart. What is the tension of the rope?", "104.84"));
        questionList.add(new QuestionAnswer("A 3kg hanging mass is attached to a 8kg cart. What is the acceleration of the system?", "2.67"));
        questionList.add(new QuestionAnswer("A 25kg hanging mass is attached to a 3kg cart. What is the acceleration of the system?", "8.75"));
        questionList.add(new QuestionAnswer("A 23kg hanging mass is attached to a 13kg cart. What is the tension of the rope?", "81.39"));
        questionList.add(new QuestionAnswer("A 17kg hanging mass is attached to a 21kg cart. What is the acceleration of the system?", "4.38"));
        questionList.add(new QuestionAnswer("A 15kg hanging mass is attached to a 8kg cart. What is the acceleration of the system?", "6.39"));
        questionList.add(new QuestionAnswer("A 6kg hanging mass is attached to a 9kg cart. What is the acceleration of the system?", "3.92"));
        questionList.add(new QuestionAnswer("A 11kg hanging mass is attached to a 22kg cart. What is the tension of the rope?", "71.87"));
        questionList.add(new QuestionAnswer("A 24kg hanging mass is attached to a 8kg cart. What is the acceleration of the system?", "7.35"));
        questionList.add(new QuestionAnswer("A 20kg hanging mass is attached to a 21kg cart. What is the acceleration of the system?", "4.78"));
        questionList.add(new QuestionAnswer("A 22kg hanging mass is attached to a 2kg cart. What is the acceleration of the system?", "8.98"));
        questionList.add(new QuestionAnswer("A 16kg hanging mass is attached to a 14kg cart. What is the acceleration of the system?", "5.23"));
        questionList.add(new QuestionAnswer("A 1kg hanging mass is attached to a 21kg cart. What is the tension of the rope?", "9.35"));
        questionList.add(new QuestionAnswer("A 5kg hanging mass is attached to a 5kg cart. What is the acceleration of the system?", "4.9"));
        questionList.add(new QuestionAnswer("A 12kg hanging mass is attached to a 18kg cart. What is the acceleration of the system?", "3.92"));
        questionList.add(new QuestionAnswer("A 8kg hanging mass is attached to a 21kg cart. What is the acceleration of the system?", "2.7"));
        questionList.add(new QuestionAnswer("A 10kg hanging mass is attached to a 10kg cart. What is the acceleration of the system?", "4.9"));
        questionList.add(new QuestionAnswer("A 16kg hanging mass is attached to a 21kg cart. What is the tension of the rope?", "88.99"));
        questionList.add(new QuestionAnswer("A 17kg hanging mass is attached to a 25kg cart. What is the acceleration of the system?", "3.97"));
        questionList.add(new QuestionAnswer("A 4kg hanging mass is attached to a 10kg cart. What is the acceleration of the system?", "2.8"));
        questionList.add(new QuestionAnswer("A 13kg hanging mass is attached to a 14kg cart. What is the acceleration of the system?", "4.72"));
        questionList.add(new QuestionAnswer("A 18kg hanging mass is attached to a 11kg cart. What is the acceleration of the system?", "6.08"));
        questionList.add(new QuestionAnswer("The force on an object is 112N and its mass is 6kg. What is the acceleration?", "18.67"));
        questionList.add(new QuestionAnswer("The acceleration of an object is 8.43 m/s^2 and its mass is 12.8kg. What is the net force?", "107.9"));
        questionList.add(new QuestionAnswer("The force on an object is 87N and its acceleration is 4.2 m/s^2. What is its mass?", "20.7"));
        questionList.add(new QuestionAnswer("The force on an object is 531N and its mass is 92kg. What is the acceleration?", "4.68"));
        questionList.add(new QuestionAnswer("The acceleration of an object is 6.31 m/s^2 and its mass is 17.2kg. What is the net force?", "108.5"));
        questionList.add(new QuestionAnswer("The force on an object is 15N and its acceleration is 12 m/s^2. What is its mass?", "1.25"));
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