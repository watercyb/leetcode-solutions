/*
 * Problem: 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int prv = head.val;
        head = head.next;
        int n = 1;
        int max = -1;
        int min = Integer.MAX_VALUE;
        int first = -1;
        int last = -1;
        while (head.next != null) {
            if ((head.val > prv && head.val > head.next.val) || (head.val < prv && head.val < head.next.val)) {
                if (first == -1) {
                    first = n;
                    last = n;
                } else {
                    max = n - first;
                    min = Math.min(n - last, min);
                    last = n;
                }
            }
            prv = head.val;
            head = head.next;
            n++;
        }
        if (min == Integer.MAX_VALUE)
            return new int[] { -1, max };
        return new int[] { min, max };
    }
}
