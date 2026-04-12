/*
 * Problem: 1067. Digit Count in Range
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/digit-count-in-range/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int digitsCount(int d, int low, int high) {
        return getNum(d, high) - getNum(d, low - 1);
    }

    public int getNum(int d, int n) {
        char[] chrs = String.valueOf(n).toCharArray();
        int base = (int) Math.pow(10, chrs.length - 1);
        int res = 0;
        int count = 0;
        int countLim = 0;
        for (int i = 0; i < chrs.length; i++) {
            int num = chrs[i] - '0';
            res += count * base;
            count *= 10;
            if (i > 0) {
                count += 9;
                if (d != 0)
                    res += base;
            }
            if (i == 0) {
                count += num - 1;
                if (num > d && d != 0)
                    res += base;
            } else {
                count += num;
                if (num > d)
                    res += base;
                res += countLim * num * base;
            }
            if (num == d)
                countLim++;
            base /= 10;
        }
        if (d == 0 && chrs.length > 1)
            res++;
        return res + countLim;
    }
}
