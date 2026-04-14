/*
 * Problem: 1171. Remove Zero Sum Consecutive Nodes from Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 * Language: java
 * Date: 2026-04-14
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
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null)
            return head;
        ListNode beginning = new ListNode();
        beginning.next = head;
        ListNode node = beginning.next;
        int sum=0;
        while (node != null) {
            sum += node.val;
            if (sum == 0)
                return removeZeroSumSublists(node.next);
            node = node.next;
        }
        head.next=removeZeroSumSublists(head.next);
        return beginning.next;
    }
}

