/*
 * Problem: 1290. Convert Binary Number in a Linked List to Integer
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * Language: java
 * Date: 2026-04-15
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
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = (res << 1) | head.val;
            head = head.next;
        }
        return res;
    }
}
