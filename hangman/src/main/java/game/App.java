package game;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

class HangmanGame {
    private WordBank wordBank;
    private HangmanRound currentRound;
    private Scanner scn;

    public HangmanGame() {
        wordBank = new WordBank();
        scn = new Scanner(System.in);
    }


    public void startGame() {
        System.out.println("Welcome to Hangman!");
        boolean playAgain = true;

        while (playAgain) {
            playRound();
            System.out.println("Would you like to play again? (y/n)");
            String response = scn.nextLine().toLowerCase();
            playAgain = response.equals("y");
        }

        System.out.println("Thanks for playing!");
    }

    public void playRound() {
        String wordToGuess = wordBank.getRandomWord();
        currentRound = new HangmanRound(wordToGuess);

        System.out.println("Let's start a new round!");
        System.out.println("Your word has " + wordToGuess.length() + " letters.");

        while (!isGameOver()) {
            currentRound.displayGuessedWord();
            System.out.println("Enter a letter or try to guess the whole word: ");
            String guess = scn.nextLine().toLowerCase();

            handleGuess(guess);
        }

        if (currentRound.hasWon()) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you lost! The correct word was: " + wordToGuess);
        }
    }

    private boolean isGameOver() {
        return currentRound.hasWon() || currentRound.hasLost();
    }

    private void handleGuess(String guess) {
        if (guess.length() == 1) {
            char guessedLetter = guess.charAt(0);
            if (Character.isLetter(guessedLetter)) {
                boolean correct = currentRound.guessLetter(guessedLetter);
                if (!correct) {
                    System.out.println("Incorrect guess! You have " + currentRound.getAttemptsLeft() + " attempts remaining.");
                }
            } else {
                System.out.println("Please enter a valid letter.");
            }
        } else {
            boolean correct = currentRound.guessWord(guess);
            if (!correct) {
                System.out.println("Incorrect word guess! You have " + currentRound.getAttemptsLeft() + " attempts remaining.");
            }
        }
    }
}

class WordBank {
    private List<String> wordList = new ArrayList<String>();

    public WordBank() {
        wordList.add("word");
        wordList.add("test");
        wordList.add("ball");
        wordList.add("game");
    }

    public String getRandomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.size());
        return wordList.get(randomIndex);
    }

}

class HangmanRound {
    private String currentWord;
    private StringBuffer guessedWord = new StringBuffer();
    private int attemptsLeft;
    private HashSet<Character> correctCharGuesses = new HashSet<Character>();
    private StringTokenizer strTokenizer;

    public HangmanRound(String word) {
        currentWord = word;
        attemptsLeft = 6;
        correctCharGuesses.clear();
        for (int i = 0; i < currentWord.length(); i++) {
            guessedWord.append("_");
        }
    }

    public boolean guessLetter(char letter) {
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == letter) {
                updateGuessedWord(letter, i);
                correctCharGuesses.add(letter);
            }
        }
        if (correctCharGuesses.contains(letter)) {
            return true;
        }
        attemptsLeft--;
        return false;
    }

    public boolean guessWord(String word) {
        strTokenizer = new StringTokenizer(word);

        while (strTokenizer.hasMoreTokens() && attemptsLeft > 0) {
            if (strTokenizer.nextToken().equals(currentWord)) {
                guessedWord.replace(0, currentWord.length(), currentWord);
                return true;
            } else {
                attemptsLeft--;
            }
        }
        return false;
    }

    public void updateGuessedWord(char letter, int index) {
        guessedWord.replace(index, index+1, Character.toString(letter));
    }

    public boolean hasWon() {
        if (guessedWord.toString().equals(currentWord)) {
            return true;
        }
        return false;
    }

    public boolean hasLost() {
        if (attemptsLeft <= 0) {
            return true;
        }
        return false;
    }

    public void displayGuessedWord() {
        System.out.println(guessedWord.toString());
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }
}

/*
class StringProcessor {
    public String[] tokenize(String sentence) {
        return "test";
    }

    public int searchKeyword(String word, String keyword) {
        return "test";
    }

    public boolean compareStrings(String str1, String str2) {
        return "test";
    }
}
*/
/*
class GameUtils {
    public boolean isValidLetter(char letter) {

    }

    public String formatWordForDisplay(StringBuffer guessedWord) {

    }

    public isValidWord(String word) {

    }
}
*/

public class App {
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        game.startGame();
    }
}
