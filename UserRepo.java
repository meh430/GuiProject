import java.util.ArrayList;
import java.io.*;

public class UserRepo {
    private ArrayList<User> userList = new ArrayList<>();
    private PrintWriter writer;
    private BufferedReader reader;
    private boolean blnErrorOpening = false;

    public UserRepo() {
        loadUsers();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void clearUsers() {
        userList.clear();
        writer = getWriter();
        writer.print("");
    }

    public void loadUsers() {
        userList.clear();
        reader = getReader();
        String strName = readLine();
        int intTestScore;
        int intTimeTaken;
        String strTimeStamp;
        while(strName != null) {
            intTestScore = Integer.parseInt(readLine());
            intTimeTaken = Integer.parseInt(readLine());
            strTimeStamp = readLine();
            userList.add(new User(strName, intTestScore, intTimeTaken, strTimeStamp));
            strName = readLine();
        }

        try {
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveUsers() {
        writer = getWriter();
        for(User user:userList) {
            writer.println(user.getName());
            writer.println(user.getScore());
            writer.println(user.getTimeTaken());
            writer.println(user.getTimeStamp());
        }
        
        writer.close();
    }

    private PrintWriter getWriter() {
        try {
            return new PrintWriter(new FileWriter("user_info.txt"));
        } catch(IOException e) {
            e.printStackTrace();
            blnErrorOpening = true;
        }

        return null;
    }

    private BufferedReader getReader() {
        try {
            return new BufferedReader(new FileReader("user_info.txt"));
        } catch(IOException e) {
            e.printStackTrace();
            blnErrorOpening = true;
        }

        return null;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
    
    private boolean openingFileFailed() {
        return blnErrorOpening;
    }
}