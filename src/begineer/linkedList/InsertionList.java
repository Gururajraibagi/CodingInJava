/*
 * package begineer.linkedList;
 * 
 * public class InsertionList { public class ListNode { int val; ListNode next;
 * 
 * ListNode() {}
 * 
 * ListNode(int val) { this.val = val; }
 * 
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
 * 
 * public static void main(String[] args) { ListNode node = new ListNode(4);
 * 
 * ListNode node1 = new ListNode(2); node.next = node1; ListNode node2 = new ListNode(1); node1.next
 * = node2;
 * 
 * ListNode node3 = new ListNode(3); node2.next = node3;
 * 
 * ListNode res = insertionSortList(node); }
 * 
 * public static ListNode insertionSortList(ListNode head) { ListNode dummy = new ListNode();
 * ListNode curr; curr = head; /* dummy.next = head; while (curr != null) { ListNode prev = dummy;
 * while (prev.next != null && prev.next.val <= curr.val) { prev = prev.next; } ListNode next =
 * curr.next; curr.next = prev.next; prev.next = curr;
 * 
 * curr = next; } return dummy.next; } }
 */
