package org.sportradar.wordle;

import static org.sportradar.wordle.utils.Constants.*;

import java.util.HashMap;

public class FeedbackGenerator {

  public String generateColoredFeedback(String guess, String target, int wordLength) {
    LetterStatus[] statuses = new LetterStatus[wordLength];
    HashMap<Character, Integer> letterCounts = new HashMap<>();
    for (char c : target.toCharArray()) {
      letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
    }

    for (int i = 0; i < wordLength; i++) {
      if (guess.charAt(i) == target.charAt(i)) {
        statuses[i] = LetterStatus.CORRECT;
        letterCounts.put(guess.charAt(i), letterCounts.get(guess.charAt(i)) - 1);
      }
    }

    for (int i = 0; i < wordLength; i++) {
      if (statuses[i] != null) continue;
      char c = guess.charAt(i);
      int count = letterCounts.getOrDefault(c, 0);
      if (count > 0) {
        statuses[i] = LetterStatus.PRESENT;
        letterCounts.put(c, count - 1);
      } else {
        statuses[i] = LetterStatus.ABSENT;
      }
    }
    StringBuilder result = new StringBuilder("  ");
    for (int i = 0; i < wordLength; i++) {
      char c = guess.charAt(i);
      switch (statuses[i]) {
        case CORRECT -> result.append(GREEN).append(c).append(DEFAULT);
        case PRESENT -> result.append(YELLOW).append(c).append(DEFAULT);
        case ABSENT -> result.append(c);
      }
      result.append(" ");
    }

    return result.toString();
  }

  private enum LetterStatus {
    CORRECT,
    PRESENT,
    ABSENT
  }
}
