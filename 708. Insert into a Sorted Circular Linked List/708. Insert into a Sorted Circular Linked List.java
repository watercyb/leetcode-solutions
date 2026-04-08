/*
 * Problem: 708. Insert into a Sorted Circular Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
 * Language: java
 * Date: 2026-04-08
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node tmp = new Node(insertVal);
            tmp.next = tmp;
            return tmp;
        }
        Node node = head;
        do {
            if ((node.val <= insertVal && insertVal <= node.next.val)
                    || (node.val > node.next.val && (insertVal >= node.val || insertVal <= node.next.val))) {
                node.next = new Node(insertVal, node.next);
                return head;
            }
            node = node.next;
        } while (node != head);
        head.next = new Node(insertVal, head.next);
        return head;
    }
}
