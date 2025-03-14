package begineer;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5, 6};
        int target = 5;

        System.out.println(searchInsertPosition(nums, target));
    }

    public static int searchInsertPosition(int[] nums, int target) {
        int left = 0;;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return mid;
    }
}
