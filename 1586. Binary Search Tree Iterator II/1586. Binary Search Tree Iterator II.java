/*
 * Problem: 1586. Binary Search Tree Iterator II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-search-tree-iterator-ii/
 * Language: java
 * Date: 2026-04-18
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
class BSTIterator {
    TreeNode node;
    Deque<TreeNode> Dq = new ArrayDeque<>();
    List<Integer> list = new ArrayList<>();
    int idx = 0;

    public BSTIterator(TreeNode root) {
        node = root;
        while (node.left != null) {
            Dq.offerLast(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return idx < list.size() || !Dq.isEmpty() || node != null ;
    }

    public int next() {
        if (idx == list.size()) {
            list.add(node.val);
            if (node.right != null) {
                node = node.right;
                while (node.left != null) {
                    Dq.offerLast(node);
                    node = node.left;
                }
            } else {
                node = Dq.pollLast();
            }
        }
        return list.get(idx++);
    }

    public boolean hasPrev() {
        return idx > 1;
    }

    public int prev() {
        if (idx > 0)
            idx--;
        if (idx > 0)
            return list.get(idx - 1);
        return list.get(idx);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */
