/*
 * Problem: 480. Sliding Window Median
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sliding-window-median/
 * Language: java
 * Date: 2026-04-03
 */


class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        if (k == 1) {
            for (int i = 0; i < nums.length; i++) {
                res[i] = (double) nums[i];
            }
            return res;
        }
        boolean[] isBefore = new boolean[nums.length];
        PriorityQueue<Integer> PQBefore = new PriorityQueue<>((a, b) -> Integer.compare(nums[b], nums[a]));
        PriorityQueue<Integer> PQAfter = new PriorityQueue<>((a, b) -> Integer.compare(nums[a], nums[b]));
        for (int i = 0; i < k; i++) {
            PQBefore.offer(i);
            isBefore[i] = true;
        }
        for (int i = 0; i < k / 2; i++) {
            int max = PQBefore.poll();
            isBefore[max] = false;
            PQAfter.offer(max);
        }
        boolean odd = (k % 2 == 1);
        if (odd) {
            res[0] = (double) nums[PQBefore.peek()];
        } else {
            res[0] = ((double) nums[PQBefore.peek()] + nums[PQAfter.peek()]) / 2;
        }
        for (int i = k; i < nums.length; i++) {
            int j = i - k;
            int before = PQBefore.peek();
            int after = PQAfter.peek();
            if (isBefore[j]) {
                if (nums[i] <= nums[before]) {
                    PQBefore.offer(i);
                    isBefore[i] = true;
                } else {
                    PQAfter.offer(i);
                    int min = PQAfter.poll();
                    while (min <= j) {
                        min = PQAfter.poll();
                    }
                    PQBefore.offer(min);
                    isBefore[min] = true;
                }
            } else {
                if (nums[i] >= nums[after]) {
                    PQAfter.offer(i);
                } else {
                    PQBefore.offer(i);
                    isBefore[i] = true;
                    int max = PQBefore.poll();
                    while (max <= j) {
                        max = PQBefore.poll();
                    }
                    isBefore[max] = false;
                    PQAfter.offer(max);
                }
            }
            while (PQBefore.peek() <= j) {
                PQBefore.poll();
            }
            while (PQAfter.peek() <= j) {
                PQAfter.poll();
            }
            if (odd) {
                res[j + 1] = (double) nums[PQBefore.peek()];
            } else {
                res[j + 1] = ((double) nums[PQBefore.peek()] + nums[PQAfter.peek()]) / 2;
            }
        }
        return res;
    }
}
