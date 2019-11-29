import java.util.ArrayList;
//This class stores some Questions and Answers used for the test module
public class QuestionRepo {
    ArrayList<QuestionAnswer> questionList = new ArrayList<>();

    //Add questions and answers to the ArrayList
    public QuestionRepo() {
        questionList.add(new QuestionAnswer("A 4kg hanging mass is attached to a 12kg cart. What is the acceleration of the system in m/s^2?", "2.45"));
        questionList.add(new QuestionAnswer("A 20kg hanging mass is attached to a 23kg cart. What is the tension of the rope in N?", "104.84"));
        questionList.add(new QuestionAnswer("A 3kg hanging mass is attached to a 8kg cart. What is the acceleration of the system in m/s^2?", "2.67"));
        questionList.add(new QuestionAnswer("A 25kg hanging mass is attached to a 3kg cart. What is the acceleration of the system in m/s^2?", "8.75"));
        questionList.add(new QuestionAnswer("A 23kg hanging mass is attached to a 13kg cart. What is the tension of the rope in N?", "81.39"));
        questionList.add(new QuestionAnswer("A 17kg hanging mass is attached to a 21kg cart. What is the acceleration of the system in m/s^2?", "4.38"));
        questionList.add(new QuestionAnswer("A 15kg hanging mass is attached to a 8kg cart. What is the acceleration of the system in m/s^2?", "6.39"));
        questionList.add(new QuestionAnswer("A 6kg hanging mass is attached to a 9kg cart. What is the acceleration of the system in m/s^2?", "3.92"));
        questionList.add(new QuestionAnswer("A 11kg hanging mass is attached to a 22kg cart. What is the tension of the rope in N?", "71.87"));
        questionList.add(new QuestionAnswer("A 24kg hanging mass is attached to a 8kg cart. What is the acceleration of the system in m/s^2?", "7.35"));
        questionList.add(new QuestionAnswer("A 20kg hanging mass is attached to a 21kg cart. What is the acceleration of the system in m/s^2?", "4.78"));
        questionList.add(new QuestionAnswer("A 22kg hanging mass is attached to a 2kg cart. What is the acceleration of the system in m/s^2?", "8.98"));
        questionList.add(new QuestionAnswer("A 16kg hanging mass is attached to a 14kg cart. What is the acceleration of the system in m/s^2?", "5.23"));
        questionList.add(new QuestionAnswer("A 1kg hanging mass is attached to a 21kg cart. What is the tension of the rope in N?", "9.35"));
        questionList.add(new QuestionAnswer("A 5kg hanging mass is attached to a 5kg cart. What is the acceleration of the system in m/s^2?", "4.9"));
        questionList.add(new QuestionAnswer("A 12kg hanging mass is attached to a 18kg cart. What is the acceleration of the system in m/s^2?", "3.92"));
        questionList.add(new QuestionAnswer("A 8kg hanging mass is attached to a 21kg cart. What is the acceleration of the system in m/s^2?", "2.7"));
        questionList.add(new QuestionAnswer("A 10kg hanging mass is attached to a 10kg cart. What is the acceleration of the system in m/s^2?", "4.9"));
        questionList.add(new QuestionAnswer("A 16kg hanging mass is attached to a 21kg cart. What is the tension of the rope in N?", "88.99"));
        questionList.add(new QuestionAnswer("A 17kg hanging mass is attached to a 25kg cart. What is the acceleration of the system in m/s^2?", "3.97"));
        questionList.add(new QuestionAnswer("A 4kg hanging mass is attached to a 10kg cart. What is the acceleration of the system in m/s^2?", "2.8"));
        questionList.add(new QuestionAnswer("A 13kg hanging mass is attached to a 14kg cart. What is the acceleration of the system in m/s^2?", "4.72"));
        questionList.add(new QuestionAnswer("A 18kg hanging mass is attached to a 11kg cart. What is the acceleration of the system in m/s^2?", "6.08"));
        questionList.add(new QuestionAnswer("The force on an object is 112N and its mass is 6kg. What is the acceleration in m/s^2?", "18.67"));
        questionList.add(new QuestionAnswer("The acceleration of an object is 8.43 m/s^2 and its mass is 12.8kg. What is the net force in N?", "107.9"));
        questionList.add(new QuestionAnswer("The force on an object is 87N and its acceleration is 4.2 m/s^2. What is its mass in kg?", "20.7"));
        questionList.add(new QuestionAnswer("The force on an object is 531N and its mass is 92kg. What is the acceleration in m/s^2?", "4.68"));
        questionList.add(new QuestionAnswer("The acceleration of an object is 6.31 m/s^2 and its mass is 17.2kg. What is the net force in N?", "108.5"));
        questionList.add(new QuestionAnswer("The force on an object is 15N and its acceleration is 12 m/s^2. What is its mass in kg?", "1.25"));
    }

    //Randomly get 5 different questions from the list
    public QuestionAnswer[] getRandomQuestions() {
        QuestionAnswer [] questions = new QuestionAnswer[5];
        //This list stores all the indexes of questions that have been chosen
        ArrayList<Integer> indexList = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            int intRandomQuestion = (int)(Math.random()*questionList.size());
            //Make sure that no question is added twice
            while(indexList.contains(intRandomQuestion)) {
                intRandomQuestion = (int)(Math.random()*questionList.size());
            }
            indexList.add(intRandomQuestion);
            questions[i] = questionList.get(intRandomQuestion);
        }

        return questions;
    }
}