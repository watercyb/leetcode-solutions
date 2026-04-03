/*
 * Problem: 510. Inorder Successor in BST II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/inorder-successor-in-bst-ii/
 * Language: java
 * Date: 2026-04-03
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            Node res = node.right;
            while (res.left != null) {
                res = res.left;
            }
            return res;
        } else {
            Node p = node;
            while (p.parent != null && p.parent.right == p) {
                p = p.parent;
            }
            return p.parent;
        }
    }
}
