/*
 * Problem: 1759. Count Number of Homogenous Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-number-of-homogenous-substrings/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int countHomogenous(String s) {
        int mod = 1000000007;
        long res = 0;
        char prv = '#';
        int count = 0;
        for (char chr:s.toCharArray()) {
            if (chr== prv) {
                count++;
            } else {
                prv = chr;
                count = 1;
            }
            res = res + count;
        }
        return (int) (res % mod);
    }
}
