/*
 * Problem: 117. Populating Next Right Pointers in Each Node II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * Language: java
 * Date: 2026-03-25
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    List<Node> Li = new ArrayList<>();

    public Node connect(Node root) {
        dfs(root,0);
        return root;
    }

    public void dfs(Node node, int n) {
        if (node == null)
            return;
        if (n == Li.size()) {
            Li.add(node);
        } else {
            Li.get(n).next = node;
            Li.set(n, node);
        }
        dfs(node.left, n + 1);
        dfs(node.right, n + 1);
    }
}
