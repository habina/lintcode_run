package linked_list;

public class remove_duplicates_from_sorted_list {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // runtime: n
        // recursive way
//        if (head == null || head.next == null) {
//            return head;
//        }
//        
//        if (head.val == head.next.val) {
//            return deleteDuplicates(head.next);
//        } else {
//            head.next = deleteDuplicates(head.next);
//            return head;
//        }
        
        // for loop way
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }  

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
               
        ListNode result = deleteDuplicates(head);
        
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
