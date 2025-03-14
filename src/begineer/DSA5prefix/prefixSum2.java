package begineer.DSA5prefix;

public class prefixSum2 {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 4, 5, 6, 7, 8};
        int[][] arrayset = new int[][] {{1, 2}, {2, 3}, {4, 5}};
        int sum = 0;
        int[] prefixSum = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            prefixSum[i] = sum;
        }
        for (int[] ele : arrayset) {

            System.out.println(getSumPrefix(ele, prefixSum));
        }
    }

    public static int getSumPrefix(int[] ele, int[] prefixSum) {
        int i = ele[0] >= 0 ? ele[0] - 1 : 0;
        int j = ele[1];

        int res = prefixSum[j] - prefixSum[i];
        return res;
    }
}
