package linked_list;


public class reverse_linked_list_ii {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public static class Pair {
        ListNode node;
        ListNode rest;
        
        Pair(ListNode node, ListNode rest) {
            this.node = node;
            this.rest = rest;
        }
    }

    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public static ListNode reverseBetween(ListNode head, int m , int n) {
        // runtime: n
        if (head == null || head.next == null) {
            return head;
        }
        
        if (m == 1) {
            Pair pair = reverseFirstN(head, n);
            return pair.node;
        } else {
            head.next = reverseBetween(head.next, m - 1, n - 1);
            return head;
        }
    }
    
    public static Pair reverseFirstN(ListNode head, int n) {
        if (head == null) {
            return new Pair(null, null);
        }
        
        if (head.next == null || n == 1) {
            return new Pair(head, head.next);
        }

        ListNode tail = head.next;
        Pair pair = reverseFirstN(head.next, n - 1);
        ListNode reversed = pair.node;

        tail.next = head;
        head.next = pair.rest;
        return new Pair(reversed, pair.rest);
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
               
        ListNode result = reverseBetween(head, 2, 4);
        
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
