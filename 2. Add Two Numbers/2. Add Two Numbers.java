/*
 * Problem: 2. Add Two Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/add-two-numbers/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmpL1=l1;
        ListNode tmpL2=l2;
        ListNode tmp=new ListNode();
        int n=0;
        ListNode tmpHead=tmp;
        if (tmpL1==null && tmpL2==null) return null;
        if (tmpL1==null) tmp.val=tmpL2.val;
        if (tmpL2==null) tmp.val=tmpL1.val;
        if (tmpL1!=null && tmpL2!=null) {
            int tmpN=tmpL1.val+tmpL2.val+n;
            tmp.val=tmpN%10;
            n=tmpN/10;
        }
        while (tmpL1.next!=null && tmpL2.next!=null) {
            int tmpN=tmpL1.next.val+tmpL2.next.val+n;
            tmp.next=new ListNode(tmpN%10);
            n=tmpN/10;
            tmp=tmp.next;
            tmpL1=tmpL1.next;
            tmpL2=tmpL2.next;
        }
        while (tmpL1.next!=null) {
            int tmpN=tmpL1.next.val+n;
            tmp.next=new ListNode(tmpN%10);
            n=tmpN/10;
            tmp=tmp.next;
            tmpL1=tmpL1.next;
        }
        while (tmpL2.next!=null) {
            int tmpN=tmpL2.next.val+n;
            tmp.next=new ListNode(tmpN%10);
            n=tmpN/10;
            tmp=tmp.next;
            tmpL2=tmpL2.next;
        }
        if (n>0) tmp.next=new ListNode(n);
        return tmpHead;
   }
}
