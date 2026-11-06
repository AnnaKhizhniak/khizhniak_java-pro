import java.util.*;

public class FileNavigator {
  private Map<String, List<FileData>> fileNavigator = new HashMap<>();

  public void add(String path, FileData file) {
    if (!file.filePath().equals(path)) {
      System.out.println("The key path and file path are not equals!");
      System.out.println("Path: " + path);
      System.out.println("FileData: " + file.toString());
      return;
    }

    if (!fileNavigator.containsKey(path)) {
      List<FileData> newFileData = new ArrayList<>();
      newFileData.add(file);
      fileNavigator.put(path, newFileData);
    } else {
      fileNavigator.get(path).add(file);
    }
  }

  public List<FileData> find(String path) {
    return fileNavigator.get(path);
  }

  public List<FileData> filterBySize(double size) {
    List<FileData> filteredList = new ArrayList<>();

    for(String key : fileNavigator.keySet()) {
      for (FileData value : fileNavigator.get(key)) {
        if (value.fileSize() <= size) {
          filteredList.add(value);
        }
      }
    }
    return filteredList;
  }

  public void remove(String path) {
    fileNavigator.remove(path);
    System.out.print("List after remove: ");
    print();
  }

  public void print() {
    for(String key : fileNavigator.keySet()) {
      List<FileData> keyValueList = new ArrayList<>(fileNavigator.get(key));
        System.out.println(key + " -> " + keyValueList.toString());
    }
  }

  public List<FileData> sortBySize() {
    List<FileData> sortedList = new ArrayList<>();

    for(String key : fileNavigator.keySet()) {

      for (FileData value : fileNavigator.get(key)) {
        sortedList.add(value);
      }
    }

    sortedList.sort(null);

    System.out.println("Sorted list: " + sortedList);
    return sortedList;
  }


  public void print(List<FileData> files) {
    for(FileData f : files) {
      System.out.println(f.toString());
    }
  }
}
