package heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private ArrayList<Integer> heap;

    // Constructor: builds the heap from an array (or list) of integers.
    public MinHeap(List<Integer> array) {
        // Copy the input list into our dynamic ArrayList and build the heap.
        this.heap = buildHeap(new ArrayList<>(array));
    }

    // Convert an unordered list into a valid min-heap.
    private ArrayList<Integer> buildHeap(ArrayList<Integer> array) {
        int firstParentIdx = (array.size() - 2) / 2;
        // Start at the last parent and move upward.
        for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
            siftDown(currentIdx, array.size() - 1, array);
        }
        return array;
    }

    // Sifts down the value at currentIdx until the min-heap property is restored.
    private void siftDown(int currentIdx, int endIdx, ArrayList<Integer> heap) {
        int childOneIdx = currentIdx * 2 + 1;
        // Continue while the node has at least one child.
        while (childOneIdx <= endIdx) {
            // Determine index of the second child if it exists.
            int childTwoIdx = (currentIdx * 2 + 2) <= endIdx ? currentIdx * 2 + 2 : -1;
            int idxToSwap;
            if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
                idxToSwap = childTwoIdx;
            } else {
                idxToSwap = childOneIdx;
            }

            // If the selected child is smaller than the current node, swap them.
            if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                swap(currentIdx, idxToSwap, heap);
                currentIdx = idxToSwap;
                childOneIdx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    // Sifts up the value at currentIdx until the min-heap property is restored.
    private void siftUp(int currentIdx, ArrayList<Integer> heap) {
        int parentIdx = (currentIdx - 1) / 2;
        // As long as the current node is not the root and is smaller than its parent.
        while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
            swap(currentIdx, parentIdx, heap);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }

    // Returns the smallest element in the heap (the root) without removing it.
    public int peek() {
        return heap.get(0);
    }

    // Removes and returns the smallest element (the root) of the heap.
    public int remove() {
        // Swap the root with the last element.
        swap(0, heap.size() - 1, heap);
        // Remove and save the element that was at the root.
        int valueToRemove = heap.remove(heap.size() - 1);
        // Restore the min-heap property starting from the root.
        siftDown(0, heap.size() - 1, heap);
        return valueToRemove;
    }

    // Inserts a new value into the heap.
    public void insert(int value) {
        // Add the new value at the end.
        heap.add(value);
        // Bubble it up to maintain the heap property.
        siftUp(heap.size() - 1, heap);
    }

    // Helper function that swaps the elements at indices i and j.
    private void swap(int i, int j, ArrayList<Integer> heap) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // For visualization: displays the current state of the heap.
    public void printHeap() {
        System.out.println(heap);
    }

    // A simple main method to test and visualize the operations.
    public static void main(String[] args) {
        // Initialize with an unsorted list.
        List<Integer> array = List.of(8, 12, 15, 30, 20, 40, 50);
        MinHeap minHeap = new MinHeap(array);

        System.out.println("Built Heap:");
        minHeap.printHeap(); // Visualize the heap

        // Insert a new value.
        System.out.println("After inserting 4:");
        minHeap.insert(4);
        minHeap.printHeap();

        // Peek at the minimum element.
        System.out.println("Peek (smallest element): " + minHeap.peek());

        // Remove the smallest element.
        int removedValue = minHeap.remove();
        System.out.println("Removed value: " + removedValue);
        System.out.println("After removal:");
        minHeap.printHeap();
    }
}
