/*
 * Problem: 3659. Partition Array Into K-Distinct Groups
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partition-array-into-k-distinct-groups/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public boolean partitionArray(int[] nums, int k) {
        if (nums.length % k != 0)
            return false;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] counts = new int[max + 1];
        for (int num : nums) {
            counts[num]++;
        }
        max = 0;
        for (int c : counts) {
            max = Math.max(max, c);
        }
        return nums.length >= max * k;
    }
}
