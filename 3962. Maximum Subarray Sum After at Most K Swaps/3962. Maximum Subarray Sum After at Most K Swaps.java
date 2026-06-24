/*
 * Problem: 3962. Maximum Subarray Sum After at Most K Swaps
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-subarray-sum-after-at-most-k-swaps/
 * Language: java
 * Date: 2026-06-24
 */

class Solution {
    public long maxSum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        int maxN = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > 0) {
                sum += num;
                count++;
                max = Math.max(max, num);
            } else {
                maxN = Math.max(maxN, num);
            }
        }
        if (count == 0)
            return maxN;
        if (count == 1)
            return max;
        if (count <= k)
            return sum;
        int count1 = 0;
        for (int i = 0; i < count; i++) {
            if (nums[i] > 0)
                count1++;
        }
        if (count1 + k >= count)
            return sum;
        for (int i = count; i < nums.length; i++) {
            if (nums[i] > 0)
                count1++;
            if (nums[i - count] > 0)
                count1--;
            if (count1 + k >= count)
                return sum;
        }
        int[][] topKSums = new int[nums.length][nums.length];
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            PQ.clear();
            sum = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] > 0) {
                    PQ.offer(nums[j]);
                    sum += nums[j];
                    if (PQ.size() > k)
                        sum -= PQ.poll();
                }
            }
            topKSums[i][nums.length - 1] = sum;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > 0) {
                    PQ.offer(nums[j]);
                    sum += nums[j];
                    if (PQ.size() > k)
                        sum -= PQ.poll();
                }
                topKSums[i][j - 1] = sum;
            }
        }
        PQ = new PriorityQueue<>((a, b) -> b - a);
        long res = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            PQ.clear();
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < 0) {
                    PQ.offer(nums[j]);
                    if (PQ.size() > k)
                        sum += PQ.poll();
                } else {
                    sum += nums[j];
                }
                res = Math.max(res, sum + topKSums[i][j]);
            }
        }
        return res;
    }
}
