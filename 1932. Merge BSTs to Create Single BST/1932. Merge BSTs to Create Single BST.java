/*
 * Problem: 1932. Merge BSTs to Create Single BST
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/merge-bsts-to-create-single-bst/
 * Language: java
 * Date: 2026-04-22
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        TreeNode[] treesArr = new TreeNode[trees.size()];
        trees.toArray(treesArr);
        int max = 0;
        for (TreeNode node : treesArr) {
            max = Math.max(node.val, max);
            if (node.left != null)
                max = Math.max(node.left.val, max);
            if (node.right != null)
                max = Math.max(node.right.val, max);
        }
        TreeNode[] roots = new TreeNode[max + 1];
        TreeNode[] leafs = new TreeNode[max + 1];
        int countLink = 0;
        for (TreeNode node : treesArr) {
            count++;
            if (leafs[node.val] != null) {
                countLink++;
                leafs[node.val].left = node.left;
                leafs[node.val].right = node.right;
            } else {
                roots[node.val] = node;
            }
            if (node.left != null) {
                count++;
                if (roots[node.left.val] != null) {
                    countLink++;
                    node.left.left = roots[node.left.val].left;
                    node.left.right = roots[node.left.val].right;
                    roots[node.left.val] = null;
                } else {
                    leafs[node.left.val] = node.left;
                }
            }
            if (node.right != null) {
                count++;
                if (roots[node.right.val] != null) {
                    countLink++;
                    node.right.left = roots[node.right.val].left;
                    node.right.right = roots[node.right.val].right;
                    roots[node.right.val] = null;
                } else {
                    leafs[node.right.val] = node.right;
                }
            }
        }
        if (countLink != treesArr.length - 1)
            return null;
        for (TreeNode node : treesArr) {
            if (roots[node.val] != null) {
                if (dfs(node, 0, Integer.MAX_VALUE) && count == treesArr.length - 1) {
                    return node;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    int count = 0;

    public boolean dfs(TreeNode node, int l, int r) {
        if (node == null)
            return true;
        if (node.val <= l || node.val >= r)
            return false;
        count--;
        return dfs(node.left, l, node.val) && dfs(node.right, node.val, r);
    }
}
