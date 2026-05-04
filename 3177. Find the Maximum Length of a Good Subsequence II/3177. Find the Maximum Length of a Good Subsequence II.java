/*
 * Problem: 3177. Find the Maximum Length of a Good Subsequence II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-maximum-length-of-a-good-subsequence-ii/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int maximumLength(int[] nums, int k) {
        int[] DP = new int[k + 1];
        DP[0] = 1;
        int[] max = DP.clone();
        HashMap<Integer, int[]> HM = new HashMap<>();
        HM.put(nums[0], DP);
        for (int i = 1; i < nums.length; i++) {
            if (HM.containsKey(nums[i])) {
                DP = HM.get(nums[i]);
            } else {
                DP = new int[k + 1];
                HM.put(nums[i], DP);
            }
            int maxNum = 0;
            for (int j = 0; j <= k; j++) {
                DP[j] = Math.max(maxNum, DP[j]) + 1;
                maxNum = max[j];
                max[j] = Math.max(DP[j], max[j]);
            }
        }
        int res = 0;
        for (int i = 0; i <= k; i++) {
            res = Math.max(max[i], res);
        }
        return res;
    }
}
