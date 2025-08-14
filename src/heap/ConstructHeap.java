package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructHeap {
    static int positionToInsert;
    static ArrayList<Integer> result;// = new ArrayList<>();
    static int arrLen;

    /*
     * ConstructHeap(){ this.positionToInsert = 0;
     * 
     * }
     */
    public static void main(String[] args) {
        int[] arr = new int[] {20, 30, 23, 10, 5, 100, 70};
        // List<Integer> obj = Arrays.asList(arr)//new ArrayList<>(List.of(arr));
        List<Integer> lst = List.of(20, 30, 23, 10, 5, 100, 70);
        arrLen = lst.size();
        myConstructHeap(new ArrayList<>(lst));
    }

    public static void myConstructHeap(ArrayList<Integer> arr) {
        result = new ArrayList<>();
        positionToInsert = -1;
        for (int i = 0; i < arr.size(); i++) {
            // arr.get(i);
            insertIntoHeap(arr.get(i));
            // result.add(temp);

        }
        System.out.println(result.toString());
    }

    public static void insertIntoHeap(int ele) {
        // int a =positionToInsert;

        /*
         * if(arrLen == positionToInsert) return;// ?
         */ // do we need this function?
        /*
         * if (positionToInsert < 0) { positionToInsert++; result.add(ele); return; } else { // list
         * is not empty // insert into result and capture the parent and compare result.add(ele);
         * positionToInsert++; // compare with root node // 2 * (i -1) int parent = (int)
         * Math.floor((positionToInsert - 1) / 2);// 2 * (positionToInsert - 1);
         * 
         * int tempIndex = positionToInsert;
         * 
         * while (result.get(parent) > result.get(tempIndex)) { // swap int temp =
         * result.get(parent); result.set(parent, result.get(tempIndex)); result.set(tempIndex,
         * temp); tempIndex = parent; parent = (int) Math.floor((parent - 1) / 2); }
         * 
         * 
         * } return;
         */
        result.add(ele); // Add the new element to the end of the heap
        int currentIndex = result.size() - 1; // Index of the newly added element

        // Bubble up the element to maintain the min-heap property
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (result.get(parentIndex) <= result.get(currentIndex)) {
                break; // Heap property is satisfied
            }
            // Swap with parent
            swap(parentIndex, currentIndex, result);
            currentIndex = parentIndex; // Move up to the parent's index
        }
    }

    private static void swap(int i, int j, ArrayList<Integer> heap) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

