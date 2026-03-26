/*
 * Problem: 147. Insertion Sort List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/insertion-sort-list/
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
    public ListNode insertionSortList(ListNode head) {
        ListNode beginning = new ListNode();
        beginning.next = head;
        head = beginning;
        ListNode node = beginning;
        while (head != null && head.next != null) {
            if (head.next.val < node.val)
                node = beginning;
            while (node.next.val < head.next.val) {
                node = node.next;
            }
            if (node.next == head.next) {
                head = head.next;
                continue;
            }
            ListNode tmp = head.next;
            head.next = head.next.next;
            tmp.next = node.next;
            node.next = tmp;
        }
        return beginning.next;
    }
}
