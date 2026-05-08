/*
 * Problem: 3556. Sum of Largest Prime Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-largest-prime-substrings/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long sumOfLargestPrimes(String s) {
        long a = 0;
        long b = 0;
        long c = 0;
        char[] chrs = s.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            long sum = 0;
            for (int j = i; j < chrs.length; j++) {
                sum = sum * 10 + chrs[j] - '0';
                if (sum == a || sum == b || sum == c || sum < c)
                    continue;
                if (chk(sum)) {
                    if (sum > a) {
                        c = b;
                        b = a;
                        a = sum;
                    } else if (sum > b) {
                        c = b;
                        b = sum;
                    } else if (sum > c) {
                        c = sum;
                    }
                }
            }
        }
        return a + b + c;
    }

    public boolean chk(long a) {
        if (a == 1)
            return false;
        int lim = (int) Math.sqrt(a);
        for (int i = 2; i <= lim; i++) {
            if (a % i == 0)
                return false;
        }
        return true;
    }
}
