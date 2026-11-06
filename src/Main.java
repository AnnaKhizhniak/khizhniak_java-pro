import java.util.List;

public class Main {
  public static void main(String[] args) {
    FileNavigator fileNavigator = new FileNavigator();

    fileNavigator.add("/path/to/file-1", new FileData("file-1.txt", 456.34, "/path/to/file-1"));
    fileNavigator.add("/path/to/file-2", new FileData("file-2.txt", 123.00, "/path/to/file-2"));
    fileNavigator.add("/path/to/file-1", new FileData("file-3.txt", 3336.34, "/path/to/file-1"));
    fileNavigator.add("/path/to/file-1", new FileData("file-1.txt", 100.34, "/path/to/file-1"));
    fileNavigator.add("/path/to/file-2", new FileData("file-2.txt", 456789.00, "/path/to/file-2"));
    fileNavigator.add("/path/to/file-1", new FileData("file-3.txt", 23.678, "/path/to/file-1"));

    List<FileData> foundFileRes = fileNavigator.find("/path/to/file-2");

    if (foundFileRes != null) {
      System.out.print("Found path result: ");
      fileNavigator.print(foundFileRes);
    }

    List<FileData> filteredListByFileSize = fileNavigator.filterBySize(457);
    System.out.println("Filtered list by file size: " + filteredListByFileSize);

    fileNavigator.remove("/path/to/file-1");

    fileNavigator.sortBySize();
  }
}
