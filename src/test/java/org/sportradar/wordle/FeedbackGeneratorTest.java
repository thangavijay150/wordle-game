package org.sportradar.wordle;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FeedbackGeneratorTest {

  private final FeedbackGenerator feedbackGenerator = new FeedbackGenerator();

  @Test
  public void testGreenHighlightOnCorrectPositionedLetters() {
    String feedback = feedbackGenerator.generateColoredFeedback("WATER", "WATER", 5);
    System.out.println(feedback);
    assertTrue(feedback.contains("\u001B[32mW\u001B[0m"));
    assertTrue(feedback.contains("\u001B[32mA\u001B[0m"));
    assertTrue(feedback.contains("\u001B[32mT\u001B[0m"));
    assertTrue(feedback.contains("\u001B[32mE\u001B[0m"));
    assertTrue(feedback.contains("\u001B[32mR\u001B[0m"));
  }

  @Test
  public void testYellowHighlightOnIncorrectPositionedLetter() {
    String feedback = feedbackGenerator.generateColoredFeedback("PLANT", "WATER", 5);
    System.out.println(feedback);
    assertTrue(feedback.contains("\u001B[33mT\u001B[0m"));
  }

  @Test
  public void testNoYellowHighlightForMoreThanOneCorrectLettersInGuess() {
    String feedback = feedbackGenerator.generateColoredFeedback("OTTER", "WATER", 5);
    System.out.println(feedback);
    assertTrue(feedback.contains("T "));
    assertTrue(feedback.contains("\u001B[32mT\u001B[0m"));
  }
}
