/*
 * Problem: 2968. Apply Operations to Maximize Frequency Score
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/apply-operations-to-maximize-frequency-score/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int res = 0;
        int j = 0;
        int l = 0;
        int move = 0;
        for (int i = 0; i < nums.length; i++) {
            while (k >= 0) {
                l++;
                if (l == nums.length) {
                    res = Math.max(l - i, res);
                    return res;
                }
                k -= nums[l];
                j += move;
                move = 1 - move;
                k += nums[j];
            }
            res = Math.max(l - i, res);
            k -= nums[i];
            j += move;
            move = 1 - move;
            k += nums[j];
        }
        return res;
    }
}
