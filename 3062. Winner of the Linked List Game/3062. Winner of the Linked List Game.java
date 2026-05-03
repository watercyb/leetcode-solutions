/*
 * Problem: 3062. Winner of the Linked List Game
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/winner-of-the-linked-list-game/
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
    public String gameResult(ListNode head) {
        int res = 0;
        for (ListNode node = head; node != null; node = node.next.next) {
            if (node.val > node.next.val) {
                res++;
            } else {
                res--;
            }
        }
        if (res > 0) {
            return "Even";
        } else if (res < 0) {
            return "Odd";
        } else {
            return "Tie";
        }
    }
}
