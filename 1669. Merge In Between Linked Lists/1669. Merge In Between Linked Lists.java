/*
 * Problem: 1669. Merge In Between Linked Lists
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/merge-in-between-linked-lists/
 * Language: java
 * Date: 2026-04-19
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node=list1;
        int n=1;
        while (n<a) {
            node=node.next;
            n++;
        }
        ListNode node1=node.next;
        node.next=list2;
        while (list2.next!=null) {
            list2=list2.next;
        }
        while (n<b) {
            node1=node1.next;
            n++;
        }
        list2.next=node1.next;
        return list1;
    }
}
