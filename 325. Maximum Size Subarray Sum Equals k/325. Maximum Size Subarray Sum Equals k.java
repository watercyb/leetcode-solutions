/*
 * Problem: 325. Maximum Size Subarray Sum Equals k
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 * Language: java
 * Date: 2026-04-01
 */

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        int sum = 0;
        HM.put(0, -1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int diff = sum - k;
            res = Math.max(i - HM.getOrDefault(diff, Integer.MAX_VALUE / 2), res);
            HM.putIfAbsent(sum, i);
        }
        return res;
    }
}
