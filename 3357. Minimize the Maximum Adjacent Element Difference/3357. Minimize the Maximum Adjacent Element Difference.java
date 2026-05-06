/*
 * Problem: 3357. Minimize the Maximum Adjacent Element Difference
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimize-the-maximum-adjacent-element-difference/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minDifference(int[] nums) {
        int prv = nums[0];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int lim2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == -1) {
                if (prv > 0) {
                    max = Math.max(prv, max);
                    min = Math.min(prv, min);
                }
            } else if (prv == -1) {
                max = Math.max(nums[i], max);
                min = Math.min(nums[i], min);
            } else {
                lim2 = Math.max(Math.abs(nums[i] - prv), lim2);
            }
            prv = nums[i];
        }
        if (max == Integer.MIN_VALUE)
            return lim2;
        int res = 2 * lim2;
        int lim3 = (max - min + 2) / 3 * 2;
        int idx = 0;
        while (idx < nums.length) {
            if (nums[idx] == -1) {
                int l = idx;
                while (l >= 0 && nums[l] == -1) {
                    l--;
                }
                int r = idx;
                while (r < nums.length && nums[r] == -1) {
                    r++;
                }
                int a = 0;
                int b = 0;
                if (l == -1) {
                    a = b = nums[r];
                } else if (r == nums.length) {
                    a = b = nums[l];
                } else {
                    a = Math.min(nums[l], nums[r]);
                    b = Math.max(nums[l], nums[r]);
                }
                if (l + 2 == r) {
                    res = Math.max(Math.min(b - min, max - a), res);
                } else {
                    res = Math.max(Math.min(Math.min(b - min, max - a), lim3), res);
                }
                idx = r + 1;
            } else {
                idx++;
            }
        }
        return (res + 1) / 2;
    }
}
