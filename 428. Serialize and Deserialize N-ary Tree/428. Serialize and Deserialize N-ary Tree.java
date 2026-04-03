/*
 * Problem: 428. Serialize and Deserialize N-ary Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
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

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root != null)
            getStr(root);
        return SB.toString();
    }

    StringBuilder SB = new StringBuilder();
    int idx = 0;

    public void getStr(Node node) {
        SB.append((char) (node.val + '^'));
        for (Node child : node.children) {
            getStr(child);
        }
        SB.append(']');
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0)
            return null;
        return getNode(data);
    }

    public Node getNode(String str) {
        Node node = new Node(str.charAt(idx++) - '^', new ArrayList<>());
        while (str.charAt(idx) != ']') {
            node.children.add(getNode(str));
        }
        idx++;
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
