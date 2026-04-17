/*
 * Problem: 1498. Number of Subsequences That Satisfy the Given Sum Condition
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int numSubseq(int[] nums, int target) {
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
        target -= 2 * min;
        int idx = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                nums[idx++] = i;
                counts[i]--;
            }
        }
        int[] powers = new int[nums.length];
        powers[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            powers[i] = powers[i - 1] * 2 % mod;
        }
        int j = nums.length - 1;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j >= i && nums[i] + nums[j] > target) {
                j--;
            }
            if (j < i)
                break;
            if (j == i) {
                res++;
            } else {
                res = (res + powers[j - i]) % mod;
            }
        }
        return (int) (res % mod);
    }
}
