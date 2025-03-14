package begineer.medium;

public class MinimumLimit {
    public static void main(String[] args) {
        System.out.println(minimumLimit(new int[] {9}, 2));

    }

    public static int minimumLimit(int[] nums, int maxOperations) {
        int potential = -1;
        for (int ele : nums) {

            int left = 1;
            int right = ele;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int temp = (int) Math.ceil((double) ele / mid);


                System.out.println("mid:" + mid + " -temp:" + temp);
                if (temp <= maxOperations) {
                    potential = mid;
                    right = mid - 1;;
                } else
                    left = mid + 1;
                System.out.println("left:" + left);

            }
            return potential;
        }
        return 0;
    }
}
