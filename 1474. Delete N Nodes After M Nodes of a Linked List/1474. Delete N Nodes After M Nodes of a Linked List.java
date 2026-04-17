/*
 * Problem: 1474. Delete N Nodes After M Nodes of a Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/
 * Language: java
 * Date: 2026-04-17
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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode beginning = new ListNode(-1);
        beginning.next = head;
        ListNode node = beginning;
        while (node != null) {
            for (int i = 0; i < m && node != null; i++) {
                node = node.next;
            }
            if (node == null)
                break;
            ListNode tmp = node;
            for (int i = 0; i < n && node != null; i++) {
                node = node.next;
            }
            if (node == null)
                tmp.next = null;
            else
                tmp.next = node.next;
        }
        return head;
    }
}
