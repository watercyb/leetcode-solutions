/*
 * Problem: 1490. Clone N-ary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/clone-n-ary-tree/
 * Language: java
 * Date: 2026-04-17
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
    public Node cloneTree(Node root) {
        if (root == null)
            return null;
        Node res = new Node();
        res.val = root.val;
        for (Node child : root.children) {
            Node tmp = new Node();
            res.children.add(cloneTree(child));
        }
        return res;
    }
}
