package begineer.linkedList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
import begineer.linkedList.ListNode;
import begineer.linkedList.MyLinkedList;

class RemoveNthFromEnd {
    public static void main(String[] args) {

        int[] arr = new int[] {1, 2, 3, 4, 5};
        int n = 2;
        /* ListNode head = new ListNode(); */
        MyLinkedList obj = new MyLinkedList();
        for (int ele : arr) {
            obj.insertAtEnd(ele);
        }
        obj.printAll();
        ListNode op = removeNthFromEnd(obj.head, n);
        obj.head = op;
        obj.printAll();

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode left = dummy;
        ListNode right = dummy;
        for (int i = 0; i <= n; i++) { // move till n+1
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        System.out.println("dummy.next" + dummy.next);
        System.out.println("head" + head);

        return dummy.next;
    }
}
