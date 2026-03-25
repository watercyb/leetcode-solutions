/*
 * Problem: 6. Zigzag Conversion
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/zigzag-conversion/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int l = s.length();
        int n = 2 * numRows - 2;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < l; i += n) {
            res.append(s.charAt(i));
        }
        for (int i = 1; i < numRows - 1; i++) {
            int tmp = n - 2 * i;
            for (int j = i; j < l; j += n) {
                res.append(s.charAt(j));
                if (j + tmp < l)
                    res.append(s.charAt(j + tmp));
            }
        }
        for (int i = numRows - 1; i < l; i += n) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
