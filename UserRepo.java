import java.util.ArrayList;
import java.io.*;

public class UserRepo {
    private ArrayList<User> userList = new ArrayList<>();
    private PrintWriter writer;
    private BufferedReader reader;

    public UserRepo() {
        loadUsers();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void clearUsers() {
        userList.clear();
        writer = Driver.getWriter("user_info.txt");
        writer.print("");
    }

    public void loadUsers() {
        userList.clear();
        reader = Driver.getReader("user_info.txt");
        String strName = Driver.readLine(reader);
        int intTestScore;
        int intTimeTaken;
        String strTimeStamp;
        while(strName != null) {
            intTestScore = Integer.parseInt(Driver.readLine(reader));
            intTimeTaken = Integer.parseInt(Driver.readLine(reader));
            strTimeStamp = Driver.readLine(reader);
            userList.add(new User(strName, intTestScore, intTimeTaken, strTimeStamp));
            strName = Driver.readLine(reader);
        }

        try {
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void saveUsers() {
        writer = Driver.getWriter("user_info.txt");
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