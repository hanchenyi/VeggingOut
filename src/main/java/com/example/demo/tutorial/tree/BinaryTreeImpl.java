package com.example.demo.tutorial.tree;

import com.example.demo.tutorial.model.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode root, Integer leftBound, Integer rightBound) {
        // recursively pass left and right bounds from higher level to lower level
        if (root == null) {
            return true;
        }
        if (leftBound != null && root.val <= leftBound || rightBound != null && root.val >= rightBound) {
            return false;
        }
        return isValidBSTHelper(root.left, leftBound, root.val) && isValidBSTHelper(root.right, root.val, rightBound);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null)
            return res;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<Integer>();
            while (size -- > 0) {
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            res.add(list);
        }
        return res;
    }

    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        int low = 0, high = nums.length - 1;
        return sortArray(nums, low, high);

    }

    public TreeNode sortArray(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortArray(nums, low, mid - 1);
        root.right = sortArray(nums, mid + 1, high);
        return root;
    }
}
