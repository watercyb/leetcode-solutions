/*
 * Problem: 922. Sort Array By Parity II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sort-array-by-parity-ii/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0;
        int j = 1;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num % 2 == 1) {
                res[j] = num;
                j += 2;
            } else {
                res[i] = num;
                i += 2;
            }
        }
        return res;
    }
}
