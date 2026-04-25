/*
 * Problem: 2269. Find the K-Beauty of a Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-k-beauty-of-a-number/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int divisorSubstrings(int num, int k) {
        char[] chrs = String.valueOf(num).toCharArray();
        int res = 0;
        for (int i = 0; i <= chrs.length - k; i++) {
            int n = 0;
            for (int j = i; j < i + k; j++) {
                n = n * 10 + chrs[j] - '0';
            }
            if (n != 0 && num % n == 0)
                res++;
        }
        return res;
    }
}
