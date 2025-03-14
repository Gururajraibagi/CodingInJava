package begineer;

import java.util.Arrays;

public class UpperBoundBinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 5, 8, 15, 19};
        System.out.println("Arrays.binarySearch = " + upperBound(nums, 9));
    }

    public static int upperBound(int[] nums, int x) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}
