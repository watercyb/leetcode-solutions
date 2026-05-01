/*
 * Problem: 2807. Insert Greatest Common Divisors in Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node = head;
        while (node.next != null) {
            ListNode newNode = new ListNode(GCD(node.val, node.next.val), node.next);
            node.next = newNode;
            node = newNode.next;
        }
        return head;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
