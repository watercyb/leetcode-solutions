/*
 * Problem: 829. Consecutive Numbers Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/consecutive-numbers-sum/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int consecutiveNumbersSum(int n) {
        int res = 0;
        int l = (int) Math.sqrt(2 * n);
        for (int i = 1; i <= l; i++) {
            int tmp = n % i;
            if (i % 2 == 1) {
                if (tmp == 0)
                    res++;
            } else {
                if (tmp * 2 == i)
                    res++;
            }

        }
        return res;
    }
}
