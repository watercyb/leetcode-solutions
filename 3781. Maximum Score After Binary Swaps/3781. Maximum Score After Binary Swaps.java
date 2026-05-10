/*
 * Problem: 3781. Maximum Score After Binary Swaps
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-score-after-binary-swaps/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long maximumScore(int[] nums, String s) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a, b) -> b - a);
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            PQ.offer(nums[i]);
            if (s.charAt(i) == '1')
                res += PQ.poll();
        }
        return res;
    }
}
