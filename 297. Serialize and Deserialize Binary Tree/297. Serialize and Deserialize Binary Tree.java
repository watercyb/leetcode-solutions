/*
 * Problem: 297. Serialize and Deserialize Binary Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Language: java
 * Date: 2026-03-31
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
public class Codec {
    StringBuilder SB = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        getStr(root);
        return SB.toString();
    }

    public void getStr(TreeNode node) {
        if (node == null) {
            SB.append("@,");
        } else {
            SB.append(node.val);
            SB.append(",");
            getStr(node.left);
            getStr(node.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",", 0);
        return getTree(strs);
    }

    int idx = 0;

    public TreeNode getTree(String[] strs) {
        if (strs[idx].equals("@")) {
            idx++;
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(strs[idx++]));
            node.left = getTree(strs);
            node.right = getTree(strs);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
