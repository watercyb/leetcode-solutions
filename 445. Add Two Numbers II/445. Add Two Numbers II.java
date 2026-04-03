/*
 * Problem: 445. Add Two Numbers II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/add-two-numbers-ii/
 * Language: java
 * Date: 2026-04-03
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] arr1 = new int[100];
        int idx1 = -1;
        int[] arr2 = new int[100];
        int idx2 = -1;
        while (l1 != null) {
            arr1[++idx1] = l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            arr2[++idx2] = l2.val;
            l2 = l2.next;
        }
        int[] arr = new int[101];
        int idx = 0;
        int carry = 0;
        while (idx1 >= 0 || idx2 >= 0) {
            if (idx1 >= 0)
                carry += arr1[idx1--];
            if (idx2 >= 0)
                carry += arr2[idx2--];
            arr[idx++] = carry % 10;
            carry /= 10;
        }
        if (carry != 0)
            arr[idx++] = 1;
        ListNode res = new ListNode();
        ListNode node = res;
        for (int i = idx - 1; i >= 0; i--) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return res.next;
    }
}
