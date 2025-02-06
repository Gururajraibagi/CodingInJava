package begineer;

public class FindMax {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[] {3, 2, 4, 5, 6, 6, 7, 8, 9, 9, 0, 9};
        int result = findMaxElement(nums);
        System.out.println("The Maximum element is : " + result);

    }

    public static int findMaxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            max = Math.max(ele, max);
        }
        return max;
    }
}
