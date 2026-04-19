/*
 * Problem: 1663. Smallest String With A Given Numeric Value
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public String getSmallestString(int n, int k) {
        int a = (k - n) / 25;
        int b = (k - n) % 25;
        char[] chrs = new char[n];
        for (int i = 0; i < n - a - 1; i++) {
            chrs[i] = 'a';
        }
        if (n - a - 1 >= 0)
            chrs[n - a - 1] = (char) (b + 'a');
        for (int i = n - a; i < n; i++) {
            chrs[i] = 'z';
        }
        return new String(chrs);
    }
}
