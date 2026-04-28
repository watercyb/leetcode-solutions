/*
 * Problem: 2553. Separate the Digits in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/separate-the-digits-in-an-array/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int[] separateDigits(int[] nums) {
        int count = 0;
        for (int num : nums) {
            count += Math.log10(num) + 1;
        }
        int[] res = new int[count];
        int idx = count - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (nums[i] > 0) {
                res[idx--] = nums[i] % 10;
                nums[i] /= 10;
            }
        }
        return res;
    }
}
