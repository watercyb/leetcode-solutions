/*
 * Problem: 92. Reverse Linked List II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reverse-linked-list-ii/
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;
        ListNode beginning = new ListNode();
        beginning.next = head;
        ListNode l1 = beginning;
        int count = 1;
        while (count != left) {
            l1 = l1.next;
            count++;
        }
        count--;
        ListNode r1 = l1;
        while (count != right) {
            r1 = r1.next;
            count++;
        }
        ListNode l2 = l1.next;
        ListNode node = l1.next;
        ListNode nodeNext = node.next;
        while (node != r1) {
            ListNode tmp = nodeNext.next;
            nodeNext.next = node;
            node = nodeNext;
            nodeNext = tmp;
        }
        l1.next = node;
        l2.next = nodeNext;
        return beginning.next;
    }
}
