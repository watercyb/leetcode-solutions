/*
 * Problem: 558. Logical OR of Two Binary Grids Represented as Quad-Trees
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/
 * Language: java
 * Date: 2026-04-04
 */

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            if (quadTree1.val)
                return new Node(true, true, null, null, null, null);
            return quadTree2;
        }
        if (quadTree2.isLeaf) {
            if (quadTree2.val)
                return new Node(true, true, null, null, null, null);
            return quadTree1;
        }
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val
                && topRight.val == bottomLeft.val
                && bottomLeft.val == bottomRight.val)
            return new Node(topLeft.val, true, null, null, null, null);
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
