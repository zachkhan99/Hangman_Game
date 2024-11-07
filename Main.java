import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File secretFile = new File("secret");
        
        // Check if the file exists before proceeding
        if (!secretFile.exists()) {
            System.out.println("File \"secret\" is not found. Exiting...");
            return;
        }

        Scanner fileScanner = null;
        String username = null;
        String password = null;

        try {
            // Initialize scanner to read from the file
            fileScanner = new Scanner(secretFile);

            // Read the username and password from the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();  // Trim spaces from each line
                if (line.startsWith("username: ")) {
                    username = line.substring(10).trim();  // Extract username and trim any extra spaces
                } else if (line.startsWith("password: ")) {
                    password = line.substring(10).trim();  // Extract password and trim any extra spaces
                }
            }

            // If either username or password is missing, handle it
            if (username == null || password == null) {
                System.out.println("Username or password are incorrect or missing. Exiting...");
                return;
            }

            // Assume a fixed correct combination
            System.out.println("Welcome to Hangman, " + username + "!");

            // Create the Hangman game instance and start the game
            Hangman hangman = new Hangman("hangman");
            hangman.play();

        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.out.println("Error reading the \"secret\" file. Exiting...");
        } finally {
            // Ensure the file scanner is closed if it was initialized
            if (fileScanner != null) {
                fileScanner.close();
            }
        }
    }
}
