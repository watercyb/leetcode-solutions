/*
 * Problem: 3882. Minimum XOR Path in a Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-xor-path-in-a-grid/
 * Language: csharp
 * Date: 2026-03-31
 */

public class Solution {
    public int MinCost(int[][] grid) {
        bool[,] dp=new bool[grid[0].Length, 1024];
        dp[0, 0]=true;
        for (int i=0;i<grid.Length;i++) {
            bool[,] dp_next=new bool[grid[0].Length, 1024];
            for (int k=0;k<1024;k++) {
                if (dp[0, k]) dp_next[0, k^grid[i][0]]=true;
            }
            for (int j=1;j<grid[0].Length;j++) {
                for (int k=0;k<1024;k++) {
                    if (dp[j, k]||dp_next[j-1, k]) dp_next[j, k^grid[i][j]]=true;
                }
            }
            dp=dp_next;
        }
        for (int i=0;i<1024;i++) {
            if (dp[grid[0].Length-1, i]) return i;
        }
        return -1;
    }
}
