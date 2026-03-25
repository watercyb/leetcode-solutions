/*
 * Problem: 82. Remove Duplicates from Sorted List II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode beginning = new ListNode(-1);
        beginning.next = head;
        ListNode left = beginning;
        ListNode right = head;
        while (right != null && right.next != null) {
            if (right.val == right.next.val) {
                int tmp = right.val;
                while (right != null && right.val == tmp) {
                    right = right.next;
                }
            } else {
                left.next = right;
                left = left.next;
                right = right.next;
            }
        }
        left.next = right;
        return beginning.next;
    }
}
