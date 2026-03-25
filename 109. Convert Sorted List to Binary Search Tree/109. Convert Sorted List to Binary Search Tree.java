/*
 * Problem: 109. Convert Sorted List to Binary Search Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * Language: java
 * Date: 2026-03-25
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
    public TreeNode sortedListToBST(ListNode head) {
        return dfs( head, null);
    }

    public TreeNode dfs(ListNode left, ListNode right) {
        if (left == right)
            return null;
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right) {
            fast = fast.next;
            if (fast == right)
                break;
            fast = fast.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = dfs(left, slow);
        if (slow.next != right)
            node.right = dfs(slow.next, right);
        return node;
    }
}
