/*
 * Problem: 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * Language: java
 * Date: 2026-04-03
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    Node head;
    Node tail;

    public void dfs(Node node) {
        if (node == null)
            return;
        dfs(node.left);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.right = node;
            node.left = tail;
            tail = node;
        }
        dfs(node.right);
    }
}
