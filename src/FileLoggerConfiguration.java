public class FileLoggerConfiguration implements LoggerConfig {
  private String file;
  private LoggingLevel level;
  private long maxSize;
  private String format;

  public FileLoggerConfiguration(String filePath, LoggingLevel loggingLevel, long fileSize, String fileFormat) {
    this.file = filePath;
    this.format = fileFormat;
    this.maxSize = fileSize;
    this.level = loggingLevel;
  }

  public FileLoggerConfiguration() {}

  @Override
  public String getFileFormat() {
    return format;
  }

  public void setFileFormat(String fileFormat) {
    this.format = fileFormat;
  }

  public String getFilePath() {
    return file;
  }

  public void setFilePath(String filePath) {
    this.file = filePath;
  }

  @Override
  public LoggingLevel getLoggingLevel() {
    return level;
  }

  public void setLoggingLevel(LoggingLevel loggingLevel) {
    this.level = loggingLevel;
  }

  public long getFileSize() {
    return maxSize;
  }

  public void setFileSize(long fileSize) {
    this.maxSize = fileSize;
  }
}
