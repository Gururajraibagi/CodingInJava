package begineer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondMax {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[] {3, 2, 4, 5, 6, 6, 7, 8, 9, 9, 0, 9};
        System.out.println("The nums element is : " + Arrays.toString(nums));


        int[] unique = removeDuplicates(nums);
        int result = findSecondMaxElement(unique);
        System.out.println("The removeDuplicates element is : " + Arrays.toString(unique));
        System.out.println("The Minimum element is : " + result);

    }

    public static int findSecondMaxElement(int[] arr) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int ele : arr) {
            if (ele > firstMax) {
                secondMax = firstMax;
                firstMax = ele;
            } else if (ele > secondMax) {
                secondMax = ele;

            }
        }
        return secondMax;
    }

    public static int[] removeDuplicates(int[] arr) {
        Arrays.sort(arr);
        List<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arrayList.add(arr[i]);
            }
        }

        int[] result = new int[arrayList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }
}
