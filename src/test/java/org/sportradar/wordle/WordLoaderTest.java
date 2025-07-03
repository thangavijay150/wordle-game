package org.sportradar.wordle;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordLoaderTest {

  private final WordLoader wordLoader = new WordLoader();

  @Test
  public void testLoadWordsWithMockData() {
    List<String> mockWords = List.of("apple", "mango", "grape", "banana", "pear");
    String joinedMockWords = String.join("\n", mockWords);
    byte[] byteArray = joinedMockWords.getBytes(StandardCharsets.UTF_8);
    ByteArrayInputStream mockInputStream = new ByteArrayInputStream(byteArray);
    List<String> result = wordLoader.loadWords(mockInputStream, "words.txt", 5);
    assertEquals(List.of("APPLE", "MANGO", "GRAPE"), result);
  }
}
