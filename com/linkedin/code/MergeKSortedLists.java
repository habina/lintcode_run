package com.linkedin.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    // Definition for ListNode.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
        
    }
    
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new NodeComparator());
        
        // initialize pq
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            cur.next = minNode;
            cur = cur.next;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        
        return res.next;
    }
    
    public static class NodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
        
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        
        
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(6);
        e.next = f;
        f.next = g;
        

        ListNode h = new ListNode(7);

        ListNode i = new ListNode(8);
        ListNode j = new ListNode(9);
        ListNode k = new ListNode(10);
        i.next = j;
        j.next = k;
        
        List<ListNode> lists = new ArrayList<ListNode>();
        
        lists.add(a);
        lists.add(e);
        lists.add(h);
        lists.add(i);
        lists.add(null);
        
        ListNode res = mergeKLists(lists);
        
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
