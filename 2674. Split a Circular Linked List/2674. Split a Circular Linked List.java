/*
 * Problem: 2674. Split a Circular Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/split-a-circular-linked-list/
 * Language: java
 * Date: 2026-04-29
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
    public ListNode[] splitCircularLinkedList(ListNode list) {
        ListNode start = list;
        ListNode slow = list;
        ListNode fast = list.next;
        while (fast.next != start) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next == start)
                break;
            fast = fast.next;
        }
        ListNode a = start;
        ListNode b = slow.next;
        slow.next = a;
        fast.next = b;
        return new ListNode[] { a, b };
    }
}
