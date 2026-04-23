/*
 * Problem: 2074. Reverse Nodes in Even Length Groups
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reverse-nodes-in-even-length-groups/
 * Language: java
 * Date: 2026-04-23
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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode beginning = new ListNode();
        beginning.next = head;
        ListNode a = beginning;
        ListNode b = beginning.next;
        int n = 1;
        while (b != null) {
            int count = 1;
            while (b.next != null && count < n) {
                b = b.next;
                count++;
            }
            if (count % 2 == 0) {
                ListNode aNext = a.next;
                ListNode bNext = b.next;
                reverse(a, b);
                a = aNext;
                b = bNext;
            } else {
                a = b;
                b = b.next;
            }
            n++;
        }
        return beginning.next;
    }

    public void reverse(ListNode a, ListNode b) {
        ListNode a1 = a.next;
        ListNode b1 = b.next;
        ListNode next = a1.next;
        a1.next = b1;
        a.next = b;
        while (a1 != b) {
            ListNode temp = next;
            next = next.next;
            temp.next = a1;
            a1 = temp;
        }
    }
}
