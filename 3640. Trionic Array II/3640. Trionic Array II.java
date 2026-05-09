/*
 * Problem: 3640. Trionic Array II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/trionic-array-ii/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long maxSumTrionic(int[] nums) {
        long res = Long.MIN_VALUE;
        int idx = 0;
        while (idx < nums.length) {
            int a = idx;
            long sum = nums[idx];
            while (idx < nums.length - 1 && nums[idx] < nums[idx + 1]) {
                sum += nums[++idx];
            }
            if (idx == a || idx == nums.length - 1 || nums[idx] == nums[idx + 1]) {
                idx++;
                continue;
            }
            int b = idx;
            while (idx < nums.length - 1 && nums[idx] > nums[idx + 1]) {
                sum += nums[++idx];
            }
            if (idx == nums.length - 1 || nums[idx] == nums[idx + 1]) {
                idx++;
                continue;
            }
            int c = idx;
            long sumRight = 0;
            while (idx < nums.length - 1 && nums[idx] < nums[idx + 1]) {
                sumRight += nums[++idx];
                sum += nums[idx];
            }
            while (a < b - 1 && nums[a] < 0) {
                sum -= nums[a];
                a++;
            }
            if (sumRight < nums[c + 1])
                sum -= sumRight - nums[c + 1];
            res = Math.max(sum, res);
            idx = c;
        }
        return res;
    }
}
