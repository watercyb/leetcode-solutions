/*
 * Problem: 234. Palindrome Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/palindrome-linked-list/
 * Language: java
 * Date: 2026-03-28
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
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prv = null;
        ListNode next = slow.next;
        while (next != null) {
            slow.next = prv;
            prv = slow;
            slow = next;
            next = slow.next;
        }
        slow.next = prv;
        while (slow != null) {
            if (head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

}
