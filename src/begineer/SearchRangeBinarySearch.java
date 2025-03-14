package begineer;

import java.util.Arrays;

public class SearchRangeBinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[] {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0, len = nums.length - 1;
        int right = len;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {// leftmost //lowerbount
                right = mid - 1;
            } else
                left = mid + 1;
        }
        int potential = left;
        left = 0;
        right = len;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {// RIGHTMOST //UPPERboUND
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return new int[] {potential, left};
        // return new int[]{-1,-1};
    }
}
