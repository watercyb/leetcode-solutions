/*
 * Problem: 2640. Find the Score of All Prefixes of an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] res = new long[nums.length];
        int max = 0;
        long prv = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            res[i] = prv + max + nums[i];
            prv = res[i];
        }
        return res;
    }
}
