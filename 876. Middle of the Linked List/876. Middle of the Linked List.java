/*
 * Problem: 876. Middle of the Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/middle-of-the-linked-list/
 * Language: java
 * Date: 2026-04-09
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null) {
            fast=fast.next;
            if (fast==null) return slow;
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
