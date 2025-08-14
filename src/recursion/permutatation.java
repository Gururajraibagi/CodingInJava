package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutatation {
    int[] nums;
    List<List<Integer>> result;

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2};
        permutatation objPermutatation = new permutatation();
        var obj = objPermutatation.permute(arr).toArray();
        System.out.println(Arrays.toString(obj));

    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        result = new ArrayList<>();
        permuteNumber(0, new ArrayList<>());
        return result;
    }

    public void permuteNumber(int idx, List<Integer> list) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                permuteNumber(idx + 1, list);
                list.removeLast();
            }
        }

    }
}


/*
 * class Solution { int[] nums; List<List<Integer>> result; public List<List<Integer>> permute(int[]
 * nums) { this.nums = nums; result = new ArrayList<>(); permuteNumber(0,new ArrayList<>()); return
 * result; } public void permuteNumber(int idx, List<Integer> list){ if(idx == nums.length){
 * result.add(new ArrayList<>(list)); return; } for(int i = 0; i< nums.length; i++ ){
 * if(!list.contains(nums[i])){ list.add(nums[idx]); permuteNumber(idx + 1,list); list.removeLast();
 * } }
 * 
 * } }
 */

/*
 * 2nd sol
 */
/*
 * class Solution { int[] nums; List<List<Integer>> result; public List<List<Integer>> permute(int[]
 * nums) { this.nums = nums; result = new ArrayList<>(); permuteNumber(0,new ArrayList<>()); return
 * result; } public void permuteNumber(int idx, List<Integer> list){ if(idx == nums.length){
 * result.add(new ArrayList<>(list)); return; } for(int i = idx; i< nums.length; i++ ){
 * //if(!list.contains(nums[i])){ list.add(nums[i]); swap(idx , i); permuteNumber(idx + 1,list);
 * list.removeLast(); swap(idx , i); //} } } public void swap(int i, int j){ int temp = nums[i];
 * nums[i] = nums[j]; nums[j] = temp;
 * 
 * } }
 */
