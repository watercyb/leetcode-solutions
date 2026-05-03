/*
 * Problem: 3048. Earliest Second to Mark Indices I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/earliest-second-to-mark-indices-i/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int l = 0;
        int r = changeIndices.length - 1;
        if (!chk(nums, changeIndices, r))
            return -1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(nums, changeIndices, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l + 1;
    }

    public boolean chk(int[] nums, int[] changeIndices, int mid) {
        int total = mid + 1;
        boolean[] seens = new boolean[nums.length];
        int count = nums.length;
        for (int i = mid; i >= 0 && total > 0; i--) {
            int idx = changeIndices[i] - 1;
            if (seens[idx])
                continue;
            total = Math.min(total - nums[idx] - 1, i - nums[idx]);
            seens[idx] = true;
            count--;
        }
        return (count == 0 && total >= 0);
    }
}
