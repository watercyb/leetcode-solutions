/*
 * Problem: 995. Minimum Number of K Consecutive Bit Flips
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int res = 0;
        int mask = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            nums[i + k - 1] ^= mask;
            if (nums[i] != mask)
                continue;
            res++;
            mask ^= 1;
        }
        for (int i = nums.length - k + 1; i < nums.length; i++) {
            if (nums[i] == mask)
                return -1;
        }
        return res;
    }
}
