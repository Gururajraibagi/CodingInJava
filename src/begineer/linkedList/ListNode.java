package begineer.linkedList;



/**
 * Linked List implementation.
 */
class LinkedListAssignment {
    ListNode root;

    /**
     * insert a new node at head of this LinkedList with value = val
     * 
     * @param val value of new node
     */
    void insertHead(int val) {
        // todo implement
    }

    /**
     * insert a new node after a specific value.
     * 
     * @param val insert after a node with value = val
     * @param value value of the new node
     */
    void insertAfter(int val, int value) {

    }

    /**
     * delete the first value with value as val
     * 
     * @param val value to be deleted
     */
    void delete(int val) {
        // todo implement
    }

    /**
     * print this LinkedList
     */
    void print() {
        // todo implement
    }

    /**
     * @param val search for node with value = val in this list
     * @return true/false
     */
    boolean search(int val) {
        // todo implement
        return false;
    }
}


public class ListNode {
    int val;
    ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}


class MyLinkedList {
    ListNode head;

    public MyLinkedList() {
        head = null;
    }

    /*
     * public MyLinkedList(int val) { ListNode node = new ListNode(); node.val = val; node.next =
     * null; }
     */
    public void insertAtBeginning(int val) {
        ListNode node = new ListNode(val);
        // node.val = val;

        if (head != null) {
            node.next = head;
            head = node;
        } else {
            head = node;
        }
    }

    public void insertAtEnd(int data) {
        ListNode node = new ListNode(data);
        if (head != null) {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        } else {
            head = node;
        }
    }

    public void deleteFromBeginning() {
        /*
         * if(head.next == null){ head = null; }else head = head.next;
         */
        if (head != null)
            head = head.next;
    }

    public void deleteFromEnd() {
        if (head == null) {
            return; // List is empty, nothing to delete
        }
        if (head.next == null) {
            head = null; // List has only one node, delete it
        } else {
            ListNode temp = head;
            while (temp.next.next != null) {
                temp = temp.next; // Traverse to the second-last node
            }
            temp.next = null; // Remove the last node
        }
        /*
         * if(head != null){ ListNode temp = head; while (temp.next.next !=null) { temp = temp.next;
         * } temp.next = null; }else{ head = null; }
         */
    }

    public void printAll() {
        /* this.val = val; */
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("null"); // Indicate the end of the list
    }

    public int search(int element) {
        ListNode temp = head;
        /*
         * while (temp.val != element && temp != null) { temp = temp.next; } if (temp !=null) {
         * return temp.val; } return -1;
         */
        while (temp != null) {
            if (temp.val == element) {
                return temp.val; // Return the value if found
            }
            temp = temp.next;
        }
        return -1; // Return -1 (or throw an exception) if the element is not found
    }


}


class LinkedListAssignment1Test {
    public static void main(String[] args) {
        MyLinkedList node = new MyLinkedList();
        node.insertAtBeginning(10);
        node.insertAtBeginning(20);
        node.insertAtEnd(30);
        node.printAll();


        /*
         * node.val = 10; node.next = null; ListNode node2 = new ListNode(20); node.next = node2;
         * node.printAll(node);
         */
        /*
         * o.insertHead(2); o.print(); o.insertHead(3);
         * 
         * o.print(); o.delete(2); o.print(); o.delete(3); System.out.println(o.search(3));
         * o.print();
         */

    }
}
