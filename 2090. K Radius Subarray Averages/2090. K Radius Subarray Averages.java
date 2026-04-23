/*
 * Problem: 2090. K Radius Subarray Averages
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/k-radius-subarray-averages/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        if (nums.length <= 2 * k)
            return res;
        long sum = 0;
        for (int i = 0; i < 2 * k + 1; i++) {
            sum += nums[i];
        }
        int div = 2 * k + 1;
        res[k] = (int) (sum / div);
        for (int i = k + 1; i < nums.length - k; i++) {
            sum += nums[i + k] - nums[i - k - 1];
            res[i] = (int) (sum / div);
        }
        return res;
    }
}
