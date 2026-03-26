/*
 * Problem: 133. Clone Graph
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/clone-graph/
 * Language: java
 * Date: 2026-03-26
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Node[] nodes = new Node[101];
        return dfs(node, nodes);
    }

    public Node dfs(Node node, Node[] nodes) {
        if (node == null)
            return null;
        if (nodes[node.val] != null)
            return nodes[node.val];
        nodes[node.val] = new Node(node.val);
        for (Node neighbor : node.neighbors) {
            nodes[node.val].neighbors.add(dfs(neighbor, nodes));
        }
        return nodes[node.val];
    }
}
