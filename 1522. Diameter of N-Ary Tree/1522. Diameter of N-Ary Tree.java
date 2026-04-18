/*
 * Problem: 1522. Diameter of N-Ary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/diameter-of-n-ary-tree/
 * Language: java
 * Date: 2026-04-18
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int diameter(Node root) {
        dfs(root);
        return res - 1;
    }

    int res = 0;

    public int dfs(Node node) {
        if (node == null)
            return 0;
        int a = 0;
        int b = 0;
        for (Node child : node.children) {
            int tmp = dfs(child);
            if (tmp > a) {
                b = a;
                a = tmp;
            } else if (tmp > b) {
                b = tmp;
            }
        }
        res = Math.max(a + b + 1, res);
        return Math.max(a, b) + 1;
    }
}
