/*
 * Problem: 2530. Maximal Score After Applying K Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximal-score-after-applying-k-operations/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            PQ.offer(num);
        }
        int current = PQ.poll();
        long res = current;
        current = (int) Math.ceil((double) current / 3);
        k--;
        while (k > 0) {
            if (!PQ.isEmpty() && current < PQ.peek()) {
                PQ.offer(current);
                current = PQ.poll();
            }
            res += current;
            current = (int) Math.ceil((double) current / 3);
            k--;
        }
        return res;
    }
}
