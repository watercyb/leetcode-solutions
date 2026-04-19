/*
 * Problem: 1634. Add Two Polynomials Represented as Linked Lists
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/add-two-polynomials-represented-as-linked-lists/
 * Language: java
 * Date: 2026-04-19
 */

/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 * int coefficient, power;
 * PolyNode next = null;
 * 
 * PolyNode() {}
 * PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 * PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y;
 * this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode head = new PolyNode();
        PolyNode node = head;
        while (poly1 != null && poly2 != null) {
            if (poly1.power > poly2.power) {
                node.next = poly1;
                poly1 = poly1.next;
                node = node.next;
            } else if (poly1.power < poly2.power) {
                node.next = poly2;
                poly2 = poly2.next;
                node = node.next;
            } else {
                int coefficient = poly1.coefficient + poly2.coefficient;
                if (coefficient != 0) {
                    node.next = new PolyNode(coefficient, poly1.power);
                    node = node.next;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
        }
        node.next = null;
        if (poly1 != null)
            node.next = poly1;
        if (poly2 != null)
            node.next = poly2;
        return head.next;
    }
}
