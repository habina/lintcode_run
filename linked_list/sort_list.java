package linked_list;

public class sort_list {

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
     *            The head of linked list.
     * @return: You should return the head of the sorted linked list, using
     *          constant space complexity.
     */
    public static ListNode sortList(ListNode head) {
        // runtime: nlogn, space: n
         return mergeSort(head);
    }
    
    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode middle = middleNode(head);
        ListNode right = middle.next;
        middle.next = null;
        
        ListNode leftSorted = mergeSort(head);
        ListNode rightSorted = mergeSort(right);

        return mergeTwoSortedList(leftSorted, rightSorted);
    }
    
    public static ListNode mergeTwoSortedList(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                cur = cur.next;
                a = a.next;
            } else {
                cur.next = b;
                cur = cur.next;
                b = b.next;
            }
        }
        
        if (a != null) {
            cur.next = a;
        } else if (b != null) {
            cur.next = b;
        }
        
        return dummy.next;
    }
    
    public static ListNode middleNode(ListNode head) {
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

        ListNode result = sortList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
