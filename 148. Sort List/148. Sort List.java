/*
 * Problem: 148. Sort List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sort-list/
 * Language: java
 * Date: 2026-03-26
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
    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        sep(head, null);
        return head;
    }

    public void sep(ListNode head, ListNode last) {
        if (head == last)
            return;
        ListNode fast = head;
        ListNode slow = head;
        boolean sorted = true;
        while (fast.next != last) {
            if (fast.val > fast.next.val)
                sorted = false;
            fast = fast.next;
            if (fast.next == last)
                break;
            if (fast.val > fast.next.val)
                sorted = false;
            fast = fast.next;
            slow = slow.next;
        }
        if (sorted)
            return;
        int pilot = slow.val;
        slow.val = fast.val;
        fast.val = pilot;
        fast = head;
        slow = head;
        while (fast.next != last) {
            if (fast.val <= pilot) {
                int tmp = fast.val;
                fast.val = slow.val;
                slow.val = tmp;
                slow = slow.next;
            }
            fast = fast.next;
        }
        fast.val = slow.val;
        slow.val = pilot;
        if (slow != head)
            sep(head, slow);
        if (slow != last)
            sep(slow.next, last);
    }
}
