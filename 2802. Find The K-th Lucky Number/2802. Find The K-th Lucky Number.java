/*
 * Problem: 2802. Find The K-th Lucky Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-k-th-lucky-number/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public String kthLuckyNumber(int k) {
        int n = 0;
        while (k >= (1 << n)) {
            k -= 1 << n;
            n++;
        }
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if ((k & 1) == 1) {
                SB.append('7');
            } else {
                SB.append('4');
            }
            k >>= 1;
        }
        return SB.reverse().toString();
    }
}
