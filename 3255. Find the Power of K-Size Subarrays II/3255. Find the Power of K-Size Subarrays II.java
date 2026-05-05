/*
 * Problem: 3255. Find the Power of K-Size Subarrays II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-power-of-k-size-subarrays-ii/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Arrays.fill(res, -1);
        int count = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 0;
            }
        }
        if (count == k - 1)
            res[0] = nums[k - 1];
        for (int i = 1; i <= nums.length - k; i++) {
            if (nums[i + k - 1] == nums[i + k - 2] + 1) {
                count++;
            } else {
                count = 0;
            }
            if (count >= k - 1)
                res[i] = nums[i + k - 1];
        }
        return res;
    }
}
