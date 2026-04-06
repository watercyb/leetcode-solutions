/*
 * Problem: 644. Maximum Average Subarray II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-average-subarray-ii/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        Deque<Integer> Dq = new ArrayDeque<>();
        double res = Integer.MIN_VALUE;
        for (int i = k; i <= nums.length; i++) {
            while (Dq.size() >= 2) {
                int r = Dq.pollLast();
                int l = Dq.peekLast();
                int tmp = i - k;
                if ((sums[tmp] - sums[r]) * (tmp - l) >= (sums[tmp] - sums[l]) * (tmp - r)) {
                    Dq.offerLast(r);
                    break;
                }
            }
            Dq.offerLast(i - k);
            while (Dq.size() >= 2) {
                int tmp1 = Dq.pollFirst();
                int tmp2 = Dq.peekFirst();
                if ((sums[i] - sums[tmp1]) * (i - tmp2) > (sums[i] - sums[tmp2]) * (i - tmp1)) {
                    Dq.offerFirst(tmp1);
                    break;
                }
            }
            int tmp = Dq.peekFirst();
            res = Math.max((double) (sums[i] - sums[tmp]) / (i - tmp), res);
        }
        return res;
    }
}
