/*
 * Problem: 2181. Merge Nodes in Between Zeros
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/merge-nodes-in-between-zeros/
 * Language: java
 * Date: 2026-04-24
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
    public ListNode mergeNodes(ListNode head) {
        ListNode pointer = head;
        ListNode node = head.next;
        int sum = 0;
        while (node != null) {
            while (node.val != 0) {
                sum += node.val;
                node = node.next;
            }
            pointer.next = new ListNode(sum);
            sum = 0;
            pointer = pointer.next;
            node = node.next;
        }
        pointer.next = null;
        return head.next;
    }
}
