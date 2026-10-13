public class HomeWorkApp {
  public static void main(String[] args) {
    printThreeWords();
    checkSumSign();
    printColor();
    compareNumbers();

    boolean checkNumbersSumResult = checkNumbersSum(10, 11);
    System.out.println("Check numbers sum result: " + checkNumbersSumResult);

    checkPositiveOrNegativeNumber(-8);

    boolean isNegativeNumberResult = isNegativeNumber(5);
    System.out.println("Is negative number result: " + isNegativeNumberResult);

    printRepetitiveString(10, "Hello");

    boolean isLeapYearResult = isLeapYear(2026);
    System.out.println("Is leap year result: " + isLeapYearResult);

  }

  public static void printThreeWords() {
    String[] fruits = {"Orange", "Banana", "Apple"};

    for(String f : fruits) {
      System.out.println(f);
    }
  }

  public static void checkSumSign() {
    int a = -50;
    int b = 25;
    int sum = a + b;

    if (sum >= 0) {
      System.out.println("Positive sum");
    } else {
      System.out.println("Negative sum");
    }
  }

  public static void printColor() {
    int value = -100;

    if (value <= 0) {
      System.out.println("Red");
    } else if (value <= 100) {
      System.out.println("Yellow");
    } else {
      System.out.println("Green");
    }
  }

  public static void compareNumbers() {
    int a = 10;
    int b = -20;
    if (a >= b) {
      System.out.println("a >= b");
    } else {
      System.out.println("a < b");
    }
  }

  public static boolean checkNumbersSum(int num1, int num2) {
    int sum = num1 + num2;
    return sum >= 10 && sum <= 20;
  }

  public static void checkPositiveOrNegativeNumber(int num) {
    if (num >= 0) {
      System.out.println("Positive number");
    } else {
      System.out.println("Negative number");
    }
  }

  public static boolean isNegativeNumber(int num) {
    return num < 0;
  }

  public static void printRepetitiveString(int count, String value) {
    for (int i = 0; i < count; i++) {
      System.out.println(value);
    }
  }

  public static boolean isLeapYear(int year) {
    return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
  }
}