/*
 * Problem: 2267.  Check if There Is a Valid Parentheses String Path
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public boolean hasValidPath(char[][] grid) {
        if ((grid.length + grid[0].length) % 2 == 0 || grid[0][0] == ')')
            return false;
        HS = new HashSet[grid.length][grid[0].length];
        return dfs(grid, 0, 0, 0);
    }

    HashSet<Integer>[][] HS;

    public boolean dfs(char[][] grid, int i, int j, int num) {
        if (i == grid.length || j == grid[0].length || num < 0)
            return false;
        if (HS[i][j] == null)
            HS[i][j] = new HashSet<>();
        if (!HS[i][j].add(num))
            return false;
        if (grid[i][j] == '(') {
            num++;
        } else {
            num--;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return num == 0;
        return dfs(grid, i + 1, j, num) || dfs(grid, i, j + 1, num);
    }
}
