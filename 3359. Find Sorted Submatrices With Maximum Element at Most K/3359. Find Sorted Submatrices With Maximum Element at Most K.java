/*
 * Problem: 3359. Find Sorted Submatrices With Maximum Element at Most K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-sorted-submatrices-with-maximum-element-at-most-k/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public long countSubmatrices(int[][] grid, int k) {
        int[][] MQs = new int[grid[0].length][grid.length + 1];
        long[][] sums = new long[grid[0].length][grid.length + 1];
        int[][] rowNums = new int[grid[0].length][grid.length + 1];
        int[] index = new int[grid[0].length];
        Arrays.fill(index, 1);
        for (int i = 0; i < grid[0].length; i++) {
            MQs[i][0] = -1;
            sums[i][0] = 0;
            rowNums[i][0] = -1;
        }
        long res = 0;
        for (int i = 0; i < grid.length; i++) {
            int len = 0;
            int prv = 0;
            for (int j = 0; j < grid[0].length; j++) {
                int[] MQ = MQs[j];
                long[] sum = sums[j];
                int[] rowNum = rowNums[j];
                int idx = index[j];
                if (grid[i][j] > k) {
                    len = 0;
                } else if (grid[i][j] > prv) {
                    len = 1;
                } else {
                    len++;
                }
                while (idx > 0 && MQ[idx - 1] >= len) {
                    idx--;
                }
                sum[idx] = sum[idx - 1] + len * (i - rowNum[idx - 1]);
                res += sum[idx];
                rowNum[idx] = i;
                MQ[idx++] = len;
                index[j] = idx;
                prv = grid[i][j];
            }
        }
        return res;
    }
}
