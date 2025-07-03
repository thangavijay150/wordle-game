package org.sportradar.wordle;

import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameEngine {

  private final WordLoader wordLoader = new WordLoader();
  private final FeedbackGenerator feedbackGenerator = new FeedbackGenerator();

  public void play(int maxAttempts, int wordLength) {
    String fileName = "words.txt";
    InputStream inputStream =
        WordleGameApplication.class.getClassLoader().getResourceAsStream(fileName);
    List<String> words = wordLoader.loadWords(inputStream, fileName, wordLength);
    if (words.isEmpty()) {
      System.out.println(
          "The word list is empty. Check the file content and modify word length accordingly");
      return;
    }
    String target = words.get(new Random().nextInt(words.size()));
    System.out.print(
        "\n Hi, Welcome to wordle game by sport radar! \n How to play: \n 1. You will have 5 guesses and you are going to guess the 5 letter word \n 2. The letter position which you have guessed correctly will be shown in green color \n 3. The letter which you have guessed correctly but not in the correct position will be shown as yellow color. \n All the best for the game!\n\n");
    Scanner scanner = new Scanner(System.in);
    for (int attempt = 1; attempt <= maxAttempts; attempt++) {
      System.out.print("Attempt " + attempt + "/" + maxAttempts + ": ");
      String guess = scanner.nextLine().trim().toUpperCase();

      if (guess.length() != wordLength) {
        System.out.println("Please enter a 5-letter word.");
        attempt--;
        continue;
      }

      System.out.println(feedbackGenerator.generateColoredFeedback(guess, target, wordLength));
      if (guess.equals(target)) {
        System.out.println("Congrats! You guessed the correct word.");
        return;
      }
    }

    System.out.println("GAME OVER! The correct word was: " + target);
  }
}
