package org.sportradar;

public class WordleGameApplication {
  private static final int WORD_LENGTH = 5;
  private static final int MAX_ATTEMPTS = 5;

  public static void main(String[] args) {
    new GameEngine().play(MAX_ATTEMPTS, WORD_LENGTH);
  }
}
