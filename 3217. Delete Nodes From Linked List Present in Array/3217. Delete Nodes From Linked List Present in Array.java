/*
 * Problem: 3217. Delete Nodes From Linked List Present in Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/
 * Language: java
 * Date: 2026-05-05
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode beginning = new ListNode(0, head);
        boolean[] seens = new boolean[100001];
        for (int num : nums) {
            seens[num] = true;
        }
        ListNode node = beginning;
        while (node.next != null) {
            if (seens[node.next.val]) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return beginning.next;
    }
}
