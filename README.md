# Hangman Game

## Description

This is a simple **Hangman** game written in Java. The program allows the player to guess letters in a hidden word. It displays progress as underscores and updates it as the player makes correct guesses. The player has 8 attempts to guess the word before losing the game.

## Features

- **Word guessing**: The game picks a word, and the player has to guess it letter by letter.
- **Attempts**: The player has 8 incorrect guesses to make before the game is over.
- **User interaction**: The game prompts the player to guess one letter at a time and updates the word display after each guess.
- **Replay option**: After a game finishes, the user can choose to play again.

## Requirements

- Java 8 or later.
- A terminal or command line interface to run the program.

## How to Run

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/USERNAME/Hangman.git
   ```
2. Navigate into the project directory:
   ```bash
	cd Hangman
	```
3. Compile the Java files:
	```bash
	javac Main.java Hangman.java
	```
4. Run the program:
	```bash
	java Main
	```
5. Play the game! You will be prompted to guess a letter. The game will show your progress and remaining attempts.

## Cleaning Up

After running the program, you can clean up the generated .class files by running:
	```bash
	make clean
	```

