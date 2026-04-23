/*
 * Problem: 2095. Delete the Middle Node of a Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 * Language: java
 * Date: 2026-04-23
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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null)
            return null;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null)
                break;
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
