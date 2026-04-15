/*
 * Problem: 1265. Print Immutable Linked List in Reverse
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
 * Language: java
 * Date: 2026-04-15
 */

/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 * public void printValue(); // print the value of this node.
 * public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        sep(head, null);
    }

    public void sep(ImmutableListNode l, ImmutableListNode r) {
        if (l.getNext() == r) {
            l.printValue();
        } else {
            ImmutableListNode slow = l;
            ImmutableListNode fast = l;
            while (fast != r) {
                fast = fast.getNext();
                slow = slow.getNext();
                if (fast == r)
                    break;
                fast = fast.getNext();
            }
            sep(slow, r);
            sep(l, slow);
        }
    }
}
