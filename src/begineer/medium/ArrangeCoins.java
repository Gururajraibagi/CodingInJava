package begineer.medium;

public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
    }

    public static int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        int potential = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int stairs = (mid * (mid + 1)) / 2;
            if (stairs <= n) {
                potential = mid;
                left = mid + 1;
            } else
                right = mid - 1;

        }
        System.out.println("potential" + potential);
        System.out.println("left" + left);

        return potential;
    }
}
