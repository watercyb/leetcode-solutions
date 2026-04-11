/*
 * Problem: 1019. Next Greater Node In Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/next-greater-node-in-linked-list/
 * Language: java
 * Date: 2026-04-11
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
    public int[] nextLargerNodes(ListNode head) {
        int[] MQ = new int[10000];
        int[] index = new int[10000];
        int idx = 0;
        int[] res = new int[10000];
        int idxNode = 0;
        while (head != null) {
            int val = head.val;
            while (idx > 0 && MQ[idx - 1] < val) {
                res[index[idx - 1]] = val;
                idx--;
            }
            index[idx] = idxNode++;
            MQ[idx++] = val;
            head = head.next;
        }
        return Arrays.copyOfRange(res, 0, idxNode);
    }
}
