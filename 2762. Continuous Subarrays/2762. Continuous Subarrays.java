/*
 * Problem: 2762. Continuous Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/continuous-subarrays/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public long continuousSubarrays(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int i = 0;
        int j = 0;
        long res = 0;
        boolean isMax = false;
        while (j < nums.length) {
            while (max - min <= 2) {
                j++;
                if (j == nums.length) {
                    res += (long) (nums.length - i + 1) * (nums.length - i) / 2;
                    return res;
                }
                if (nums[j] > max) {
                    max = nums[j];
                    isMax = true;
                } else if (nums[j] < min) {
                    min = nums[j];
                    isMax = false;
                }
            }
            int k = j - 1;
            if (isMax) {
                min = max;
                while (max - nums[k] <= 2) {
                    min = Math.min(nums[k], min);
                    k--;
                }
            } else {
                max = min;
                while (nums[k] - min <= 2) {
                    max = Math.max(nums[k], max);
                    k--;
                }
            }
            res += (long) (j - i + j - k) * (k - i + 1) / 2;
            i = k + 1;
        }
        return res;
    }
}
