package string_methods;

public class Main {
  public static void main(String[] args) {
    int symbolOccuranceResult = findSymbolOccurance("shn*kdtnx***dfdfvl;d*", '*');
    System.out.println("Symbol Occurance Result = " + symbolOccuranceResult);

    int findWordPositionResult = findWordPosition("Apollo", "lo");
    System.out.println("Find Word Position Result = " + findWordPositionResult);

    String stringReverseResult = stringReverse("Hello");
    System.out.println("String Reverse Result = " + stringReverseResult);

    boolean isPalindromeResult = isPalindrome("ede");
    System.out.println("Is Palindrome Result = " + isPalindromeResult);
  }

  public static int findSymbolOccurance(String str, char symbol) {
    int result = 0;

    for(char c : str.toCharArray()) {
      if (c == symbol) {
        result++;
      }
    }
    return result;
  }

  public static int findWordPosition(String source, String target) {
    return source.indexOf(target);
  }

  public static String stringReverse(String str) {
    if (str.isEmpty()) {
      return str;
    }

    StringBuilder result = new StringBuilder();

    for (int i = str.length() - 1; i >= 0; i--) {
      result.append(str.charAt(i));
    }
    return result.toString();
  }

  public static boolean isPalindrome(String str) {
    if (str.isEmpty()) {
      return false;
    }

    String[] stringArray = str.split("");

    for(int i = 0; i < stringArray.length/2; i++) {
      if (!stringArray[i].equals(stringArray[(stringArray.length - 1) - i])) {
        return false;
      }
    }
    return true;
  }
}
