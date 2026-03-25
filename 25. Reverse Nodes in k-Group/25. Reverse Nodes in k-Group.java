/*
 * Problem: 25. Reverse Nodes in k-Group
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode beginning = new ListNode();
        beginning.next = head;
        ListNode node = beginning;
        while (node != null && node.next != null) {
            ListNode[] tmp = rev(node.next, k);
            node.next = tmp[0];
            node = tmp[1];
        }
        return beginning.next;
    }

    public ListNode[] rev(ListNode head, int k) {
        ListNode node = head;
        while (k > 1) {
            node = node.next;
            k--;
            if (node == null)
                return new ListNode[] { head, null };
        }
        ListNode nextHead = node.next;
        node = head;
        ListNode nodeNext = node.next;
        while (nodeNext != nextHead) {
            ListNode tmp = nodeNext.next;
            nodeNext.next = node;
            node = nodeNext;
            nodeNext = tmp;
        }
        head.next = nextHead;
        ListNode[] res = { node, head };
        return res;
    }
}
