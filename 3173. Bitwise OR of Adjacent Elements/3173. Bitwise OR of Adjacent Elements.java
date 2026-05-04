/*
 * Problem: 3173. Bitwise OR of Adjacent Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/bitwise-or-of-adjacent-elements/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int[] orArray(int[] nums) {
        int[] res = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            res[i - 1] = nums[i - 1] | nums[i];
        }
        return res;
    }
}
