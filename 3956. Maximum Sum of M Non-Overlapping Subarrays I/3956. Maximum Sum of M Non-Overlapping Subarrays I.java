/*
 * Problem: 3956. Maximum Sum of M Non-Overlapping Subarrays I
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-sum-of-m-non-overlapping-subarrays-i/
 * Language: java
 * Date: 2026-06-08
 */

class Solution {
    public long maximumSum(int[] nums, int m, int l, int r) {
        sums = new long[nums.length];
        counts = new int[nums.length];
        MQ = new int[nums.length];
        if ((long) m * l >= nums.length)
            return chk(nums, l, r, 0).getValue();
        long left = 0;
        long right = 1l << 40;
        while (left < right) {
            long mid = (left + right) >>> 1;
            Pair<Integer, Long> pair = chk(nums, l, r, mid);
            if (pair.getKey() <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        Pair<Integer, Long> pair = chk(nums, l, r, left);
        return pair.getValue() + left * m;
    }

    long[] sums;
    int[] counts;
    int[] MQ;

    public Pair<Integer, Long> chk(int[] nums, int l, int r, long p) {
        long sum = 0;
        int left = 0;
        int right = 0;
        long max = Long.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int leftLim = i - r;
            int rightLim = i - l;
            while (left < right && MQ[left] < leftLim) {
                left++;
            }
            if (rightLim >= 0) {
                while (right > left && (sums[rightLim] > sums[MQ[right - 1]]
                        || (sums[rightLim] == sums[MQ[right - 1]] && counts[rightLim] <= counts[MQ[right - 1]]))) {
                    right--;
                }
                MQ[right] = rightLim;
                right++;
            }
            if (i >= l) {
                long current = sums[MQ[left]] - p + sum;
                if (current > max || (current == max && counts[MQ[left]] + 1 < count)) {
                    max = current;
                    count = counts[MQ[left]] + 1;
                }
                if (max <= 0) {
                    sums[i] = -sum;
                    counts[i] = 0;
                } else {
                    sums[i] = max - sum;
                    counts[i] = count;
                }
            } else {
                sums[i] = -sum;
                counts[i] = 0;
            }
            sum += nums[i];
        }
        int leftLim = nums.length - r;
        int rightLim = nums.length - l;
        while (left < right && MQ[left] < leftLim) {
            left++;
        }
        while (right > left && (sums[rightLim] > sums[MQ[right - 1]]
                || (sums[rightLim] == sums[MQ[right - 1]] && counts[rightLim] <= counts[MQ[right - 1]]))) {
            right--;
        }
        MQ[right] = rightLim;
        right++;
        long current = sums[MQ[left]] - p + sum;
        if (current > max || (current == max && counts[MQ[left]] + 1 < count)) {
            max = current;
            count = counts[MQ[left]] + 1;
        }
        return new Pair<>(count, max);
    }
}
