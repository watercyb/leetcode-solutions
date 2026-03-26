/*
 * Problem: 206. Reverse Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-linked-list/
 * Language: java
 * Date: 2026-03-26
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
            ListNode res=dfs(head,head.next);
            head.next=null;
        return res;
    }

    public ListNode dfs(ListNode prv, ListNode node) {
        if (node.next != null) {
            ListNode res=dfs(node, node.next);
            node.next = prv;
            return res;
        } else {
            node.next = prv;
            return node;
        }
    }
}
