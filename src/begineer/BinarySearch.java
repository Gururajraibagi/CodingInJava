package begineer;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(binarySearch(nums, target));
    }

    public static int binarySearch(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return -1;
    }
}
