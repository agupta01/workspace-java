import java.util.Scanner;

public class CodeFightReplace {

  public static int arraySize;

  public static void main(String[] args) {
    input();
    int[] numberSeries = new int[arraySize];
    String[] replaced = new String[arraySize];
    fill(numberSeries);
    replace(numberSeries, replaced);

    for (int i = 0; i < arraySize; i++) {
      System.out.print(replaced[i] + " ");
    }
    System.out.println("");
  }

  public static void input() {
    Scanner inputLimit = new Scanner(System.in);
    System.out.print("Enter the upper limit: ");
    int upLimit = inputLimit.nextInt();

    arraySize = upLimit;
  }

  public static void fill(int[] numberSeries) {
    for (int i = 0; i < arraySize; i++) {
      numberSeries[i] = i + 1;
    }
  }

  public static void replace(int[] numberSeries, String[] replaced) {
    for (int i = 0; i < arraySize; i++) {
      if (numberSeries[i] % 5 == 0) {
        if (numberSeries[i] % 7 == 0) {
          replaced[i] = "CodeFight";
        } else {
          replaced[i] = "Code";
        }
      } else if (numberSeries[i] % 7 == 0) {
        if (numberSeries[i] % 5 == 0) {
          replaced[i] = "CodeFight";
        } else {
          replaced[i] = "Fight";
        }
      } else {
        replaced[i] = Integer.toString(numberSeries[i]);
      }
    }
  }
}
