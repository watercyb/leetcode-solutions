/*
 * Problem: 891. Sum of Subsequence Widths
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-subsequence-widths/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int sumSubseqWidths(int[] nums) {
        int mod = 1_000_000_007;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]++;
        }
        int idx = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[idx++] = i;
            }
        }
        int res = 0;
        long count = 1;
        long diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            long sum = 0;
            diff += nums[nums.length - 1 - i] - nums[i];
            res = (int) (((long) res + count * diff) % mod);
            count = count * 2 % mod;
        }
        return res;
    }
}
