/*
 * Problem: 203. Remove Linked List Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-linked-list-elements/
 * Language: java
 * Date: 2026-03-26
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
    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return null;
        head.next=removeElements(head.next,val);
        if (head.val==val) {
            return head.next;
            } else {
            return head;
        }
        
    }
}
