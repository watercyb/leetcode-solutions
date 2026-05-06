/*
 * Problem: 3397. Maximum Number of Distinct Elements After Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        if (k * 2 + 1 >= nums.length)
            return nums.length;
        int prv = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int res = 0;
        for (int num : nums) {
            if (num + k > prv) {
                res++;
                prv = Math.max(prv + 1, num - k);
            }
        }
        return res;
    }
}
