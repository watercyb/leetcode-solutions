/*
 * Problem: 2130. Maximum Twin Sum of a Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 * Language: java
 * Date: 2026-04-24
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
    public int pairSum(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next.next;
            count += 2;
        }
        int[] arr = new int[count];
        int idx = 0;
        node = head;
        while (node != null) {
            arr[idx++] = node.val;
            node = node.next;
        }
        int res = 0;
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            res = Math.max(arr[l] + arr[r], res);
            l++;
            r--;
        }
        return res;
    }
}
