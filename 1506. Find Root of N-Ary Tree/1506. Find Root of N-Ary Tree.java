/*
 * Problem: 1506. Find Root of N-Ary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-root-of-n-ary-tree/
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
    public Node findRoot(List<Node> tree) {
        int res = 0;
        for (Node node : tree) {
            res ^= node.val;
            for (Node child : node.children) {
                res ^= child.val;
            }
        }
        for (Node node : tree) {
            if (node.val == res)
                return node;
        }
        return null;
    }
}
