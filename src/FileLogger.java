import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileLogger implements Logger {
  private final FileLoggerConfiguration configuration;
  private Path currentLogPath;
  private static final String basePath = "src/logger";

  public static void main(String[] args) {
    FileLoggerConfiguration config = new FileLoggerConfiguration(LoggerHelper.getPath("Log.txt"), LoggingLevel.DEBUG, 1245, "[%s][%s] Message: %s \n");
    Logger logger = new FileLogger(config);

    // Load config from file
    //    LoggerConfigLoader confLoader = new FileLoggerConfigurationLoader("src/config/config.txt");
    //    FileLoggerConfiguration configFromFile = (FileLoggerConfiguration) confLoader.load();
    //    if (configFromFile == null) {
    //      System.out.println();
    //      return;
    //    }
    //    FileLogger logger = new FileLogger(configFromFile);


    logger.debug("Hello");
    logger.info("Bye");
  }

  FileLogger(FileLoggerConfiguration config) {
    this.configuration = config;
    this.currentLogPath = Path.of(configuration.getFilePath());
  }

  public static String getBasePath() {
    return basePath;
  }

  @Override
  public void debug(String message) {
    writeLog(message, LoggingLevel.DEBUG);
  }

  @Override
  public void info(String message) {
    writeLog(message, LoggingLevel.INFO);
  }

  private void writeLog(String message, LoggingLevel loggingLevel) {
    if (configuration.getLoggingLevel().equals(LoggingLevel.DEBUG) && loggingLevel.equals(LoggingLevel.DEBUG) || loggingLevel.equals(LoggingLevel.INFO)) {
      String logMessage = configuration.getFileFormat().formatted(LoggerHelper.getDateTime("yyyy.MM.dd-HH:mm"), loggingLevel, message);

      try {
        checkFileSize(logMessage);
      } catch (FileMaxSizeReachedException e) {
        currentLogPath = Path.of(
            basePath,
            LoggerHelper.generateNewPath("Log.txt")
        );
      }

      try (FileWriter writer = new FileWriter(currentLogPath.toString(), StandardCharsets.UTF_8, true)) {
        writer.write(logMessage);
      } catch(IOException e) {
        System.out.println("Can not write the file!");
        e.printStackTrace();
      }
    }
  }

  private void checkFileSize(String message) {
    try {
      Path path = currentLogPath;
      long fileSize = Files.exists(path) ? Files.size(path) : 0;
      if (fileSize + message.getBytes(StandardCharsets.UTF_8).length >= configuration.getFileSize()) {
        throw new FileMaxSizeReachedException("Max file size is reached!\n " +
            "Max file size is: " + configuration.getFileSize() +
            " bytes \nCurrent file size is: " + fileSize +
            " bytes \nFile path: " + configuration.getFilePath() );
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
