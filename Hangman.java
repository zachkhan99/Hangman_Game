import java.util.Scanner;

public class Hangman {
    private String word;
    private char[] wordToGuess;
    private char[] currentProgress;
    private int attemptsLeft;

    public Hangman(String word) {
        this.word = word;
        this.wordToGuess = word.toCharArray();
        this.currentProgress = new char[word.length()];
        this.attemptsLeft = 8;

        for (int i = 0; i < word.length(); i++) {
            this.currentProgress[i] = '_';
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (attemptsLeft > 0) {
            System.out.println("Word: " + new String(currentProgress));
            System.out.println("Attempts remaining: " + attemptsLeft);
            System.out.print("Guess a letter: ");
            String input = scanner.next();
            
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter a valid single letter.");
                continue;
            }

            char guess = Character.toLowerCase(input.charAt(0));

            if (checkGuess(guess)) {
                if (isWordGuessed()) {
                    System.out.println("Congratulations! You've guessed the word: " + word);
                    break;
                }
            } else {
                System.out.println("Incorrect guess!");
                attemptsLeft--;
            }
        }

        if (attemptsLeft == 0) {
            System.out.println("You've run out of attempts. The word was: " + word);
        }

        System.out.print("Would you like to play again? (y/n): ");
        Scanner replayScanner = new Scanner(System.in);
        String replayChoice = replayScanner.nextLine().toLowerCase();

        if (replayChoice.equals("y")) {
            System.out.println("Restarting the game...\n");
            Hangman newGame = new Hangman(word);
            newGame.play();
        } else {
            System.out.println("Thanks for playing!");
        }
        
        scanner.close();
        replayScanner.close();
    }

    private boolean checkGuess(char guess) {
        boolean correctGuess = false;
        for (int i = 0; i < wordToGuess.length; i++) {
            if (wordToGuess[i] == guess && currentProgress[i] == '_') { 
                currentProgress[i] = guess;
                correctGuess = true;
            }
        }
        return correctGuess;
    }

    private boolean isWordGuessed() {
        for (char c : currentProgress) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}
