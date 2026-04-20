/*
 * Problem: 1714. Sum Of Special Evenly-Spaced Elements In Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-special-evenly-spaced-elements-in-array/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int[] solve(int[] nums, int[][] queries) {
        int mod = 1_000_000_007;
        int lim = (int) Math.sqrt(nums.length);
        int[][] arr = new int[lim][];
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (y >= lim) {
                Long sum = 0l;
                for (int j = x; j < nums.length; j += y) {
                    sum += nums[j];
                }
                res[i] = (int) (sum % mod);
            } else {
                if (arr[y] == null) {
                    arr[y] = new int[nums.length];
                    long[] sums = new long[y];
                    for (int j = nums.length - 1; j >= 0; j--) {
                        sums[j % y] += nums[j];
                        arr[y][j] = (int) (sums[j % y] % mod);
                    }
                }
                res[i] = arr[y][x];
            }
        }
        return res;
    }
}
