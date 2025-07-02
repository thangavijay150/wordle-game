package org.sportradar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ResourceLoader {

  public List<String> loadWords(String fileName, int wordLength) {
    try (InputStream inputStream =
        WordleGameApplication.class.getClassLoader().getResourceAsStream(fileName)) {
      if (inputStream == null) {
        System.err.println("Resource not found: " + fileName);
        return List.of();
      }
      return new BufferedReader(new InputStreamReader(inputStream))
          .lines()
          .map(String::trim)
          .filter(line -> line.length() == wordLength)
          .map(String::toUpperCase)
          .toList();
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
      return List.of();
    }
  }
}
