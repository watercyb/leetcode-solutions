/*
 * Problem: 3420. Count Non-Decreasing Subarrays After K Operations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        long res = 0;
        int j = nums.length;
        int[] MQ = new int[nums.length];
        int l = 0;
        int r = 0;
        long sum = k;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (j >= 1 && sum >= 0) {
                j--;
                while (l < r && nums[j] > nums[MQ[r - 1]]) {
                    if (l + 1 < r) {
                        sum -= (long) (nums[j] - nums[MQ[r - 1]]) * (MQ[r - 2] - MQ[r - 1]);
                    } else {
                        sum -= (long) (nums[j] - nums[MQ[r - 1]]) * (i - MQ[r - 1] + 1);
                    }
                    r--;
                }
                MQ[r++] = j;
            }
            if (sum >= 0)
                return res + (long) (i + 2) * (i + 1) / 2;
            res += i - j;
            if (MQ[l] == i) {
                l++;
            } else {
                sum += nums[MQ[l]] - nums[i];
            }
        }
        return res;
    }
}

