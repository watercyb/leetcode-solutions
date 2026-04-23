/*
 * Problem: 2046. Sort Linked List Already Sorted Using Absolute Values
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sort-linked-list-already-sorted-using-absolute-values/
 * Language: java
 * Date: 2026-04-23
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
    public ListNode sortLinkedList(ListNode head) {
        ListNode center = new ListNode(-1, head);
        ListNode prv = null;
        ListNode beginning = center;
        ListNode node = beginning;
        while (node.next != null) {
            if (node.next.val < 0) {
                ListNode tmp = node.next;
                node.next = node.next.next;
                tmp.next = beginning;
                beginning = tmp;
                if (prv == null)
                    prv = beginning;
            } else {
                node = node.next;
            }
        }
        if (prv != null) {
            prv.next = center.next;
            return beginning;
        }
        return beginning.next;
    }
}
