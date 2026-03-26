/*
 * Problem: 166. Fraction to Recurring Decimal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/fraction-to-recurring-decimal/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder res = new StringBuilder();
        long n = numerator;
        long d = denominator;
        if (n / Math.abs(n) * d / Math.abs(d) < 0)
            res.append('-');
        n = Math.abs(n);
        d = Math.abs(d);
        HashMap<Long, Integer> HM = new HashMap<>();
        res.append(n / d);
        n %= d;
        if (n == 0)
            return res.toString();
        res.append('.');
        int i = res.length();
        while (n != 0) {
            n *= 10;
            if (HM.containsKey(n)) {
                res.insert(HM.get(n), "(");
                res.append(')');
                return res.toString();
            } else {
                HM.put(n, i);
            }
            res.append(n / d);
            n %= d;
            i++;
        }
        return res.toString();
    }
}
