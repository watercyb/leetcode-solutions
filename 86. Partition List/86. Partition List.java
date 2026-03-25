/*
 * Problem: 86. Partition List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partition-list/
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
    public ListNode partition(ListNode head, int x) {
        ListNode beginning = new ListNode(-1, head);
        ListNode leftPrv = beginning;
        ListNode rightPrv = beginning;
        ListNode right = head;
        while (right != null) {
            if (right.val < x) {
                if (right == leftPrv.next) {
                    leftPrv = leftPrv.next;
                    right = right.next;
                    rightPrv = rightPrv.next;
                } else {
                    rightPrv.next = right.next;
                    right.next = leftPrv.next;
                    leftPrv.next = right;
                    right = rightPrv.next;
                    leftPrv = leftPrv.next;
                }
            } else {
                right = right.next;
                rightPrv = rightPrv.next;
            }
        }
        return beginning.next;
    }
}
