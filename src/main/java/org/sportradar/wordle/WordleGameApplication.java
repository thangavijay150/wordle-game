package org.sportradar.wordle;

import static org.sportradar.wordle.utils.Constants.MAX_ATTEMPTS;
import static org.sportradar.wordle.utils.Constants.WORD_LENGTH;

public class WordleGameApplication {

  public static void main(String[] args) {
    new GameEngine().play(MAX_ATTEMPTS, WORD_LENGTH);
  }
}
