package begineer.medium;

public class cocoeatingpractive {
    public static void main(String[] args) {
        System.out.println(
                minimumRateToEatBananas(new int[] {805306368, 805306368, 805306368}, 1000000000));
    }

    public static int minimumRateToEatBananas(int[] nums, int h) {

        int left = 1;
        int right = h;
        int potential = -1;
        int max = -1;
        for (int ele : nums) {
            max = Math.max(ele, max);
        }
        while (left <= right) {
            int sum = 0;
            int mid = left + (right - left) / 2;

            for (int ele : nums) {
                sum += (int) Math.ceil((double) ele / mid);
            }
            if (sum <= h) {
                potential = mid;
                right = mid - 1;
            } else {
                left = mid + 1;

            }
        }
        return potential;
    }
}
