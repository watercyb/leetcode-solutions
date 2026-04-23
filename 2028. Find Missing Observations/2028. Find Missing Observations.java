/*
 * Problem: 2028. Find Missing Observations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-missing-observations/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = mean * (rolls.length + n);
        for (int roll : rolls) {
            sum -= roll;
        }
        if (sum < n || sum > 6 * n)
            return new int[0];
        int[] res = new int[n];
        int a = sum / n;
        int b = sum % n;
        for (int i = 0; i < b; i++) {
            res[i] = a + 1;
        }
        for (int i = b; i < n; i++) {
            res[i] = a;
        }
        return res;
    }
}
