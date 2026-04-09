/*
 * Problem: 880. Decoded String at Index
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/decoded-string-at-index/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public String decodeAtIndex(String s, int k) {
        long sum = 0;
        k--;
        int i = 0;
        int l = s.length();
        while (sum <= k) {
            while (i < l && !Character.isDigit(s.charAt(i))) {
                sum++;
                i++;
            }
            while (i < l && Character.isDigit(s.charAt(i))) {
                sum *= (s.charAt(i) - '0');
                i++;
            }
        }
        i--;
        while (sum > k) {
            while (i >= 0 && Character.isDigit(s.charAt(i))) {
                sum /= (s.charAt(i) - '0');
                i--;
            }
            k %= sum;
            while (i >= 0 && !Character.isDigit(s.charAt(i))) {
                if (sum == k+1)
                    return s.substring(i, i + 1);
                i--;
                sum--;
            }
        }
        return "";
    }
}
