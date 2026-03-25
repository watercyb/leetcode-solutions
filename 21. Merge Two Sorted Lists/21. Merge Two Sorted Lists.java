/*
 * Problem: 21. Merge Two Sorted Lists
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null) return list2;
        if (list2==null) return list1;
        ListNode lN=new ListNode();
        if (list1.val>list2.val) {
            lN.val=list2.val;
            list2=list2.next;
        } else {
            lN.val=list1.val;
            list1=list1.next;
        }
        ListNode tmp=lN;
        while (list1!=null && list2!=null) {
        if (list1.val>list2.val) {
            tmp.next=new ListNode(list2.val);
            list2=list2.next;
        } else {
            tmp.next=new ListNode(list1.val);
            list1=list1.next;
        }
            tmp=tmp.next;
        }
        while (list1!=null) {
            tmp.next=new ListNode(list1.val);
            list1=list1.next;
            tmp=tmp.next;
        }
        while (list2!=null) {
            tmp.next=new ListNode(list2.val);
            list2=list2.next;
            tmp=tmp.next;
        }
        return lN;
    }
}
