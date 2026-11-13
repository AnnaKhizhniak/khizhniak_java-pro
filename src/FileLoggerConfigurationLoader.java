import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileLoggerConfigurationLoader implements LoggerConfigLoader {
  private final String path;

  public FileLoggerConfigurationLoader(String path) {
    this.path = path;
  }

  @Override
  public FileLoggerConfiguration load() {
    String result = "";

    try(FileReader reader = new FileReader(path, StandardCharsets.UTF_8)) {
      int character;
      while ((character = reader.read()) != -1) {
        result += (char) character;
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Can not read the file!");
      return null;
    }

    return parseRawConfig(result);
  }

  private FileLoggerConfiguration parseRawConfig(String rawString) {
    FileLoggerConfiguration configuration = new FileLoggerConfiguration();
    String[] rawStringsArray = rawString.split("\n");
    for(String s : rawStringsArray) {
      String[] strArray = s.split(":", 2);
      if (strArray.length < 2 || strArray[1].trim().isEmpty()) {
        System.out.println("Incorrect configuration value data!");
        return null;
      }

      switch (strArray[0].toLowerCase().trim()) {
        case ("file"):
          configuration.setFilePath(LoggerHelper.getPath(strArray[1].trim()));
          break;
        case ("format"):
          configuration.setFileFormat(strArray[1].trim() + "\n");
          break;
        case ("max-size"):
          try {
            configuration.setFileSize(Long.parseLong(strArray[1].trim()));
          } catch (NumberFormatException e) {
            System.out.println("Incorrect configuration max-size format!");
            return null;
          }
          break;
        case ("level"):
          try {
            configuration.setLoggingLevel(LoggingLevel.valueOf(strArray[1].trim().toUpperCase()));
          } catch (IllegalArgumentException e) {
            System.out.println("Incorrect configuration level value!");
            return null;
          }
          break;
      }
    }

    return checkConfigurationObject(configuration) ? configuration : null;
  }

  private Boolean checkConfigurationObject(FileLoggerConfiguration configuration) {
    if (configuration.getFileSize() <= 0
        || configuration.getFilePath() == null
        || configuration.getFilePath().isEmpty()
        || configuration.getLoggingLevel() == null
        || configuration.getFileFormat() == null
        || configuration.getFileFormat().isEmpty()
    ) {
      System.out.println("Configuration did not parsed correct!");
      return false;
    }
    return true;
  }
}
