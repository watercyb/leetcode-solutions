/*
 * Problem: 537. Complex Number Multiplication
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/complex-number-multiplication/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] str1 = num1.split("\\+");
        String[] str2 = num2.split("\\+");
        int a = Integer.valueOf(str1[0]);
        int b = Integer.valueOf(str1[1].substring(0, str1[1].length() - 1));
        int c = Integer.valueOf(str2[0]);
        int d = Integer.valueOf(str2[1].substring(0, str2[1].length() - 1));
        return new StringBuilder().append(a * c - b * d).append('+').append((a * d + b * c)).append('i').toString();
    }
}
