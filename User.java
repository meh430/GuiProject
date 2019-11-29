import java.util.ArrayList;

//This class is a blueprint for a user
public class User {
    //Properties
    private String strName;
    private int intTestScore;
    private int intTimeTaken;
    private String strTimeStamp;
    private static ArrayList<String> randomNameList = new ArrayList<>();

    //Methods
    //Return random name in case user does not enter name
    public static String getRandomName() {
        randomNameList.add("Boomer");
        randomNameList.add("Bruh");
        randomNameList.add("Donald J Trump");
        randomNameList.add("Peter Parker");
        randomNameList.add("Tony Stark");
        randomNameList.add("Steve Rogers");
        randomNameList.add("Clark Kent");
        randomNameList.add("Bruce Wayne");
        randomNameList.add("James Buchanan Barnes");
        randomNameList.add("Peter Quill");
        randomNameList.add("Bruce Banner");
        randomNameList.add("Thor Odinson");
        randomNameList.add("Natasha Romanoff");
        randomNameList.add("Clint Barton");
        randomNameList.add("James Rhodes");
        randomNameList.add("Sam Wilson  ");
        randomNameList.add("Pietro Maximoff");
        randomNameList.add("Wanda");
        randomNameList.add("J.A.R.V.I.S");
        randomNameList.add("Hank Pym");
        randomNameList.add("Scott Lang");
        randomNameList.add("Hope Van Dyne");
        randomNameList.add("Yondu");
        randomNameList.add("T'Challa");
        randomNameList.add("Stephen Strange");
        randomNameList.add("Happy Hogan");


        int intRandomIndex = (int)(Math.random()*randomNameList.size());
        return randomNameList.get(intRandomIndex);
    }

    public String getName() {
        return strName;
    } 

    public int getScore() {
        return intTestScore;
    }

    public int getTimeTaken() {
        return intTimeTaken;
    }

    public String getTimeStamp() {
        return strTimeStamp;
    }

    //Constructor
    public User(String strName, int intTestScore, int intTimeTaken, String strTimeStamp) {
        this.strName = strName;
        this.intTestScore = intTestScore;
        this.intTimeTaken = intTimeTaken;
        this.strTimeStamp = strTimeStamp;
    } 
}