public class ArrayValueCalculator {
  private static final int SIZE = 4;

  public static void main(String[] args) throws ArraySizeException, ArrayDataException {
    String[][] calculatedArray = {
        {"1", "2", "3", "4"},
        {"1", "2", "3", "4"},
        {"1", "2", "3", "4"},
        {"1", "2", "3", "4"},
    };


    try {
     int result = doCalc(calculatedArray);
      System.out.println("Result = " + result);
    } catch (ArraySizeException | ArrayDataException e) {
      e.printStackTrace();
    }
  }


  public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
    if (array.length != 4) {
      throw new ArraySizeException("The current array size does not satisfied the current array size rule! Array should has the size [" + SIZE + "][" + SIZE + "]");
    }

    for (String[] row : array) {
      if (row.length != 4) {
        throw new ArraySizeException("The current array size does not satisfied the current array size rule! Array should has the size [" + SIZE + "][" + SIZE + "]");
      }
    }

    int result = 0;

    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        try {
          int parsedValue = Integer.parseInt(array[row][col]);
          result += parsedValue;
        } catch (NumberFormatException e) {
          throw new ArrayDataException("The data in cell [" + row + "][" + col + "] is can not be parsed.", e);
        }
      }
    }
    return result;
  }
}
