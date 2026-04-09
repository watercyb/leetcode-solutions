/*
 * Problem: 813. Largest Sum of Averages
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-sum-of-averages/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        double[][] mems = new double[k + 1][nums.length];

        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        return dfs(sum, mems, k, 0, nums.length);
    }

    public double dfs(int[] sum, double[][] mems, int k, int l, int r) {
        if (k == 1)
            return (double) (sum[r] - sum[l]) / (r - l);
        if (mems[k][l]!=0) return mems[k][l];

        double res = 0;
        for (int i = l + 1; i < r - k + 2; i++) {
            double tmp = (double) (sum[i] - sum[l]) / (i - l) + dfs(sum, mems, k - 1, i, r);
            if (tmp > res)
                res = tmp;
        }

        mems[k][l]=res;
        return res;

    }
}
