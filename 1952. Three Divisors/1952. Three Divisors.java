/*
 * Problem: 1952. Three Divisors
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/three-divisors/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public boolean isThree(int n) {
        int count = 1;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                if (++count == 3)
                    return false;
            }
        }
        return count == 2;
    }
}
