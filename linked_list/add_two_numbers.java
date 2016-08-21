package linked_list;

public class add_two_numbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    

    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public static ListNode addLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        
        while(l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;

            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 != null) {
            append(cur, l1, carry);
        } else if (l2 != null) {
            append(cur, l2, carry);
        } else if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
    
    public static void append(ListNode cur, ListNode lst, int carry) {
        while (lst != null) {
            cur.next = new ListNode((lst.val + carry) % 10);
            carry = (lst.val + carry) / 10;
            cur = cur.next;
            lst = lst.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        head.next = n2;
        n2.next = n3;
        n3.next = null;
        
        ListNode head1 = new ListNode(1);
        ListNode n22 = new ListNode(2);
        ListNode n33 = new ListNode(3);
        head1.next = n22;
        n22.next = n33;
        n33.next = null;
               
        ListNode result = addLists(head, head1);
        
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
