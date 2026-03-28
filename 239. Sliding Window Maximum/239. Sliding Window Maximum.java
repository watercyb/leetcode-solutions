/*
 * Problem: 239. Sliding Window Maximum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sliding-window-maximum/
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] MQ = new int[nums.length];
        int[] res = new int[nums.length - k + 1];
        int l = 0;
        int r = -1;
        for (int i = 0; i < k - 1; i++) {
            while (r >= l && nums[i] > MQ[r]) {
                r--;
            }
            MQ[++r] = nums[i];
        }
        for (int i = 0; i < res.length; i++) {
            int idx = i + k - 1;
            while (r >= l && nums[idx] > MQ[r]) {
                r--;
            }
            MQ[++r] = nums[idx];
            res[i] = MQ[l];
            if (MQ[l] == nums[i])
                l++;
        }
        return res;
    }
}
