package org.sportradar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ResourceLoaderTest {

  private final ResourceLoader resourceLoader = new ResourceLoader();

  @Test
  public void testLoadWordsWithMockData() {
    List<String> mockWords = List.of("apple", "mango", "grape", "banana", "pear");
    String joinedMockWords = String.join("\n", mockWords);
    byte[] byteArray = joinedMockWords.getBytes(StandardCharsets.UTF_8);
    ByteArrayInputStream mockInputStream = new ByteArrayInputStream(byteArray);
    List<String> result = resourceLoader.loadWords(mockInputStream, "words.txt", 5);
    assertEquals(List.of("APPLE", "MANGO", "GRAPE"), result);
  }
}
