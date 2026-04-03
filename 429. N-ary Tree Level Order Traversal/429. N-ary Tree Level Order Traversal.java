/*
 * Problem: 429. N-ary Tree Level Order Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * Language: java
 * Date: 2026-04-03
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
    public List<List<Integer>> levelOrder(Node root) {
        dfs(root, 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public void dfs(Node node, int lv) {
        if (node == null)
            return;
        if (res.size() == lv)
            res.add(new ArrayList<>());
        res.get(lv).add(node.val);
        lv++;
        for (Node child : node.children) {
            dfs(child, lv);
        }
    }
}
