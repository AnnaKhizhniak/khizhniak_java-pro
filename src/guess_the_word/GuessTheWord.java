package guess_the_word;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
  public static void main(String[] args) {
    String[] words = {"apple", "orange", "lemon", "banana", "apricot",
        "avocado" , "broccoli", "carrot", "cherry", "garlic", "grape",
        "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
        "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
        "potato"};

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int randomIndex = random.nextInt( words.length);
    String secretWord = words[randomIndex];

    while(true) {
      System.out.println("Choose word...");
      String userAnswer = scanner.nextLine().trim();

      if (secretWord.equals(userAnswer)) {
        System.out.println("Good job! the word was [" + secretWord + "]");
        return;
      }

      StringBuilder cachedWord = new StringBuilder();

      for(int i = 0; i < secretWord.length(); i++ ){
        if (i < userAnswer.length() && secretWord.charAt(i) == userAnswer.charAt(i)) {
          cachedWord.append(secretWord.charAt(i));
        } else {
          cachedWord.append('#');
        }
      }

      if (cachedWord.length() < 15) {
        cachedWord.repeat('#', 15 - cachedWord.length());
      }

      System.out.println("The word looks like: " + cachedWord);
    }
  }
}
