package Serialization;

import java.io.*;

// UserSession class
class UserSession implements Serializable {

    private static final long serialVersionUID = 1L;

    String username;
    boolean loggedIn;

    // Constructor
    UserSession(String username, boolean loggedIn) {
        this.username = username;
        this.loggedIn = loggedIn;
    }

    // Method to display session details
    void display() {
        System.out.println("Username : " + username);
        System.out.println("Logged In: " + loggedIn);
    }
}

// Main class
public class SessionDemo {

    public static void main(String[] args) {

        // Create a user session object
        UserSession session = new UserSession("Alice", true);

        try {
            // Save object to file
            FileOutputStream fos = new FileOutputStream("session.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(session);

            oos.close();
            fos.close();

            System.out.println("Session saved successfully!");

            // Load object from the same file
            FileInputStream fis = new FileInputStream("session.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            UserSession loadedSession = (UserSession) ois.readObject();

            ois.close();
            fis.close();

            System.out.println("\nSession loaded successfully!");
            loadedSession.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}