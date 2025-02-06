package begineer;

public class LinearSearch {
  public static void main(String[] args) throws Exception {
    int[] nums = new int[] {3, 2, 4, 5, 6, 6, 7, 8, 9, 9, 0, 9};
    int result = Linear_Search(nums, 9);
    if (result == -1)
      System.out.println("Number Not found in array");
    else
      System.out.println("Number found in array : " + result);

  }

  public static int Linear_Search(int[] arr, int num) {
    for (int ele : arr) {
      if (ele == num)
        return ele;
    }
    return -1;
  }
}
