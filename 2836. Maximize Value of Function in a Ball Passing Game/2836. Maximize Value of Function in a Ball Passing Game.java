/*
 * Problem: 2836. Maximize Value of Function in a Ball Passing Game
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-value-of-function-in-a-ball-passing-game/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int rl = receiver.size();
        int cl = (int) (Math.log(k) / Math.log(2)) + 1;
        int[][] arr = new int[rl][cl];
        long[][] sum = new long[rl][cl];
        for (int i = 0; i < rl; i++) {
            arr[i][0] = receiver.get(i);
            sum[i][0] = i;
        }
        for (int j = 1; j < cl; j++) {
            for (int i = 0; i < rl; i++) {
                arr[i][j] = arr[arr[i][j - 1]][j - 1];
                sum[i][j] = sum[i][j - 1] + sum[arr[i][j - 1]][j - 1];
            }
        }
        long max = 0;
        for (int i = 0; i < rl; i++) {
            int n = 0;
            int idx = i;
            long sumTmp = 0;
            while ((k>>>n)>0) {
                if ((k>>>n&1) == 1) {
                    sumTmp += sum[idx][n];
                    idx = arr[idx][n];
                }
                n++;
            }
            sumTmp += idx;
            if (sumTmp > max)
                max = sumTmp;
        }
        return max;
    }
}
