/*
 * Problem: 61. Rotate List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rotate-list/
 * Language: java
 * Date: 2026-03-25
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
    public ListNode rotateRight(ListNode head, int k) {
        if (k<1) return head;
        if (head==null) return head;
        if (head.next==null) return head;
        ListNode fast=head;
        ListNode show=head;
        int n=1;
        ListNode tmp=head;
        while (tmp.next!=null) {
            n++;
            tmp=tmp.next;
        }
        k=k%n;
        if (k==0) return head;
        int m=n-k-1;
        ListNode end=tmp;
        tmp=head;
        for (int i=0;i<m;i++) {
            tmp=tmp.next;
        }
        ListNode headTmp=head;
        head=tmp.next;
        tmp.next=null;
        end.next=headTmp;
        return head;
    }
}
