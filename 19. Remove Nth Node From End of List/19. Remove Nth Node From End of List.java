/*
 * Problem: 19. Remove Nth Node From End of List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Language: java
 * Date: 2026-03-25
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int res = dfs(head, n + 1);
        if (res == n)
            head = head.next;
        return head;
    }

    public int dfs(ListNode node, int n) {
        if (node == null)
            return 0;
        int res = dfs(node.next, n) + 1;
        if (res == n)
            node.next = node.next.next;
        return res;
    }
}
