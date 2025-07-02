package org.sportradar;

import java.util.HashMap;
import java.util.Map;

public class FeedbackGenerator {

    public void generateFeedback(String guess, String target, int wordLength) {
        Map<Character, Integer> targetLetterCountMap = new HashMap<>();
        for (char targetChar : target.toCharArray()) {
            targetLetterCountMap.put(targetChar, targetLetterCountMap.getOrDefault(targetChar, 0) + 1);
        }
        System.out.print("  ");
        for (int i = 0; i < wordLength; i++) {
            char guessedChar = guess.charAt(i);
            if (guessedChar == target.charAt(i)) {
                System.out.print("\u001B[32m" + guessedChar + "\u001B[0m ");
            } else if (target.contains(String.valueOf(guessedChar)) && targetLetterCountMap.get(guessedChar) > 0) {
                System.out.print("\u001B[33m" + guessedChar + "\u001B[0m ");
                targetLetterCountMap.put(guessedChar, targetLetterCountMap.get(guessedChar) - 1);
            } else {
                System.out.print(guessedChar + " ");
            }
        }
        System.out.println();

    }
}
