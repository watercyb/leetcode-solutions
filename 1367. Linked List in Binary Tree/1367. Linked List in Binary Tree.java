/*
 * Problem: 1367. Linked List in Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/linked-list-in-binary-tree/
 * Language: java
 * Date: 2026-04-16
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null)
            return false;
        if (chk(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right))
            return true;
        return false;
    }

    public boolean chk(TreeNode treeNode, ListNode listNode) {
        if (listNode == null)
            return true;
        if (treeNode == null || treeNode.val != listNode.val)
            return false;
        return chk(treeNode.left, listNode.next) || chk(treeNode.right, listNode.next);
    }
}
