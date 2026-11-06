public record FileData(String fileName, double fileSize, String filePath) implements Comparable<FileData> {
  @Override
  public String toString() {
    return "  { name: \"" + fileName + "\", size: " + fileSize + ", path: \"" + filePath + "\" }";
  }


  @Override
  public int compareTo(FileData o) {
    return Double.compare(this.fileSize(), o.fileSize());
  }
}
