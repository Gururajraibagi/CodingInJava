package begineer.medium;

public class CocoEatingBanana {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = piles[piles.length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;

            }
        }
        return left - 1;
    }

    public static boolean canEat(int[] piles, int n, int h) {
        int sum = 0;
        for (int ele : piles) {
            sum += (ele + n - 1) / n;
            // n/ele;
        }
        return sum < h;// Integer.MIN_VALUE
    }

    public static void main(String[] args) {
        int[] arr = new int[] {30, 11, 23, 4, 20};
        int h = 6;
        System.out.println(minEatingSpeed(arr, h));
    }
}
