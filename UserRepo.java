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

    public void loadUsers() {
        userList.clear();
        reader = getReader();
        String strName;
        double dblTestScore;
        String strTimeTaken;
        String strTimeStamp;
        String strContents = readLine();
        while(strContents!=null) {
            strName = readLine();
            strContents = readLine();
            dblTestScore = Double.parseDouble(readLine());
            strContents = readLine();
            strTimeTaken = readLine();
            strContents = readLine();
            strTimeStamp = readLine();
            strContents = readLine();
            userList.add(new User(strName, dblTestScore, strTimeTaken, strTimeStamp));
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

    private boolean openingFileFailed() {
        return blnErrorOpening;
    }
}