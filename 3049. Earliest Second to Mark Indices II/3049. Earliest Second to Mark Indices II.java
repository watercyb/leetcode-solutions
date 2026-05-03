/*
 * Problem: 3049. Earliest Second to Mark Indices II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/earliest-second-to-mark-indices-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        long sum = 0;
        for (int num : nums) {
            sum += num + 1;
        }
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < changeIndices.length; i++) {
            int idx = changeIndices[i] - 1;
            if (nums[idx] == 0 || used[idx]) {
                changeIndices[i] = -1;
            } else {
                used[idx] = true;
                changeIndices[i] = idx;
            }
        }
        int l = 0;
        int r = changeIndices.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(nums, changeIndices, mid, sum)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l == changeIndices.length)
            return -1;
        return l + 1;
    }

    public boolean chk(int[] nums, int[] changeIndices, int mid, long sum) {
        if (mid + 1 >= sum)
            return true;
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        int count = 1;
        for (int i = mid - 1; i >= 0; i--) {
            int idx = changeIndices[i];
            if (idx == -1) {
                count++;
            } else if (count > 0) {
                PQ.offer(nums[idx]);
                count--;
                sum -= nums[idx] + 1;
            } else {
                if (!PQ.isEmpty() && PQ.peek() < nums[idx]) {
                    sum -= nums[idx] - PQ.peek();
                }
                count++;
            }
        }
        return count >= sum;
    }
}
