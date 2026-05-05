/*
 * Problem: 3289. The Two Sneaky Numbers of Digitville
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        boolean[] seens = new boolean[101];
        int[] res = new int[2];
        int idx = 0;
        for (int num : nums) {
            if (!seens[num]) {
                seens[num] = true;
            } else {
                res[idx++] = num;
                if (idx == 2)
                    break;
            }
        }
        return res;
    }
}
