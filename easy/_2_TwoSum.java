package simple;

/*
 * Problem: Add Two Numbers Represented by Linked Lists
 * 
 * Given two numbers represented by linked lists (each node contains a single digit),
 * add the two numbers and return the sum as a linked list. The digits are stored in reverse
 * order, with the 1's digit at the head of the list.
 * 
 * Solution Approach:
 * 1. Traverse both linked lists node by node, summing up corresponding nodes and handling carry.
 * 2. Create a new node for each sum, and link them to form the result list.
 * 3. Continue until both lists are processed and handle any carry left at the end.
 */

class ListNode {
    int data;
    ListNode next;

    // Constructor with data
    public ListNode(int d) {
        this.data = d;
        this.next = null;
    }

    // Default constructor
    public ListNode() {}

    // Append a new node with given value at the end of the list
    public void append(int n) {
        ListNode current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(n);
    }

    // Utility method to print the linked list
    public void printList() {
        ListNode current = this;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to add two numbers represented by linked lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // Dummy head for the result list
        ListNode p = l1, q = l2, current = dummy;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.data : 0;  // Get data from l1, or 0 if l1 is null
            int y = (q != null) ? q.data : 0;  // Get data from l2, or 0 if l2 is null
            int sum = carry + x + y;

            carry = sum / 10;  // Calculate carry for the next iteration
            current.next = new ListNode(sum % 10);  // Create new node for the digit

            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        // If there is a carry left, add a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;  // Return the next of dummy node which is the actual head
    }
}

public class Two_TwoSum {

    static int remainder(int r) { return r % 10; }

    static int dividend(int d) { return d / 10; }

    public static void main(String[] args) {

        // Creating the 1st reversed ListNode from integer n1
        int n1 = 304;
        ListNode l1 = new ListNode(remainder(n1));
        n1 = dividend(n1);
        l1.append(remainder(n1));
        n1 = dividend(n1);
        l1.append(remainder(n1));
        System.out.print("First List: ");
        l1.printList();

        // Creating the 2nd reversed ListNode from integer n2
        int n2 = 456;
        ListNode l2 = new ListNode(remainder(n2));
        n2 = dividend(n2);
        l2.append(remainder(n2));
        n2 = dividend(n2);
        l2.append(remainder(n2));
        System.out.print("Second List: ");
        l2.printList();

        // Adding both ListNodes and storing in a new ListNode
        ListNode l3 = new ListNode();
        l3 = l3.addTwoNumbers(l1, l2);
        System.out.print("Sum List: ");
        l3.printList();
    }
}
