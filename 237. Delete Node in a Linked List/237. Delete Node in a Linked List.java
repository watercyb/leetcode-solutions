/*
 * Problem: 237. Delete Node in a Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/delete-node-in-a-linked-list/
 * Language: java
 * Date: 2026-03-28
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
