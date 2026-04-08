/*
 * Problem: 740. Delete and Earn
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/delete-and-earn/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] freq = new int[max + 1];
        for (int num : nums) {
            freq[num]+=num;
        }
        int DP1 = 0;
        int DP2 = 0;
        for (int i = 0; i < freq.length; i++) {
            int tmp = Math.max(DP2, DP1 + freq[i]);
            DP1 = DP2;
            DP2 = tmp;
        }
        return DP2;
    }
}
