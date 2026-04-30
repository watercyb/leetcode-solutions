/*
 * Problem: 2750. Ways to Split Array Into Good Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/ways-to-split-array-into-good-subarrays/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int mod = 1_000_000_007;
        int idx = 0;
        while (idx < nums.length && nums[idx] == 0) {
            idx++;
        }
        if (idx == nums.length)
            return 0;
        long res = 1;
        int prv = idx++;
        while (idx < nums.length) {
            if (nums[idx] == 1) {
                res = res * (idx - prv) % mod;
                prv = idx;
            }
            idx++;
        }
        return (int) res;
    }
}
