package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileLoggerConfigurationTest {

  @Test
  void shouldInitializeFieldsWithConstructor() {
    FileLoggerConfiguration config = new FileLoggerConfiguration(
        "src/logger/test.log",
        LoggingLevel.DEBUG,
        1024,
        "[%s][%s] Message: %s\n"
    );
    assertEquals("src/logger/test.log", config.getFilePath());
    assertEquals(LoggingLevel.DEBUG, config.getLoggingLevel());
    assertEquals(1024, config.getFileSize());
    assertEquals("[%s][%s] Message: %s\n", config.getFileFormat());
  }

  @Test
  void shouldInitializeDefaultValuesWithEmptyConstructor() {
    FileLoggerConfiguration config = new FileLoggerConfiguration();
    assertNull(config.getFilePath());
    assertNull(config.getLoggingLevel());
    assertEquals(0, config.getFileSize());
    assertNull(config.getFileFormat());
  }

  @Test
  void shouldSetFilePath() {
    FileLoggerConfiguration config = new FileLoggerConfiguration();
    config.setFilePath("src/logger/test.log");
    assertEquals("src/logger/test.log", config.getFilePath());
  }

  @Test
  void shouldSetLoggingLevel() {
    FileLoggerConfiguration config = new FileLoggerConfiguration();
    config.setLoggingLevel(LoggingLevel.INFO);
    assertEquals(LoggingLevel.INFO, config.getLoggingLevel());
  }

  @Test
  void shouldSetFileSize() {
    FileLoggerConfiguration config = new FileLoggerConfiguration();
    config.setFileSize(2048);
    assertEquals(2048, config.getFileSize());
  }

  @Test
  void shouldSetFileFormat() {
    FileLoggerConfiguration config = new FileLoggerConfiguration();
    config.setFileFormat("[%s] %s %s");
    assertEquals("[%s] %s %s", config.getFileFormat());
  }
}