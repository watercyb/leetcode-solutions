/*
 * Problem: 902. Numbers At Most N Given Digit Set
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/numbers-at-most-n-given-digit-set/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        char[] chrs = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        int res = 0;
        int prv = 1;
        for (int i = chrs.length - 1; i >= 0; i--) {
            int j = 0;
            while (j < digits.length && digits[j].charAt(0) <= chrs[i]) {
                j++;
            }
            if (j == 0) {
                prv = 0;
            } else {
                if (digits[j - 1].charAt(0) == chrs[i]) {
                    prv += (j - 1) * (int) Math.pow(digits.length, chrs.length - 1 - i);
                } else {
                    prv = (j) * (int) Math.pow(digits.length, chrs.length - 1 - i);
                }
            }
            if (i > 0)
                res += (int) Math.pow(digits.length, chrs.length - i);
        }
        return res + prv;
    }
}
