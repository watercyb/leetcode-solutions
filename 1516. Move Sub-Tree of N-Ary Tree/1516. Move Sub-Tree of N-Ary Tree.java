/*
 * Problem: 1516. Move Sub-Tree of N-Ary Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/move-sub-tree-of-n-ary-tree/
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
    public Node moveSubTree(Node root, Node p, Node q) {
        Node beginning = new Node();
        beginning.children.add(root);
        Node node = dfs(q, p);
        if (node != null) {
            if (node == q)
                return root;
            q.children.add(p);
            remove(node, p);
            return root;
        }
        node = dfs(p, q);
        if (node == null) {
            node = dfs(root, p);
            q.children.add(p);
            remove(node, p);
            return root;
        }
        Node parentP = dfs(beginning, p);
        Node parentQ = dfs(beginning, q);
        int idxP = remove(parentP, p);
        remove(parentQ, q);
        parentP.children.add(idxP, q);
        q.children.add(p);
        return beginning.children.getFirst();
    }

    public int remove(Node a, Node b) {
        for (int i = 0; i < a.children.size(); i++) {
            if (a.children.get(i) == b) {
                a.children.remove(i);
                return i;
            }
        }
        return -1;
    }

    public Node dfs(Node node, Node target) {
        if (node == null)
            return null;
        for (Node next : node.children) {
            if (next == target)
                return node;
            Node res = dfs(next, target);
            if (res != null)
                return res;
        }
        return null;
    }
}
