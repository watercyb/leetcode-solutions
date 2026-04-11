/*
 * Problem: 1018. Binary Prefix Divisible By 5
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-prefix-divisible-by-5/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int digit = 0;
        List<Boolean> res = new ArrayList<>();
        for (int num : nums) {
            digit = (digit * 2 + num) % 5;
            res.add(digit == 0);
        }
        return res;
    }
}
