package com.google.phone;

public class PlusOneLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode plusOne(ListNode head) {
        int carry = addOne(head);
        if (carry == 0) {
            return head;
        } else {
            ListNode res = new ListNode(carry);
            res.next = head;
            return res;
        }
    }
    
    public int addOne(ListNode head) {
        if (head.next == null) {
            int carry = (head.val + 1) / 10;
            head.val = (head.val + 1) % 10;
            return carry;
        } else {
            int carryIn = addOne(head.next);
            int carryOut = (head.val + carryIn) / 10;
            head.val = (head.val + carryIn) % 10;
            return carryOut;
        }
    }

}
