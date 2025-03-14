package begineer.DSA5prefix;

import java.lang.reflect.Array;
import java.util.Arrays;

public class prefixMultiplication {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 0, 5, 6, 7, 8};
        int[][] arrayset = new int[][] {{1, 2}, {2, 3}, {4, 5}, {1, 3}, {0, 1}};
        int sum = 1;
        int[] prefixSum = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sum *= arr[i];
            prefixSum[i] = sum;
        }
        System.out.println(Arrays.toString(prefixSum));

        for (int[] ele : arrayset) {

            System.out.println(getMultiplicationPrefix(ele, prefixSum));
        }
    }

    public static int getMultiplicationPrefix(int[] ele, int[] prefixSum) {
        int i = ele[0] == 0 ? 0 : ele[0] - 1;
        int j = ele[1];

        int res = prefixSum[j] / (prefixSum[i] >= 1 && i != 0 ? prefixSum[i] : 1);
        return res;
    }
}
