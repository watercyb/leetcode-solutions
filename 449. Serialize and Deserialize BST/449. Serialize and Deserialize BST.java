/*
 * Problem: 449. Serialize and Deserialize BST
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/serialize-and-deserialize-bst/
 * Language: java
 * Date: 2026-04-03
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
    int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        getStr(root);
        return SB.toString();
    }

    public void getStr(TreeNode node) {
        if (node == null)
            return;
        SB.append((char) node.val);
        getStr(node.left);
        getStr(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        return getTree(data.toCharArray(), Integer.MAX_VALUE);
    }

    public TreeNode getTree(char[] chrs, int lim) {
        TreeNode node = new TreeNode((int) chrs[idx++]);
        if (idx < chrs.length && (int) chrs[idx] < node.val)
            node.left = getTree(chrs, node.val);
        if (idx < chrs.length && (int) chrs[idx] < lim)
            node.right = getTree(chrs, lim);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
