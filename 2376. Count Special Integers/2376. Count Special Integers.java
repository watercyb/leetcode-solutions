/*
 * Problem: 2376. Count Special Integers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-special-integers/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int countSpecialNumbers(int n) {
        char[] chrs = String.valueOf(n).toCharArray();
        boolean[] seens = new boolean[10];
        int res = 0;
        boolean isDist = true;
        for (int i = 0; i < chrs.length; i++) {
            if (i > 0) {
                res += count(chrs.length - i);
            }
            if (isDist) {
                int sum = 0;
                for (int j = chrs[i] - '0' - 1; j > 0; j--) {
                    if (!seens[j])
                        sum++;
                }
                if (i > 0 && chrs[i] - '0' > 0 && !seens[0])
                    sum++;
                res += sum * count(chrs.length - i - 1, 10 - i - 1);
                if (seens[chrs[i] - '0']) {
                    isDist = false;
                } else {
                    seens[chrs[i] - '0'] = true;
                }
            }
        }
        if (isDist)
            res++;
        if (chrs.length == 1)
            res++;
        return res - 1;
    }

    public int count(int l, int n) {
        if (l == 0)
            return 1;
        if (l == 1)
            return n;
        int res = n;
        int count = n - 1;
        for (int i = 1; i < l; i++) {
            res *= count;
            count--;
        }
        return res;
    }

    public int count(int l) {
        if (l == 0)
            return 0;
        if (l == 1)
            return 10;
        int res = 9;
        int count = 9;
        for (int i = 1; i < l; i++) {
            res *= count;
            count--;
        }
        return res;
    }
}
