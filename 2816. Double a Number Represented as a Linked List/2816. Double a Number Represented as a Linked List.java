/*
 * Problem: 2816. Double a Number Represented as a Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/
 * Language: java
 * Date: 2026-05-01
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
    public ListNode doubleIt(ListNode head) {
        ListNode beginning = new ListNode(0);
        beginning.next = head;
        ListNode node = beginning;
        while (node.next != null) {
            node.next.val *= 2;
            node.val += node.next.val / 10;
            node.next.val %= 10;
            node = node.next;
        }
        if (beginning.val == 1)
            return beginning;
        return beginning.next;
    }
}
