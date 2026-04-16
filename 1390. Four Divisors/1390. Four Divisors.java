/*
 * Problem: 1390. Four Divisors
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/four-divisors/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += count(num);
        }
        return res;
    }

    public int count(int num) {
        int count = 0;
        int res = 0;
        int lim = (int) Math.sqrt(num);
        if (lim * lim == num) {
            count--;
            res -= lim;
        }
        for (int i = 1; i <= lim; i++) {
            if (num % i == 0) {
                count += 2;
                if (count > 4)
                    return 0;
                res += i + num / i;
            }
        }
        if (count == 4)
            return res;
        return 0;
    }
}
