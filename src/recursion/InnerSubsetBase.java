package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InnerSubsetBase {
    int[] array;// = new int[]{1,2,3};
    List<List<Integer>> resuList = new ArrayList<>();

    InnerSubsetBase(int[] arr) {
        this.array = arr;
    }

    public List<List<Integer>> getResuList() {
        return resuList;
    }

    public void findAllSubset(int index, List<Integer> list) {
        if (index == this.array.length) {
            System.out.println(Arrays.toString(list.toArray()));
            resuList.add(new ArrayList<>(list));
            return;
        }
        list.add(this.array[index]);
        // arr[index] = this.array[index];
        findAllSubset(index + 1, list);
        list.removeLast();
        findAllSubset(index + 1, list);

    }
}
