package com.armin.struct;

/**
 * TreeNode
 *
 * @author zy
 * @version 2022/3/28
 */
public class TreeNode {

    int val;
    TreeNode left, right;

    @SuppressWarnings("unused")
    public static void traverse(TreeNode root) {
        if (root == null) return;
        // 前序
        traverse(root.left);
        // 中序
        traverse(root.right);
        // 后序
    }
}
