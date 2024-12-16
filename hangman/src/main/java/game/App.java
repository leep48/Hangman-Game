package game;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class HangmanGame {
    private WordBank wordBank = new WordBank();

    public void startGame() {
        String randomWord = wordBank.getRandomWord();
    }

    public playRound() {

    }

    boolean isGameOver() {

    }

    void displayResult() {

    }

    void showHint(String keyword) {

    }
}

class WordBank {
    private List<String> wordList = new ArrayList<String>();

    public WordBank() {
        wordList.add("word");
        wordList.add("test");
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
    private List<Character> incorrectGuesses;

    public HangmanRound(String word) {

    }

    public boolean guessLetter(char letter) {

    }

    public boolean guessWord(String word) {

    }

    public void updateGuessedWord(char letter, int index) {

    }

    public boolean hasWon() {

    }

    public boolean hasLost() {

    }

    public void displayGuessedWord() {

    }
}

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

class GameUtils {
    public boolean isValidLetter(char letter) {

    }

    public String formatWordForDisplay(StringBuffer guessedWord) {

    }

    public isValidWord(String word) {

    }
}


public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
