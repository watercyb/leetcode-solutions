/*
 * Problem: 1650. Lowest Common Ancestor of a Binary Tree III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
 * Language: java
 * Date: 2026-04-19
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
    public Node lowestCommonAncestor(Node p, Node q) {
        Node nodeP = p;
        Node nodeQ = q;
        while (nodeP != nodeQ) {
            if (nodeP == null) {
                nodeP = q;
            } else {
                nodeP = nodeP.parent;
            }
            if (nodeQ == null) {
                nodeQ = p;
            } else {
                nodeQ = nodeQ.parent;
            }
        }
        return nodeP;
    }
}
