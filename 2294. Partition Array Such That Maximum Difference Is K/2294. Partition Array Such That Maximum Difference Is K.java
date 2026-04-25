/*
 * Problem: 2294. Partition Array Such That Maximum Difference Is K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int partitionArray(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        for (int num : nums) {
            counts[num]++;
        }
        int res = 0;
        int prv = Integer.MIN_VALUE / 2;
        for (int i = 0; i <= max; i++) {
            if (counts[i] > 0 && i - prv > k) {
                res++;
                prv = i;
            }
        }
        return res;
    }
}
