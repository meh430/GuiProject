import java.util.ArrayList;
import java.io.*;

//This class handles the storing of users and reading them from a file
public class UserRepo {
    //Properties
    private ArrayList<User> userList = new ArrayList<>();
    private PrintWriter writer;
    private BufferedReader reader;

    //Constructor
    public UserRepo() {
        loadUsers();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    //Clear users and the data on the text file
    public void clearUsers() {
        userList.clear();
        writer = Utility.getWriter("user_info.txt");
        writer.print("");
    }

    //Load users from the text file
    public void loadUsers() {
        userList.clear();
        reader = Utility.getReader("user_info.txt");
        String strName = Utility.readLine(reader);
        int intTestScore;
        int intTimeTaken;
        String strTimeStamp;
        while(strName != null) {
            intTestScore = Integer.parseInt(Utility.readLine(reader));
            intTimeTaken = Integer.parseInt(Utility.readLine(reader));
            strTimeStamp = Utility.readLine(reader);
            userList.add(new User(strName, intTestScore, intTimeTaken, strTimeStamp));
            strName = Utility.readLine(reader);
        }

        try {
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    //Save the users to a text file
    public void saveUsers() {
        writer = Utility.getWriter("user_info.txt");
        for(User user:userList) {
            writer.println(user.getName());
            writer.println(user.getScore());
            writer.println(user.getTimeTaken());
            writer.println(user.getTimeStamp());
        }
        
        writer.close();
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
}