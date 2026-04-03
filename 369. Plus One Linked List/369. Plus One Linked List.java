/*
 * Problem: 369. Plus One Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/plus-one-linked-list/
 * Language: java
 * Date: 2026-04-03
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
    public ListNode plusOne(ListNode head) {
        ListNode beginning = new ListNode(1);
        beginning.next = head;
        if (dfs(head) == 1)
            return beginning;
        return head;
    }

    public int dfs(ListNode node) {
        if (node == null)
            return 1;
        node.val += dfs(node.next);
        if (node.val == 10) {
            node.val = 0;
            return 1;
        }
        return 0;
    }
}
