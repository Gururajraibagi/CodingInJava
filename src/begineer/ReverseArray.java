package begineer;

import java.util.Arrays;

public class ReverseArray {
  public static void main(String[] args) throws Exception {
    int[] nums = new int[] {3, 2, 4, 5, 6, 6, 7, 8, 9, 9, 0, 9};

    System.out.println("Reversed array  : " + Arrays.toString(reverseArray(nums)));
    System.out.println("Original nums after change  : " + Arrays.toString((nums)));
    System.out
        .println("Reversed array with Optmized : " + Arrays.toString(reverseArrayOptmized(nums)));


  }

  public static int[] reverseArray(int[] arr) {
    int[] newArr = new int[arr.length];
    int index = 0;
    for (int i = arr.length - 1; i >= 0; i--) {
      newArr[index++] = arr[i];
    }
    return newArr;
  }

  public static int[] reverseArrayOptmized(int[] arr) {

    int left = arr.length - 1, right = 0;
    while (right < left) {
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left--;
      right++;
    }

    return arr;
  }
}
