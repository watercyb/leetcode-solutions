/*
 * Problem: 3685. Subsequence Sum After Capping Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/subsequence-sum-after-capping-elements/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        Arrays.sort(nums);
        boolean[] DP = new boolean[k + 1];
        DP[0] = true;
        boolean[] res = new boolean[nums.length];
        int idx = 0;
        for (int i = 0; i < res.length; i++) {
            while (idx < nums.length && nums[idx] <= i) {
                for (int j = k - nums[idx]; j >= 0; j--) {
                    if (DP[j])
                        DP[j + nums[idx]] = true;
                }
                idx++;
            }
            if (DP[k]) {
                while (i < res.length) {
                    res[i++] = true;
                }
                break;
            }
            for (int j = 0; j <= Math.min((nums.length - idx) * (i + 1), k); j += i + 1) {
                if (DP[k - j]) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res;
    }
}
