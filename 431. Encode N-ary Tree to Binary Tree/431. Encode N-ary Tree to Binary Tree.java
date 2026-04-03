/*
 * Problem: 431. Encode N-ary Tree to Binary Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/
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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null)
            return null;
        TreeNode treeNode = new TreeNode(root.val);
        encode(root, treeNode);
        return treeNode;
    }

    public void encode(Node node, TreeNode treeNode) {
        if (node.children.size() > 0) {
            Node child = node.children.get(0);
            treeNode.right = new TreeNode(child.val);
            encode(child, treeNode.right);
            treeNode = treeNode.right;
            for (int i = 1; i < node.children.size(); i++) {
                child = node.children.get(i);
                treeNode.left = new TreeNode(child.val);
                encode(child, treeNode.left);
                treeNode = treeNode.left;
            }
        }
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null)
            return null;
        Node node = new Node(root.val, new ArrayList<>());
        decode(root, node);
        return node;
    }

    public void decode(TreeNode treeNode, Node node) {
        treeNode = treeNode.right;
        while (treeNode != null) {
            Node child = new Node(treeNode.val, new ArrayList<>());
            node.children.add(child);
            decode(treeNode, child);
            treeNode = treeNode.left;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));
