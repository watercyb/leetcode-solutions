/*
 * Problem: 3013. Divide an Array Into Subarrays With Minimum Cost II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        PriorityQueue<int[]> left = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> right = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] isLefts = new boolean[nums.length];
        long sum = nums[0];
        int j = 1;
        int lim = nums.length - k + 1;
        long res = Long.MAX_VALUE;
        for (int i = 1; i <= lim && j < nums.length; i++) {
            while (j < nums.length && j <= i + dist) {
                if (k > 1) {
                    left.add(new int[] { nums[j], j });
                    isLefts[j] = true;
                    sum += nums[j];
                    k--;
                } else if (left.peek()[0] > nums[j]) {
                    int[] pair = left.poll();
                    isLefts[pair[1]] = false;
                    sum += nums[j] - pair[0];
                    left.offer(new int[] { nums[j], j });
                    isLefts[j] = true;
                    right.offer(pair);
                } else {
                    right.offer(new int[] { nums[j], j });
                }
                j++;
            }
            res = Math.min(res, sum);
            if (isLefts[i]) {
                sum -= nums[i];
                k++;
            }
            remove(left, i);
            remove(right, i);
            if (k > 1 && !right.isEmpty()) {
                int[] pair = right.poll();
                isLefts[pair[1]] = true;
                sum += pair[0];
                left.offer(pair);
                k--;
            }
        }
        return res;
    }

    public void remove(PriorityQueue<int[]> PQ, int lim) {
        while (!PQ.isEmpty() && PQ.peek()[1] <= lim) {
            PQ.poll();
        }
    }
}
