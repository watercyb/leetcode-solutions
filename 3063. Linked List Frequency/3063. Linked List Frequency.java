/*
 * Problem: 3063. Linked List Frequency
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/linked-list-frequency/
 * Language: java
 * Date: 2026-05-03
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
    public ListNode frequenciesOfElements(ListNode head) {
        int max = 0;
        ListNode node = head;
        while (node != null) {
            max = Math.max(node.val, max);
            node = node.next;
        }
        int[] counts = new int[max + 1];
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        for (node = head; node != null; node = node.next) {
            if (counts[node.val]++ == 0) {
                tmp = tmp.next = new ListNode(node.val);
            }
        }
        for (tmp = res.next; tmp != null; tmp = tmp.next) {
            tmp.val = counts[tmp.val];
        }
        return res.next;
    }
}
