/*
 * Problem: 164. Maximum Gap
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-gap/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int res = 0;
        int size = Math.max((max - min + 1) / nums.length, 1);
        int n = (max - min + size) / size;
        int[] mins = new int[n];
        int[] maxs = new int[n];
        Arrays.fill(mins, Integer.MAX_VALUE);
        for (int num : nums) {
            int idx = (num - min) / size;
            maxs[idx] = Math.max(num, maxs[idx]);
            mins[idx] = Math.min(num, mins[idx]);
        }
        int prv = maxs[0];
        for (int i = 1; i < mins.length; i++) {
            if (mins[i] != Integer.MAX_VALUE) {
                res = Math.max(mins[i] - prv, res);
                prv = maxs[i];
            }
        }
        return res;
    }
}
