/*
 * Problem: 160. Intersection of Two Linked Lists
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Language: java
 * Date: 2026-03-26
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        int lA=-1;
        int lB=-1;
        if (a==null || b==null) return null;
            while(a.next!=null) {
                lA++;
                a=a.next;
            }
            while(b.next!=null) {
                lB++;
                b=b.next;
            }
        int x=lA-lB;
        a=headA;
        b=headB;
        if (x>0) {
            for (int i=0;i<x;i++) a=a.next;
        } else {
            for (int i=0;i<-x;i++) b=b.next;
        }
        while (a!=b) {
            if (a.next==null) return null;
            a=a.next;
            b=b.next;
        }
        return a;
    }
}
