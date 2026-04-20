/*
 * Problem: 1721. Swapping Nodes in a Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 * Language: java
 * Date: 2026-04-20
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;
        for (int i = 0; i < k - 1; i++) {
            left = left.next;
        }
        ListNode right = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            right = right.next;
            fast = fast.next;
        }
        swap(left, right);
        return head;
    }

    public void swap(ListNode a, ListNode b) {
        int tempVal = a.val;
        a.val = b.val;
        b.val = tempVal;
    }
}
