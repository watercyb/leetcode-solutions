/*
 * Problem: 417. Pacific Atlantic Water Flow
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/pacific-atlantic-water-flow/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] to1 = new boolean[heights.length][heights[0].length];
        boolean[][] to2 = new boolean[heights.length][heights[0].length];
        Queue<int[]> Qu = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        int rl = heights.length - 1;
        int cl = heights[0].length - 1;
        // if (rl == 0 && cl == 0) {
        // res.add(Arrays.asList(new Integer[] { 0, 0 }));
        // return res;
        // }
        for (int i = 0; i < heights.length; i++)
            DFS1(heights, to1, i, 0);
        for (int i = 1; i < heights[0].length; i++)
            DFS1(heights, to1, 0, i);
        for (int i = 0; i < heights.length; i++)
            if (!to2[i][cl])
                DFS2(heights, res, to2, to1, i, cl);
        for (int i = 0; i < cl; i++)
            if (!to2[rl][i])
                DFS2(heights, res, to2, to1, rl, i);
        return res;
    }

    public void DFS1(int[][] heights, boolean[][] to1, int i, int j) {
        to1[i][j] = true;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length) {
                if (!to1[x][y] && heights[x][y] >= heights[i][j])
                    DFS1(heights, to1, x, y);
            }
        }
    }

    public void DFS2(int[][] heights, List<List<Integer>> res, boolean[][] to2, boolean[][] to1, int i, int j) {
        to2[i][j] = true;
        if (to1[i][j])
            res.add(Arrays.asList(new Integer[] { i, j }));
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length) {
                if (!to2[x][y] && heights[x][y] >= heights[i][j])
                    DFS2(heights, res, to2, to1, x, y);
            }
        }
    }
}
