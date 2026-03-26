/*
 * Problem: 143. Reorder List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reorder-list/
 * Language: java
 * Date: 2026-03-26
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null)
            return;
        ListNode a = head;
        ListNode b = head.next;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
        }
        b = a.next;
        a.next = null;
        ListNode next = b.next;
        b.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = b;
            b = next;
            next = temp;
        }
        while (b != null) {
            ListNode nextHead = head.next;
            ListNode nextB = b.next;
            head.next = b;
            b.next = nextHead;
            head = nextHead;
            b = nextB;
        }
    }
}
