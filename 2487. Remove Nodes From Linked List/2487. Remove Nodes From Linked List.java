/*
 * Problem: 2487. Remove Nodes From Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-nodes-from-linked-list/
 * Language: java
 * Date: 2026-04-27
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
    public ListNode removeNodes(ListNode head) {
        ListNode node = new ListNode(Integer.MAX_VALUE);
        while (head != null) {
            ListNode next = head.next;
            head.next = node;
            node = head;
            head = next;
        }
        ListNode prv = null;
        int max = 0;
        while (node != null) {
            if (node.val >= max) {
                max = node.val;
                ListNode next = node.next;
                node.next = prv;
                prv = node;
                node = next;
            } else {
                node = node.next;
            }
        }
        return prv.next;
    }
}
