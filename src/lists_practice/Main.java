package lists_practice;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    String[] stringArr = new String[] {
        "hello", "hello", "hallO", "hAllo", "by",
        "sunday", "monday", "sunday", "hello", "tuesday",
        "february", "sunday", "monday", "sunday", "by",
        "hello", "hello", "hallO", "hAllo", "by",
    };

    ArrayList<String> list = new ArrayList<>(Arrays.asList(stringArr));

    int countOccurrenceRes = countOccurrence(list, "hello");
    System.out.println("Count Occurrence Result: " + countOccurrenceRes);

    System.out.println("List from array: "+ list);

    List<Integer> findUniqueRes = findUnique(toList(new int[] {1, 5, 6, 8, 123, 1, 123, 0, 5, 2, 4, 1}));
    System.out.println("Find Unique Result - " + findUniqueRes);

    Map<String, Integer> calcOccurrenceRes = calcOccurrence(list);
    System.out.println("Calc Occurrence Result: " + calcOccurrenceRes);

    List<ListEntity> findOccurrenceRes = findOccurrence(list);
    printOccurrence(findOccurrenceRes);

  }

  public static int countOccurrence(List<String> list, String string) {
    int result = 0;

    for(String str : list) {
      if(str.equals(string)) {
        result += 1;
      }
    }
    return result;
  }

  public static List<Integer> toList(int[] array) {
    List<Integer> newIntList = new ArrayList<>();

    for(int value : array) {
      newIntList.add(value);
    }

    return newIntList;
  }

  public static List<Integer> findUnique(List<Integer> intList) {
    return new ArrayList<>(new HashSet<>(intList));
  }


  public static Map<String, Integer> calcOccurrence(List<String> list) {
    HashMap<String, Integer> result = new HashMap<>();

    for(String key : list) {
      result.merge(key, 1, Integer::sum);
    }

    return result;
  }

  public static List<ListEntity> findOccurrence(List<String> list) {
    Map<String, Integer> calcOccurrenceRes = calcOccurrence(list);
    ArrayList<ListEntity> objectOccurrenceList = new ArrayList<>();

    for (String key : calcOccurrenceRes.keySet()) {
      objectOccurrenceList.add(new ListEntity(key, calcOccurrenceRes.get(key)));
    }

    return objectOccurrenceList;
  }

  private static void printOccurrence(List<ListEntity> list) {
    System.out.println("[ ");
    for (ListEntity obj: list) {
      System.out.println(obj.toString());
    }
    System.out.println(" ]");
  }
}





