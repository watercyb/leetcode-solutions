/*
 * Problem: 1250. Check If It Is a Good Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/check-if-it-is-a-good-array/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public boolean isGoodArray(int[] nums) {
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a = GCD(nums[i], a);
        }
        return a == 1;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
