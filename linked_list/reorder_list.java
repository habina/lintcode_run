package linked_list;

public class reorder_list {

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
     * @return: void
     */
    public static void reorderList(ListNode head) {  
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode middleNode = findMiddleNode(head);
        ListNode reverseMiddleAfter = reverseList(middleNode.next);
        
        middleNode.next = null;
        
        interleaveMerge(head, reverseMiddleAfter);
    }
    
    public static ListNode interleaveMerge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
        
        // stack overflow in recursive way to interleave merge
//        ListNode aNext = a.next;
//        ListNode bNext = b.next;
//        a.next = b;
//        b.next = interleaveMerge(aNext, bNext);
//        return a;
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (a != null && b != null) {
            ListNode aNext = a.next;
            ListNode bNext = b.next;
            cur.next = a;
            a.next = b;
            cur = b;
            a = aNext;
            b = bNext;
        }
        
        if (a != null) {
            cur.next = a;
        } else if (b != null) {
            cur.next = b;
        }
        
        return dummy.next;
    }
    
    // Memory overflow using recursive way
//    public static ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        
//        ListNode tail = head.next;
//        ListNode reversed = reverseList(head.next);
//
//        tail.next = head;
//        head.next = null;
//        
//        return reversed;
//    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode res = null;
        while (head != null) {
            ListNode headNext = head.next;
            head.next = res;
            res = head;
            head = headNext;
        }
        return res;
    }
    
    public static ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
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

        reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
