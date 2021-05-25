import java.util.Scanner;

/**
* The Magic program implements an application that
* solves all order three Magic Squares.
*
* @author  Marcus A. Mosley
* @version 1.0
* @since   2021-05-25
*/
class Magic {
  
  /**
  * The printArr method prints the solved arrays.
  */
  public static void printArr(int[] arr) {
    // prints inputted array in a magic square format
    System.out.println("\n*****");
    for (int count = 0; count < arr.length; count++) {
      if (count == 3 || count == 6) {
        System.out.println();
        System.out.print(arr[count] + " ");
      } else {
        System.out.print(arr[count] + " ");
      }
    }
    System.out.println("\n*****");
  }

  /**
  * The test method checks if an array is a magic square.
  */
  public static boolean test(int[] arr) {
    final int num = 15;
    int row1 = arr[0] + arr[1] + arr[2];
    int row2 = arr[3] + arr[4] + arr[5];
    int row3 = arr[6] + arr[7] + arr[8];
    int col1 = arr[0] + arr[3] + arr[6];
    int col2 = arr[1] + arr[4] + arr[7];
    int col3 = arr[2] + arr[5] + arr[8];
    int diag1 = arr[0] + arr[4] + arr[8];
    int diag2 = arr[2] + arr[4] + arr[6];

    if (row1 == num && row2 == num && row3 == num && col1 == num && col2 == num
        && col3 == num && diag1 == num && diag2 == num) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
  * The Swap method permutes the array.
  */
  public static int[] swap(int[] arr, int id1, int id2) {
    int tmp = arr[id1];
    arr[id1] = arr[id2];
    arr[id2] = tmp;
    return arr;
  }
  
  /**
  * The Solve method solves for the squares.
  */
  public static void solve(int[] arr, int pos) { 
    if (pos == 8) {
      if (test(arr)) {
        printArr(arr);
      }
    } else {
      for (int i = pos; i < 9; i++) {
        arr = swap(arr, pos, i);
        solve(arr, pos + 1);
        arr = swap(arr, pos, i); 
      }
    }
  }

  /**
  * The Main method receives input and checks viability.
  */
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    // Process
    System.out.printf("All of the order 3 Magic Squares: \n");
    solve(arr, 0);

    // Output
    System.out.printf("\nSolved");
  }
}
