/*
 * Problem: 1362. Closest Divisors
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/closest-divisors/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int[] closestDivisors(int num) {
        for (int i = (int) Math.sqrt(num + 2); i >= 2; i--) {
            if ((num + 1) / i * i == num + 1)
                return new int[] { i, (num + 1) / i };
            if ((num + 2) / i * i == num + 2)
                return new int[] { i, (num + 2) / i };
        }
        return new int[] { 1, num + 1 };
    }
}
