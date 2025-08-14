package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class backtracking {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        backtracking oBacktracking = new backtracking();
        System.out.println(Arrays.toString(oBacktracking.permute(arr).toArray()));;


    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> path, boolean[] used,
            List<List<Integer>> result) {
        // Base case
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip used elements
            if (used[i])
                continue;

            // Make choice
            path.add(nums[i]);
            used[i] = true;

            // Explore
            backtrack(nums, path, used, result);

            // Undo choice (backtrack)
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

}
