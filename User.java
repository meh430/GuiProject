import java.util.ArrayList;

public class User {
    private String strName;
    private double dblTestScore;
    private String strTimeTaken;
    private String strTimeStamp;
    private static ArrayList<String> randomNameList = new ArrayList<>();

    public User(String strName, double dblTestScore, String strTimeTaken, String strTimeStamp) {
        this.strName = strName;
        this.dblTestScore = dblTestScore;
        this.strTimeTaken = strTimeTaken;
        this.strTimeStamp = strTimeStamp;
        randomNameList.add("BRUH");
        randomNameList.add("MOMENT");
        randomNameList.add("Donald J Trump");
    }   

    public static String getRandomName() {
        int intRandomIndex = (int)(Math.random()*randomNameList.size());
        return randomNameList.get(intRandomIndex);
    }

    public String getName() {
        return strName;
    } 

    public double getScore() {
        return dblTestScore;
    }

    public String getTimeTaken() {
        return strTimeTaken;
    }

    public String getTimeStamp() {
        return strTimeStamp;
    }
}