/*
 * Problem: 2 Keys Keyboard
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/2-keys-keyboard/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }
}
