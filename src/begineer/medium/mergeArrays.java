package begineer.medium;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] nums1 = new int[][] {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = new int[][] {{1, 4}, {3, 2}, {4, 1}};
        for (int[] ele : mergeArrays(nums1, nums2)) {
            System.out.println(Arrays.toString(ele));
        }
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int left = 0;
        int right = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (left < nums1.length && right < nums2.length) {
            int id1 = nums1[left][0];
            int id2 = nums2[right][0];
            int s1 = nums1[left][1];
            int s2 = nums2[right][1];
            ArrayList<Integer> temp = new ArrayList<>();
            if (id1 == id2) {
                temp.add(id1);
                temp.add(s1 + s2);
                left++;
                right++;
            } else if (id1 < id2) {
                temp.add(id1);
                temp.add(s1);
                left++;
            } else {
                temp.add(id2);
                temp.add(s2);
                right++;
            }
            list.add(temp);
        }
        int[][] array = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> row = list.get(i);
            array[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                array[i][j] = row.get(j); // Auto-unboxing Integer to int
            }
        }
        return array;// list.toArray(new int[0][0]);
    }
}
