package com.google.phone;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(1, new Comparator<ListNode>() {
            
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
            
        });

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        
        return dummy.next;
        
    }

}
