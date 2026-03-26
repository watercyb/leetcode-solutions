/*
 * Problem: 142. Linked List Cycle II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/linked-list-cycle-ii/
 * Language: java
 * Date: 2026-03-26
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head==null) {
                return head;
        }
        if (head.next==null ) {
            return head.next;
        }
        ListNode fast=head;
        ListNode slow=head;
        ListNode pin=head;
       while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) break;
        }
        if(fast == null || fast.next == null) return null;
        slow = head;
        while (fast!=pin) {
            fast=fast.next;
            pin=pin.next;
        }
        return pin;
        
    }
}
