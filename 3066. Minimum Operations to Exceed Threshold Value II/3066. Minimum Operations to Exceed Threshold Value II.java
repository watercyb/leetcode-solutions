/*
 * Problem: 3066. Minimum Operations to Exceed Threshold Value II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> PQ = new PriorityQueue<>();
        for (int num : nums) {
            if (num < k)
                PQ.offer((long) num);
        }
        int res = 0;
        while (PQ.size() > 1) {
            long a = PQ.poll();
            long b = PQ.poll();
            long c = 2 * a + b;
            if (c < k)
                PQ.offer(c);
            res++;
        }
        return res + PQ.size();
    }
}
