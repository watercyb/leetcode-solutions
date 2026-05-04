/*
 * Problem: 3149. Find the Minimum Cost Array Permutation
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-minimum-cost-array-permutation/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int[] findPermutation(int[] nums) {
        int[][] meme = new int[1 << nums.length][nums.length];
        for (int[] row : meme) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        int target = dfs(nums, meme, 1, 1, 0);
        int[] res = new int[nums.length];
        int h = 1;
        int score = 0;
        int prv = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (score + meme[h + (1 << j)][j] + Math.abs(prv - nums[j]) == target) {
                    score += Math.abs(prv - nums[j]);
                    prv = j;
                    res[i] = j;
                    h += 1 << j;
                    break;
                }
            }
        }
        return res;
    }

    public int dfs(int[] nums, int[][] meme, int h, int i, int prv) {
        if (i == nums.length)
            return meme[h][prv] = Math.abs(prv - nums[0]);
        if (meme[h][prv] < Integer.MAX_VALUE / 2)
            return meme[h][prv];
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            if ((h & (1 << j)) == 0) {
                res = Math.min(dfs(nums, meme, h + (1 << j), i + 1, j) + Math.abs(prv - nums[j]), res);
            }
        }
        return meme[h][prv] = res;
    }
}
