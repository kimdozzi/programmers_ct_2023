package com.ll.LeetCode.easy.p94;
import java.util.*;
public class Main {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;
            InOrder(list, root);
            return list;
        }

        private void InOrder(List<Integer> list, TreeNode root) {
            if (root == null) return;
            InOrder(list, root.left);
            list.add(root.val);
            InOrder(list, root.right);
        }
    }
}
