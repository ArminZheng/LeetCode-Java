package com.armin.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * @author zy
 * @version 2022/4/20
 */
public class InorderTraversal {
    List<Integer> in = new ArrayList<>();

    @SuppressWarnings("all")
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            in.add(root.val);
            inorderTraversal(root.right);
        }
        return in;
    }
}
/** Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
