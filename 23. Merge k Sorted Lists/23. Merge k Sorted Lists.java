/*
 * Problem: 23. Merge k Sorted Lists
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/merge-k-sorted-lists/
 * Language: java
 * Date: 2026-03-25
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return sep(lists, 0, lists.length - 1);
    }

    public ListNode sep(ListNode[] lists, int l, int r) {
        if (l == r)
            return lists[l];
        int mid = (l + r) >>> 1;
        return merge(sep(lists, l, mid), sep(lists, mid + 1, r));
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode();
        ListNode node = head;
        while (a != null && b != null) {
            if (a.val > b.val) {
                node.next = b;
                b = b.next;
            } else {
                node.next = a;
                a = a.next;
            }
            node = node.next;
        }
        if (a != null)
            node.next = a;
        if (b != null)
            node.next = b;
        return head.next;
    }
}
