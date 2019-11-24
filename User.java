import java.util.ArrayList;

public class User {
    private String strName;
    private int intTestScore;
    private String strTimeTaken;
    private String strTimeStamp;
    private static ArrayList<String> randomNameList = new ArrayList<>();

    public User(String strName, int intTestScore, String strTimeTaken, String strTimeStamp) {
        this.strName = strName;
        this.intTestScore = intTestScore;
        this.strTimeTaken = strTimeTaken;
        this.strTimeStamp = strTimeStamp;
    }   

    public static String getRandomName() {
        randomNameList.add("BRUH");
        randomNameList.add("MOMENT");
        randomNameList.add("Donald J Trump");
        int intRandomIndex = (int)(Math.random()*randomNameList.size());
        return randomNameList.get(intRandomIndex);
    }

    public String getName() {
        return strName;
    } 

    public int getScore() {
        return intTestScore;
    }

    public String getTimeTaken() {
        return strTimeTaken;
    }

    public String getTimeStamp() {
        return strTimeStamp;
    }
}