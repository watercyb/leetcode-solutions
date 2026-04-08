/*
 * Problem: 725. Split Linked List in Parts
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/split-linked-list-in-parts/
 * Language: java
 * Date: 2026-04-08
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        int l = count / k;
        int n = count % k;
        ListNode[] res = new ListNode[k];
        node = head;
        for (int i = 0; i < n; i++) {
            res[i] = node;
            for (int j = 0; j < l; j++) {
                node = node.next;
            }
            ListNode nodeTemp = node;
            node = node.next;
            nodeTemp.next = null;
        }
        if (l > 0) {
            for (int i = n; i < k; i++) {
                res[i] = node;
                for (int j = 0; j < l - 1; j++) {
                    node = node.next;
                }
                ListNode nodeTemp = node;
                node = node.next;
                nodeTemp.next = null;
            }
        }
        return res;
    }
}
