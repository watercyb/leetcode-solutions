/*
 * Problem: 2163. Minimum Difference in Sums After Removal of Elements
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public long minimumDifference(int[] nums) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;
        int n = nums.length / 3;
        for (int i = 0; i < n; i++) {
            PQ.offer(nums[i]);
            sum += nums[i];
        }
        long[] left = new long[nums.length];
        left[n - 1] = sum;
        for (int i = n; i < 2 * n; i++) {
            if (nums[i] < PQ.peek()) {
                sum += nums[i] - PQ.poll();
                PQ.offer(nums[i]);
            }
            left[i] = sum;
        }
        PQ = new PriorityQueue<>();
        sum = 0;
        for (int i = nums.length - 1; i >= 2 * n; i--) {
            PQ.offer(nums[i]);
            sum += nums[i];
        }
        long res = left[2 * n - 1] - sum;
        for (int i = 2 * n - 1; i >= n; i--) {
            if (nums[i] > PQ.peek()) {
                sum += nums[i] - PQ.poll();
                PQ.offer(nums[i]);
            }
            res = Math.min(left[i - 1] - sum, res);
        }
        return res;
    }
}
