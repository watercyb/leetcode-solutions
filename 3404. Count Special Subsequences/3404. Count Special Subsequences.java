/*
 * Problem: 3404. Count Special Subsequences
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-special-subsequences/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long numberOfSubsequences(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        max++;
        long res = 0;
        int[] counts = new int[max * max];
        for (int i = 4; i < nums.length; i++) {
            for (int j = i - 4; j >= 0; j--) {
                int gcd = GCD(nums[i - 2], nums[j]);
                int k = nums[i - 2] / gcd * max + nums[j] / gcd;
                counts[k]++;
            }
            for (int j = i + 2; j < nums.length; j++) {
                int gcd = GCD(nums[i], nums[j]);
                res += counts[nums[i] / gcd * max + nums[j] / gcd];
            }
        }
        return res;
    }

    static int[][] meme = new int[1001][1001];

    public int GCD(int a, int b) {
        if (meme[a][b] != 0)
            return meme[a][b];
        if (b == 0)
            return a;
        return meme[a][b] = meme[b][a] = GCD(b, a % b);
    }
}
