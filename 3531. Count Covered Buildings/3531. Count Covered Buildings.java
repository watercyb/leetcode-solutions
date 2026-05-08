/*
 * Problem: 3531. Count Covered Buildings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-covered-buildings/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int rowMax = Integer.MIN_VALUE;
        int rowMin = Integer.MAX_VALUE;
        int colMax = Integer.MIN_VALUE;
        int colMin = Integer.MAX_VALUE;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            rowMax = Math.max(x, rowMax);
            rowMin = Math.min(x, rowMin);
            colMax = Math.max(y, colMax);
            colMin = Math.min(y, colMin);
        }
        int[] rowsMin = new int[rowMax + 1];
        int[] rowsMax = new int[rowMax + 1];
        int[] colsMin = new int[colMax + 1];
        int[] colsMax = new int[colMax + 1];
        Arrays.fill(rowsMin, 100001);
        Arrays.fill(colsMin, 100001);
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            rowsMax[x] = Math.max(y, rowsMax[x]);
            rowsMin[x] = Math.min(y, rowsMin[x]);
            colsMax[y] = Math.max(x, colsMax[y]);
            colsMin[y] = Math.min(x, colsMin[y]);
        }
        int res = 0;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            if (rowsMin[x] < y && rowsMax[x] > y && colsMin[y] < x && colsMax[y] > x)
                res++;
        }
        return res;
    }
}
