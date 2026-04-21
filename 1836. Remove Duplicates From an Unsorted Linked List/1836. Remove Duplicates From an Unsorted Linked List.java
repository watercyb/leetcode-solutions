/*
 * Problem: 1836. Remove Duplicates From an Unsorted Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/
 * Language: java
 * Date: 2026-04-21
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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        int[] counts = new int[100001];
        ListNode node = head;
        while (node != null) {
            counts[node.val]++;
            node = node.next;
        }
        ListNode beginning = new ListNode();
        node = beginning;
        while (head != null) {
            while (head != null && counts[head.val] > 1) {
                head = head.next;
            }
            node.next = head;
            node = head;
            if (head != null)
                head = head.next;
        }
        return beginning.next;
    }
}
