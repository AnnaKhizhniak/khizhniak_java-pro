import java.util.Arrays;

public class ValueCalculator {
  private static final int ARR_SIZE = 1_000_000;
  private static final int ARR_SIZE_HALF = ARR_SIZE / 2;
  private static final float[] numbersArray = new float[ARR_SIZE];

  public static void main(String[] args) {
    try {
      arrayParse();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println("Thread was interrupted");
    }
  }

  public static void arrayParse() throws InterruptedException {
    long start = System.currentTimeMillis();

    for (int i = 0; i < ARR_SIZE; i++) {
      numbersArray[i] = 1;
    }

    float[] subarray1 = new float[ARR_SIZE_HALF];
    System.arraycopy(numbersArray, 0, subarray1, 0, ARR_SIZE_HALF);
    float[] subarray2 = new float[ARR_SIZE_HALF];
    System.arraycopy(numbersArray, ARR_SIZE_HALF, subarray2, 0, ARR_SIZE_HALF);

    Thread thread1 = new Thread(() -> {
      for(int i = 0; i < subarray1.length; i++) {
        subarray1[i] = (float)(subarray1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < subarray2.length; i++) {
        subarray2[i] = (float)(subarray2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
      }
    })  ;

    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();

    System.arraycopy(subarray1, 0, numbersArray, 0, ARR_SIZE_HALF);
    System.arraycopy(subarray2, 0, numbersArray, ARR_SIZE_HALF, ARR_SIZE_HALF);

    long finish = System.currentTimeMillis();

    System.out.println("Total calculation time: " + (finish - start) + " millisec");

  }

}
