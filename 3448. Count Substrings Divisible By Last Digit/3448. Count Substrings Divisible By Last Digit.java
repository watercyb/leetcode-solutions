/*
 * Problem: 3448. Count Substrings Divisible By Last Digit
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-substrings-divisible-by-last-digit/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long countSubstrings(String s) {
        char[] chrs = s.toCharArray();
        int[] countMod3 = new int[3];
        int mod3 = 0;
        countMod3[0] = 1;
        int[] countMod9 = new int[9];
        int mod9 = 0;
        countMod9[0] = 1;
        int[] countMod7 = new int[7];
        int[] countMod7Next = new int[7];
        int[] idx7 = { 0, 3, 6, 2, 5, 1, 4 };
        int mod7 = 0;
        countMod7[0] = 1;
        int mod8 = 0;
        long res = 0;
        for (int i = 0; i < chrs.length; i++) {
            int digit = chrs[i] - '0';
            mod3 = (mod3 + digit) % 3;
            mod9 = (mod9 + digit) % 9;
            mod7 = (mod7 * 10 + digit) % 7;
            mod8 = (mod8 * 10 + digit) % 8;
            switch (digit) {
                case 1:
                case 2:
                case 5:
                    res += i + 1;
                    break;
                case 4:
                    if (i > 0 && (chrs[i - 1] - '0') % 2 == 1) {
                        res++;
                    } else {
                        res += i + 1;
                    }
                    break;
                case 3:
                case 6:
                    res += countMod3[mod3];
                    break;
                case 7:
                    res += countMod7[mod7];
                    break;
                case 8:
                    if (i == 0) {
                        res++;
                    } else {
                        if (mod8 == 0) {
                            res += i;
                        } else {
                            res++;
                        }
                        if (((chrs[i - 1] - '0') * 10) % digit == 0)
                            res++;
                    }
                    break;
                case 9:
                    res += countMod9[mod9];
                    break;
            }
            countMod3[mod3]++;
            countMod9[mod9]++;
            countMod7[mod7]++;
            for (int j = 0; j < 7; j++) {
                countMod7Next[idx7[j]] = countMod7[j];
            }
            int[] temp = countMod7;
            countMod7 = countMod7Next;
            countMod7Next = temp;
        }
        return res;
    }
}
