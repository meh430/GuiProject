import java.util.ArrayList;

public class User {
    private String strName;
    private int intTestScore;
    private int intTimeTaken;
    private String strTimeStamp;
    private static ArrayList<String> randomNameList = new ArrayList<>();

    public User(String strName, int intTestScore, int intTimeTaken, String strTimeStamp) {
        this.strName = strName;
        this.intTestScore = intTestScore;
        this.intTimeTaken = intTimeTaken;
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

    public int getTimeTaken() {
        return intTimeTaken;
    }

    public String getTimeStamp() {
        return strTimeStamp;
    }
}