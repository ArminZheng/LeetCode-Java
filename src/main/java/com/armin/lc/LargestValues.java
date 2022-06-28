package com.armin.lc;

import java.util.*;

/**
 * LargestValues
 *
 * @author zy
 * @since 2022.06.24
 */
public class LargestValues {

    Map<Integer, Integer> map = new HashMap<>();

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        if (root.val == 0 && root.left == null & root.right == null) {
            list.add(0);
            return list;
        }
        dfs(root, 1);
        for (int i = 1; i <= map.size(); i++) {
            list.add(map.get(i));
        }
        return list;
    }

    void dfs(TreeNode node, Integer depth) {
        if (node == null) return;
        map.put(depth, Math.max(map.getOrDefault(depth, Integer.MIN_VALUE), node.val));
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public List<Integer> largestValuesWrongAnswer(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        if (root.val == 0 && root.left == null & root.right == null) {
            list.add(0);
            return list;
        }
        getSourceList(root);
        int max = 0, x = 1;
        for (int i = 0; i < source.size(); i++) {
            if (i <= x) {
                max = Math.max(source.get(i), max);
            } else {
                list.add(max);
                x = x << 1;
            }
        }
        return list;
    }

    private final List<Integer> source = new ArrayList<>();

    public void getSourceList(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> treeNodes = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            source.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            } else if (node.right != null) {
                queue.add(new TreeNode(0));
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
