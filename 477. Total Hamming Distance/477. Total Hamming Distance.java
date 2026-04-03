/*
 * Problem: 477. Total Hamming Distance
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/total-hamming-distance/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] counts = new int[31];
        int res = 0;
        for (int i = 0; i < 30; i++) {
            for (int num : nums) {
                num >>= i;
                counts[i] += num & 1;
            }
            res += (nums.length - counts[i]) * counts[i];
        }
        return res;
    }
}
