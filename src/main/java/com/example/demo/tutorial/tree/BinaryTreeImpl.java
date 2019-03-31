package com.example.demo.tutorial.tree;

import com.example.demo.tutorial.model.TreeNode;

public class BinaryTreeImpl {

    private int ans = 0;

    // Top - down, pre-order traversal (root left right)
    public void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans = Math.max(ans, depth);
        }
        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }

    // Bottom - up, post-order traversal (left right root)
    public int maximum_depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_depth = maximum_depth(root.left);
        int right_depth = maximum_depth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }
}
