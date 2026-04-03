/*
 * Problem: 427. Construct Quad Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-quad-tree/
 * Language: java
 * Date: 2026-04-03
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

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    public Node dfs(int[][] grid, int row1, int row2, int col1, int col2) {
        if (chk(grid, row1, row2, col1, col2)) {
            return new Node(grid[row1][col1] == 1, true);
        } else {
            int rowMid = (row1 + row2) >>> 1;
        int colMid = (col1 + col2) >>> 1;
            return new Node(false, false, dfs(grid, row1, rowMid, col1, colMid),
                    dfs(grid, row1, rowMid, colMid + 1, col2), dfs(grid, rowMid + 1, row2, col1, colMid),
                    dfs(grid, rowMid + 1, row2, colMid + 1, col2));
        }
    }

    public boolean chk(int[][] grid, int row1, int row2, int col1, int col2) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                if (grid[i][j] != grid[row1][col1])
                    return false;
            }
        }
        return true;
    }
}
