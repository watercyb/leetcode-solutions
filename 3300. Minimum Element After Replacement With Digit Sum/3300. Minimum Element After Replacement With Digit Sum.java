/*
 * Problem: 3300. Minimum Element After Replacement With Digit Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.min(getSum(nums[i]), res);
        }
        return res;
    }

    public int getSum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
