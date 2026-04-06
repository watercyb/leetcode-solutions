/*
 * Problem: 698. Partition to K Equal Sum Subsets
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0)
            return false;
        int l = sum / k;
        int[] DP = new int[1 << nums.length];
        Arrays.fill(DP, -1);
        DP[0] = 0;
        for (int i = 0; i < DP.length; i++) {
            if (DP[i] == -1)
                continue;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) == 0 && DP[i] + nums[j] <= l)
                    DP[i + (1 << j)] = (DP[i] + nums[j]) % l;
            }
        }
        return DP[DP.length - 1] == 0;
    }
}
