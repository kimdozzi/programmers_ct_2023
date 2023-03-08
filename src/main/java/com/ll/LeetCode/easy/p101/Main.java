package com.ll.LeetCode.easy.p101;
import java.io.*;
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true; // 그냥 null
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(root.left);
            q.add(root.right);
            while (!q.isEmpty()) {
                TreeNode left, right;
                left = q.poll();
                right = q.poll();
                if (left == null && right == null) continue;
                if (left == null || right == null || left.val != right.val) return false;
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
            }
            return true;
        }
    }

}
