/*
 * Problem: 1005. Maximize Sum Of Array After K Negations
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int idx = 0;
        while (idx < nums.length && nums[idx] < 0) {
            idx++;
        }
        if (idx <= k) {
            if (idx % 2 != k % 2 && (idx == nums.length || nums[idx] != 0)) {
                int res = 0;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < nums.length; i++) {
                    int num = Math.abs(nums[i]);
                    res += num;
                    min = Math.min(min, num);

                }
                return res - 2 * min;
            } else {
                int res = 0;
                for (int i = 0; i < idx; i++) {
                    res -= nums[i];
                }
                for (int i = idx; i < nums.length; i++) {
                    res += nums[i];
                }
                return res;
            }
        } else {
            int res = 0;
            for (int i = 0; i < k; i++) {
                res -= nums[i];
            }
            for (int i = k; i < nums.length; i++) {
                res += nums[i];
            }
            return res;
        }
    }
}
