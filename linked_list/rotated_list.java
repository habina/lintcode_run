package linked_list;

public class rotated_list {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int length = getLength(head);
        k = k % length;
        if (k == 0) {
            return head;
        }
        
        int step = length - k;
        ListNode newHead = kThNode(head, step);
        ListNode tail = getTail(newHead);
        
        while (step > 0) {
            tail.next = head;
            tail = tail.next;
            head = head.next;
            step--;
        }
        
        tail.next = null;
        return newHead;
    }
    
    public static ListNode kThNode(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        return kThNode(head.next, k - 1);
    }
    
    public static ListNode getTail(ListNode head) {
        if (head.next == null) {
            return head;
        }
        return getTail(head.next);
    }
    
    public static int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + getLength(head.next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
               
        ListNode result = rotateRight(head, 3);
        
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
