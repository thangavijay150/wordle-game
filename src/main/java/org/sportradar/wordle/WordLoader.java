package org.sportradar.wordle;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class WordLoader {

  public List<String> loadWords(InputStream inputStream, String filename, int wordLength) {
    if (inputStream == null) {
      System.err.println("Resource not found: " + filename);
      return List.of();
    }
    return new BufferedReader(new InputStreamReader(inputStream))
        .lines()
        .map(String::trim)
        .filter(line -> line.length() == wordLength)
        .map(String::toUpperCase)
        .toList();
  }
}
