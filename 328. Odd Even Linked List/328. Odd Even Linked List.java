/*
 * Problem: 328. Odd Even Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/odd-even-linked-list/
 * Language: java
 * Date: 2026-04-03
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
    public ListNode oddEvenList(ListNode head) {
        if (head==null) return head;
        if (head.next==null) return head;
        if (head.next.next==null) return head;
        ListNode odd=new ListNode(head.next.val);
        ListNode oddhead=odd;
        head.next=head.next.next;
        ListNode tmp=head.next;
        while (tmp.next!=null) {
            odd.next=new ListNode(tmp.next.val);
            odd=odd.next;
            if (tmp.next.next==null) {
                break;
            } else {
                tmp.next=tmp.next.next;
                tmp=tmp.next;
            }
        }
        tmp.next=oddhead;
        return head;
        
        
    }
}
