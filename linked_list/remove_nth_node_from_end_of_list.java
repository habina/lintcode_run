package linked_list;

public class remove_nth_node_from_end_of_list {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param head:
     *            The first node of linked list.
     * @param n:
     *            An integer.
     * @return: The head of linked list.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPrev = head;
        
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        
        while (fast != null) {
            fast = fast.next;
            slowPrev = slow;
            slow = slow.next;
        }
        
        slowPrev.next = slow.next;
        // case where delete the head node
        if (head == slow) {
            return slow.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        ListNode result = removeNthFromEnd(head, 2);
        
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
