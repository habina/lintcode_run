package com.google.phone;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    
    class Node {
        int val;
        int leftCount;
        int selfCount;
        Node left;
        Node right;
        
        public Node(int val) {
            this.val = val;
            this.leftCount = 0;
            this.selfCount = 1;
        }
    }
    
    class BST {
        Node root;
        
        public BST(int val) {
            this.root = new Node(val);
        }
        
        public int insert(int val) {
            int count = 0;
            Node cur = root;

            while (cur != null) {
                if (val < cur.val) {
                    cur.leftCount++;
                    if (cur.left == null) {
                        cur.left = new Node(val);
                        break;
                    } else {
                        cur = cur.left;
                    }
                } else if (val > cur.val){
                    count += cur.leftCount + cur.selfCount;
                    if (cur.right == null) {
                        cur.right = new Node(val);
                        break;
                    } else {
                        cur = cur.right;
                    }
                } else {
                    cur.selfCount++;
                    count += cur.leftCount;
                    break;
                }
            }
            
            return count;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums.length == 0) {
            return res;
        }
        BST bst = new BST(nums[nums.length - 1]);
        res.add(0, 0);
        
        for (int i = nums.length - 2; i >= 0;i--) {
            res.add(0, bst.insert(nums[i]));
        }
        
        return res;
    }

}
