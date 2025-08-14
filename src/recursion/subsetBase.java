package recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class subsetBase {
    int[] arr = new int[] {1, 2, 3};

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        // findAllSubset(0,arr);
        InnerSubsetBase oBase = new InnerSubsetBase(arr);
        oBase.findAllSubset(0, new ArrayList<>());
        System.out.println(Arrays.toString(oBase.getResuList().toArray()));// oBase.getResuList();
    }

}


