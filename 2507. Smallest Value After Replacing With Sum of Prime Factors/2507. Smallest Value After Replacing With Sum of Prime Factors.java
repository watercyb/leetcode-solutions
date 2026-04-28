/*
 * Problem: 2507. Smallest Value After Replacing With Sum of Prime Factors
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int smallestValue(int n) {
        if (n == 4)
            return 4;
        while (true) {
            int sum = 0;
            int currentN = n;
            for (int i = 2; i * i <= n; i++) {
                while (n % i == 0) {
                    sum += i;
                    n /= i;
                }
            }
            if (n > 1)
                sum += n;
            if (sum == currentN)
                return currentN;
            n = sum;
        }
    }
}
