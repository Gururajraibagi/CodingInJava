package begineer;

import java.util.Arrays;

public class BinarySearch2 {
    public static void main(String[] args) {
        /*
         * int[] array = new int[] {0, 0, 1, 1, 1, 1, 1};
         */
        int[] nums = new int[] {3, 5, 8, 15, 19};
        System.out.println("Arrays.binarySearch = " + Arrays.binarySearch(nums, 9));
        System.out.println(" binarySearch = " + binarySearch(nums, 9));


        // System.out.println(getMatchingFirstElement(array, 1));
    }

    public static int getMatchingFirstElement(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        int potential = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                potential = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return potential == -1 ? 0 : potential;
    }

    public static int binarySearch(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2; // (left + right) / 2;
            if (nums[mid] == target) {
                return mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return left + 1;
    }
}
