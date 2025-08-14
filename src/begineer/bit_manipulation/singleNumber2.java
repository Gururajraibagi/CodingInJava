package begineer.bit_manipulation;

public class singleNumber2 {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 2, 3, 2};
        int[] nums1 = new int[] {1, 2, 1, 3, 2, 5};

        // [0,1,0,1,0,1,99]
        singleNumber(nums1);
    }

    /*
     * 1 10 1 11 10 101
     */
    public static String getBinaryString(int ele) {
        StringBuilder sb = new StringBuilder();
        while (ele > 0) {
            sb.append(ele % 2);
            ele /= 2;
        }
        // System.out.println("sb:" + sb.toS-ring());

        sb.reverse();
        return sb.toString();
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;

        for (int ele : nums) {
            System.out.println(getBinaryString(ele));
        }
        /*
         * for (int i = 0; i < 32; ++i) { int sum = 0; for (final int num : nums) sum += num >> i &
         * 1; sum %= 3; ans |= sum << i; }
         */

        return ans;
    }
}

