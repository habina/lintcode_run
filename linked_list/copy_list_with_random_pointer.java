package linked_list;

public class copy_list_with_random_pointer {

    public static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    };

    /**
     * @param head:
     *            The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode copy = head;

        // copy each node right after each original node.
        // 1->2->3 => 1->1->2->2->3->3
        while (copy != null) {
            RandomListNode node = new RandomListNode(copy.label);
            // insert node after copy
            node.next = copy.next;
            copy.next = node;

            // advance by 2.
            copy = copy.next.next;
        }

        // copy random pointer
        copy = head;
        while (copy != null) {
            RandomListNode oldNode = copy;
            RandomListNode newNode = copy.next;
            if (oldNode.random != null) {
                // .next is for connecting the new generated node
                newNode.random = oldNode.random.next;
            }
            copy = copy.next.next;
        }
        
        return pickEveryOther(head);
    }
    
    public static RandomListNode pickEveryOther(RandomListNode head) { 
        // 1->1->2->2->3->3 => 1->2->3
        if (head == null || head.next == null) {
            return head;
        }
        
        head.next.next = pickEveryOther(head.next.next);
        return head.next;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(4);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(2);
        RandomListNode n5 = new RandomListNode(5);
        RandomListNode n6 = new RandomListNode(2);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        RandomListNode result = copyRandomList(head);

        while (result != null) {
            System.out.println(result.label);
            result = result.next;
        }
    }

}
