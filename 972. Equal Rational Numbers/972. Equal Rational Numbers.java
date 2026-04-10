/*
 * Problem: 972. Equal Rational Numbers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/equal-rational-numbers/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public boolean isRationalEqual(String s, String t) {
        double a = getStr(s);
        double b = getStr(t);
        return Math.abs(a - b) <= 0.0000000001;
    }

    public double getStr(String str) {
        String[] strs = str.split("\\(");
        StringBuilder SB = new StringBuilder(strs[0]);
        if (strs.length > 1) {
            String st = strs[1].substring(0, strs[1].length() - 1);
            for (int i = 0; i <= 10 / st.length(); i++) {
                SB.append(st);
            }
        }
        return Double.valueOf(SB.toString());
    }
}
