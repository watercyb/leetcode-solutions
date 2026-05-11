/*
 * Problem: 3827. Count Monobit Integers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-monobit-integers/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int countMonobit(int n) {
        int res = 0;
        int num = 0;
        while (num <= n) {
            res++;
            num = (num << 1) + 1;
        }
        return res;
    }
}
