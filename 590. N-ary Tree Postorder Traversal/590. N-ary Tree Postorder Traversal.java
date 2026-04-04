/*
 * Problem: 590. N-ary Tree Postorder Traversal
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 * Language: java
 * Date: 2026-04-04
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<Node> Dq = new ArrayDeque<>();
        Dq.offerLast(root);
        while (!Dq.isEmpty()) {
            Node current = Dq.pollLast();
            res.add(current.val);
            for (Node child : current.children) {
                Dq.offerLast(child);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
