package begineer;

public class FindMin {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[] {3, 2, 4, 5, 6, 6, 7, 8, 9, 9, 0, 9};
        int result = findMinElement(nums);
        System.out.println("The Minimum element is : " + result);

    }

    public static int findMinElement(int[] arr) {
        int max = Integer.MAX_VALUE;
        for (int ele : arr) {
            max = Math.min(ele, max);
        }
        return max;
    }
}
