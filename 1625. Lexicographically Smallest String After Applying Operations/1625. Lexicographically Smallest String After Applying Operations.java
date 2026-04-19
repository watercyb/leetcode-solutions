/*
 * Problem: 1625. Lexicographically Smallest String After Applying Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        if (b % 2 == 1)
            return findLexSmallestString1(s, a, b);
        char[] chrs = s.toCharArray();
        res = chrs.clone();
        int j = 0;
        while (true) {
            char chr = chrs[(j + 1) % chrs.length];
            while (true) {
                chk(chrs, j);
                next(chrs, j, a);
                if (chrs[(j + 1) % chrs.length] == chr)
                    break;
            }
            j = (j + b) % chrs.length;
            if (j == 0)
                break;
        }
        return new String(res);
    }

    public String findLexSmallestString1(String s, int a, int b) {
        char[] chrs = s.toCharArray();
        res = chrs.clone();
        int j = 0;
        while (true) {
            char chr = chrs[(j + 1) % chrs.length];
            while (true) {
                char chr1 = chrs[j];
                while (true) {
                    chk(chrs, j);
                    next1(chrs, j, a);
                    if (chrs[j] == chr1)
                        break;
                }
                next(chrs, j, a);
                if (chrs[(j + 1) % chrs.length] == chr)
                    break;
            }
            j = (j + b) % chrs.length;
            if (j == 0)
                break;
        }
        return new String(res);
    }

    char[] res;

    public void next(char[] chrs, int j, int a) {
        for (int i = (j + 1) % 2; i < chrs.length; i += 2) {
            chrs[i] = (char) ((chrs[i] - '0' + a) % 10 + '0');
        }
    }

    public void next1(char[] chrs, int j, int a) {
        for (int i = j % 2; i < chrs.length; i += 2) {
            chrs[i] = (char) ((chrs[i] - '0' + a) % 10 + '0');
        }
    }

    public void chk(char[] chrs, int j) {
        for (int i = 0; i < chrs.length; i++) {
            if (res[i] > chrs[(i + j) % chrs.length]) {
                for (int k = 0; k < res.length; k++) {
                    res[k] = chrs[(k + j) % chrs.length];
                }
                break;
            } else if (res[i] < chrs[(i + j) % chrs.length]) {
                break;
            }
        }
    }
}
