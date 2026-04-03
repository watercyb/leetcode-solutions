/*
 * Problem: 416. Partition Equal Subset Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partition-equal-subset-sum/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return false;
        sum /= 2;
        boolean[] DP = new boolean[sum];
        DP[0] = true;
        int max = 0;
        for (int num : nums) {
            for (int i = max; i >= 0; i--) {
                if (DP[i]) {
                    int idx = i + num;
                    if (idx == sum)
                        return true;
                    if (idx < sum) {
                        DP[idx] = true;
                        if (idx > max)
                            max = idx;
                    }
                }
            }
        }
        return false;
    }
}
