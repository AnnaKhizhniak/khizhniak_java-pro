package org.example;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerHelper {
  public static String getPath(String fileName) {
    File folder = new File(FileLogger.getBasePath());
    folder.mkdirs();

    File[] files = folder.listFiles();
    File lastFile = null;

    if (files != null) {
      for (File file : files) {
        if (file.isFile()
            && file.getName().startsWith("Log_")
            && file.getName().endsWith(".txt")) {

          if (lastFile == null ||
              file.getName().compareTo(lastFile.getName()) > 0) {
            lastFile = file;
          }
        }
      }
    }

    if (lastFile != null) {
      return lastFile.getPath();
    }

    return new File(folder, generateNewPath(fileName)).getPath();
  }

  public static String generateNewPath(String fileName) {
    String[] nameArr = fileName.split("\\.");
    if (nameArr.length < 2 || nameArr[0].trim().isEmpty() || nameArr[1].trim().isEmpty()) {
      System.out.println("File name is incorrect!");
      return "";
    }

    return nameArr[0] + "_" + getDateTime("yyyy.MM.dd-HH-mm-ss") + "." + nameArr[1];
  }

  public static String getDateTime(String format) {
    LocalDateTime today = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

    return today.format(formatter);
  }
}
