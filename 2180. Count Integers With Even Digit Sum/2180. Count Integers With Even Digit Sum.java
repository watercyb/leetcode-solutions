/*
 * Problem: 2180. Count Integers With Even Digit Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-integers-with-even-digit-sum/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0;
            int n = i;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            if ((sum & 1) == 0)
                res++;
        }
        return res;
    }
}
