/*
 * Problem: 2104. Sum of Subarray Ranges
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-subarray-ranges/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public long subArrayRanges(int[] nums) {
        int[] max = new int[nums.length];
        int idxMax = 0;
        int[] min = new int[nums.length];
        int idxMin = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (idxMax > 0 && nums[i] >= nums[max[idxMax - 1]]) {
                if (idxMax == 1) {
                    res += (long) (max[idxMax - 1] + 1) * (i - max[idxMax - 1]) * nums[max[idxMax - 1]];
                } else {
                    res += (long) (max[idxMax - 1] - max[idxMax - 2]) * (i - max[idxMax - 1]) * nums[max[idxMax - 1]];
                }
                idxMax--;
            }
            max[idxMax++] = i;
            while (idxMin > 0 && nums[i] <= nums[min[idxMin - 1]]) {
                if (idxMin == 1) {
                    res -= (long) (min[idxMin - 1] + 1) * (i - min[idxMin - 1]) * nums[min[idxMin - 1]];
                } else {
                    res -= (long) (min[idxMin - 1] - min[idxMin - 2]) * (i - min[idxMin - 1]) * nums[min[idxMin - 1]];
                }
                idxMin--;
            }
            min[idxMin++] = i;
        }
        while (idxMax > 0) {
            if (idxMax == 1) {
                res += (long) (max[idxMax - 1] + 1) * (nums.length - max[idxMax - 1]) * nums[max[idxMax - 1]];
            } else {
                res += (long) (max[idxMax - 1] - max[idxMax - 2]) * (nums.length - max[idxMax - 1])
                        * nums[max[idxMax - 1]];
            }
            idxMax--;
        }
        while (idxMin > 0) {
            if (idxMin == 1) {
                res -= (long) (min[idxMin - 1] + 1) * (nums.length - min[idxMin - 1]) * nums[min[idxMin - 1]];
            } else {
                res -= (long) (min[idxMin - 1] - min[idxMin - 2]) * (nums.length - min[idxMin - 1])
                        * nums[min[idxMin - 1]];
            }
            idxMin--;
        }
        return res;
    }
}
