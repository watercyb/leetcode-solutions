/*
 * Problem: 2999. Count the Number of Powerful Integers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-the-number-of-powerful-integers/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        char[] chrsSuf = s.toCharArray();
        char[] chrsFin = String.valueOf(finish).toCharArray();
        long numS = Long.valueOf(s);
        if (chrsSuf.length == chrsFin.length) {
            if (numS >= start && numS <= finish)
                return 1;
            return 0;
        }
        char[] chrsSta = new char[chrsFin.length];
        Arrays.fill(chrsSta, '0');
        long num = start;
        for (int i = chrsSta.length - 1; num > 0; i--) {
            chrsSta[i] = (char) (num % 10 + '0');
            num /= 10;
        }
        boolean l = true;
        boolean r = true;
        boolean isSame = true;
        long res = 0;
        int len = chrsFin.length - chrsSuf.length;
        for (int i = 0; i < len; i++) {
            if (isSame) {
                if (chrsSta[i] != chrsFin[i]) {
                    res = Math.max(Math.min(chrsFin[i] - '1', limit) - chrsSta[i] + '0', 0);
                    isSame = false;
                }
            } else {
                res *= limit + 1;
                if (l)
                    res += Math.max(limit - chrsSta[i] + '0', 0);
                if (r)
                    res += Math.min(chrsFin[i] - '1', limit) + 1;
            }
            if (chrsSta[i] - '0' > limit)
                l = false;
            if (chrsFin[i] - '0' > limit)
                r = false;
        }
        if (isSame) {
            if (l && numS >= getNum(chrsSta, len) && numS <= getNum(chrsFin, len))
                res++;
        } else {
            if (l && numS >= getNum(chrsSta, len))
                res++;
            if (r && numS <= getNum(chrsFin, len))
                res++;
        }
        return res;
    }

    public long getNum(char[] arr, int i) {
        long res = 0;
        while (i < arr.length) {
            res = res * 10 + arr[i] - '0';
            i++;
        }
        return res;
    }
}
