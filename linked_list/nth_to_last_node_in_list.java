package linked_list;

public class nth_to_last_node_in_list {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    public static ListNode nthToLast(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
               
        ListNode result = nthToLast(head, 3);
        
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
