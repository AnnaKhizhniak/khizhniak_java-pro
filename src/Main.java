import java.util.Arrays;
import java.util.Collection;

public class Main implements CollectionList {
  String[] strArray = new String[10];
  int size = 0;

  public static void main(String[] args) {
  Main main = new Main();
  main.add("12345678901");
  main.add(1, "fgh");
    main.add(3, "#$%^&*");
    main.add(2, "---");
    main.add("12345678901");
  }

  @Override
  public boolean add(String o) {
    if (o.isEmpty()) {
      return false;
    }

    while (this.size() + o.length() > this.strArray.length) {
      this.strArray = copy(this.strArray);
    }

    for(int i = 0; i < o.length(); i++) {
        this.strArray[this.size()] = Character.toString(o.charAt(i));
        this.size++;
        System.out.println("Array" + Arrays.toString(this.strArray));
    }
    return true;
  }

  private static String[] copy(String[] array) {
    final double MAX_COEF = 0.75;
    int newLength = Math.max(array.length, (int) Math.ceil(array.length/MAX_COEF));
    String[] newArray = new String[newLength];
    System.out.println("Length newArray - " + newArray.length);
    for (int j = 0; j < array.length; j++) {
      newArray[j] = array[j];
    }

    return newArray;
  }

  @Override
  public boolean add(int index, String o) {
    if (o.isEmpty()) {
      return false;
    }

    while (this.size() + o.length() > this.strArray.length) {
      this.strArray = copy(this.strArray);
      System.out.println("Length - " + this.strArray.length);
    }

    for (int i = this.size - 1; i >= index; i--) {
        this.strArray[i + o.length()] = this.strArray[i];
    }

    for (int i = 0; i < o.length(); i++) {
      this.strArray[index + i] = Character.toString(o.charAt(i));
    }
    this.size += o.length();

    System.out.println("Array + " + Arrays.toString(this.strArray));
    return false;
  }

  @Override
  public boolean set(int index, String o) {
    return false;
  }

  @Override
  public boolean delete(String o) {
    return false;
  }

  @Override
  public String get(int index) {
    return "";
  }

  @Override
  public boolean contain(String o) {
    return false;
  }

  @Override
  public boolean equals(Collection collection) {
    return false;
  }

  @Override
  public boolean clear() {
    return false;
  }

  @Override
  public int size() {
    return this.size;
  }
}

/*
Реалізувати просту динамічну колекцію для String на основі масиву використовуючи Interface:

public interface CollectionList {
    boolean add(String o); - add element
    boolean add(int index, String o); - add element by index
    bollean set(int index, String o)
    boolean delete (String o); -
    String get(int index);
    boolean contain(String o);
    boolean equals (Collection collection);
    boolean clear();
    int size();
}

String[] strArray = new String[10];
int size = 0;

 0  1  2  3  4  5  6  7  8  9
[ ][ ][ ][ ][ ][ ][ ][ ][ ][ ] ->> null

add 3
 0  1  2  3  4  5  6  7  8  9
[x][x][x][ ][ ][ ][ ][ ][ ][ ]

add 8
 0  1  2  3  4  5  6  7  8  9
[x][x][x][x][x][x][x][x][x][x] x

 0  1  2  3  4  5  6  7  8  9  10
[x][x][x][x][x][x][x][x][x][x][ x][][][][][][][]

system array copy prohibited
 */
