package heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));

    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.poll();
    }

}


