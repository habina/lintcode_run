package linked_list;

public class reverse_linked_list {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public static ListNode reverse(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        
//        ListNode reversed = reverse(head.next);
//        appendToEnd(reversed, head);
//        return reversed;
        
        // faster
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode tail = head.next;
        ListNode reversed = reverse(head.next);

        tail.next = head;
        head.next = null;
        return reversed;
    }
    
    public static void appendToEnd(ListNode head, ListNode node) {
        while (head.next != null) {
            head = head.next;
        }
        
        head.next = node;
        node.next = null;
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
               
        ListNode result = reverse(head);
        
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
