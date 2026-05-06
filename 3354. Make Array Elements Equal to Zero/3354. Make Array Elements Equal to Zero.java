/*
 * Problem: 3354. Make Array Elements Equal to Zero
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/make-array-elements-equal-to-zero/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int countValidSelections(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (sum * 2 == total) {
                    res += 2;
                } else if (Math.abs(sum * 2 - total) == 1) {
                    res++;
                }
            }
            sum += nums[i];
        }
        return res;
    }
}
