package linked_list;

public class convert_sorted_list_to_balanced_bst {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }
        
        ListNode midPrev = findMidPrevNode(head);
        ListNode mid = midPrev.next;
        TreeNode root = new TreeNode(mid.val);
        midPrev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
    
    public static ListNode findMidPrevNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode slowPrev = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slowPrev;
    }
    
    public static void printBST(TreeNode root, String prefix) {
        if (root == null) {
            return;
        }
        
        System.out.println(prefix + root.val);
        printBST(root.left, prefix + "---");
        printBST(root.right, prefix + "---");
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

        TreeNode result = sortedListToBST(head);

        printBST(result, "");
    }

}
