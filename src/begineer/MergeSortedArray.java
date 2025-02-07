package begineer;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int m = 3, n = 3;
        int[] nums2 = new int[] {2, 5, 6};

        int index = 0;
        int[] result = new int[n + m];
        int right = 0, left = 0;
        while (left < m || right < n) {
            if (nums1[right] < nums2[left] && right < n) {
                result[index++] = nums1[right];
                right++;
            } else {/* if (nums2[left] < nums1[right]) { */
                result[index++] = nums2[left];
                left++;
            } //

        }
        System.out.println(Arrays.toString(result));
    }


    /*
     * int i = m - 1; // Pointer for nums1's end (valid elements) int j = n - 1; // Pointer for
     * nums2's end int k = m + n - 1; // Pointer for merged array's end
     * 
     * // Merge from the end while elements exist in both arrays while (i >= 0 && j >= 0) { if
     * (nums1[i] > nums2[j]) { nums1[k--] = nums1[i--]; } else { nums1[k--] = nums2[j--]; } }
     * 
     * // Copy remaining elements from nums2 if any while (j >= 0) { nums1[k--] = nums2[j--]; }
     */
}
