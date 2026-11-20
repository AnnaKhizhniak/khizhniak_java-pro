package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileLoggerTest {

  @Test
  void debugShouldWriteMessageWhenLevelIsDebug() throws IOException {
    FileLogger logger = createLogger(
        "test.log",
        LoggingLevel.DEBUG,
        1024
    );

    logger.debug("Hello");
    Path logPath = tempDir.resolve("test.log");
    assertTrue(Files.exists(logPath));
    String content = Files.readString(logPath);
    assertTrue(content.contains("[DEBUG]"));
    assertTrue(content.contains("Hello"));
  }

  @Test
  void debugShouldNotWriteWhenLevelIsInfo() {
    FileLogger logger = createLogger(
        "test.log",
        LoggingLevel.INFO,
        1024
    );

    logger.debug("Hello");
    Path logPath = tempDir.resolve("test.log");
    assertFalse(Files.exists(logPath));
  }

  @TempDir
  Path tempDir;

  private FileLogger createLogger(
      String fileName,
      LoggingLevel level,
      int maxSize
  ) {
    Path logPath = tempDir.resolve(fileName);

    FileLoggerConfiguration config =
        new FileLoggerConfiguration(
            logPath.toString(),
            level,
            maxSize,
            "[%s][%s] Message: %s\n"
        );

    return new FileLogger(config);
  }
}