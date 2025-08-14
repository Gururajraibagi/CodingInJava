package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetSum {
    static List<Integer> lst;

    public static void main(String[] args) {
        int arr[] = new int[] {3, 34, 4, 12, 5, 2};
        // int arr[] = new int[] {3, 34, 4};
        int sum = 9;
        lst = new ArrayList<>();
        subsetSum subsetSum = new subsetSum();
        subsetSum.soln(0, arr, 0, new ArrayList<>());
    }

    public void soln(int idx, int[] arr, int sum, List<Integer> lst) {

        if (idx > arr.length - 1) {
            System.out.println(Arrays.toString(lst.toArray()) + " - sum: " + sum);
            return;
        }
        /* if(sum == 9 ) */
        lst.add(arr[idx]);
        sum += arr[idx];
        soln(idx + 1, arr, sum, lst);
        sum -= arr[lst.size() - 1];
        lst.removeLast();
        soln(idx + 1, arr, sum, lst);

    }
}
