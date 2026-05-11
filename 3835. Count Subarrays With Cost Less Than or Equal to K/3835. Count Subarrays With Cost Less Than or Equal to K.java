/*
 * Problem: 3835. Count Subarrays With Cost Less Than or Equal to K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-subarrays-with-cost-less-than-or-equal-to-k/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public long countSubarrays(int[] nums, long k) {
        int[] MQMax = new int[nums.length];
        int[] MQMin = new int[nums.length];
        int lMax = 0;
        int rMax = 0;
        int lMin = 0;
        int rMin = 0;
        int j = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (rMax > lMax && nums[MQMax[rMax - 1]] <= nums[i]) {
                rMax--;
            }
            MQMax[rMax++] = i;
            while (rMin > lMin && nums[MQMin[rMin - 1]] >= nums[i]) {
                rMin--;
            }
            MQMin[rMin++] = i;
            while ((long) (nums[MQMax[lMax]] - nums[MQMin[lMin]]) * (i - j + 1) > k) {
                if (MQMax[lMax] <= j) {
                    lMax++;
                }
                if (MQMin[lMin] <= j) {
                    lMin++;
                }
                j++;
            }
            res += i - j + 1;
        }
        return res;
    }
}
