/*
 * Problem: 3734. Lexicographically Smallest Palindromic Permutation Greater Than Target
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/?envType=daily-question&envId=2026-08-28
 * Language: java
 * Date: 2026-08-28
 */

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        char[] chrsS = s.toCharArray();
        char[] chrsT = target.toCharArray();
        int[] counts = new int[26];
        for (char chr : chrsS) {
            counts[chr - 'a']++;
        }
        int odd = -1;
        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 == 1) {
                if (odd != -1)
                    return "";
                odd = i;
            }
        }
        char[] res = new char[chrsS.length];
        if (odd != -1) {
            res[chrsS.length / 2] = (char) (odd + 'a');
            counts[odd]--;
        }
        int idx = getLongest(chrsS, chrsT, counts, res);
        if (idx == chrsT.length / 2) {
            if (chk(chrsT, res))
                return new String(res);
            idx--;
        }
        while (idx >= 0) {
            if (res[idx] > 0)
                counts[res[idx] - 'a'] += 2;
            for (int i = chrsT[idx] + 1; i <= 'z'; i++) {
                if (counts[i - 'a'] > 0) {
                    counts[i - 'a'] -= 2;
                    res[idx] = res[res.length - 1 - idx] = (char) i;
                    return getRes(counts, res, idx + 1);
                }
            }
            idx--;
        }
        return "";
    }

    public String getRes(int[] counts, char[] res, int i) {
        for (int j = 0; j < 26; j++) {
            while (counts[j] > 0) {
                res[i] = res[res.length - 1 - i] = (char) (j + 'a');
                i++;
                counts[j] -= 2;
            }
        }
        return new String(res);
    }

    public boolean chk(char[] chrsT, char[] res) {
        for (int i = chrsT.length / 2; i < chrsT.length; i++) {
            if (chrsT[i] < res[i]) {
                return true;
            } else if (chrsT[i] > res[i]) {
                return false;
            }
        }
        return false;
    }

    public int getLongest(char[] chrsS, char[] chrsT, int[] counts, char[] res) {
        for (int i = 0; i < chrsT.length / 2; i++) {
            int idx = chrsT[i] - 'a';
            if (counts[idx] > 0) {
                res[i] = res[res.length - 1 - i] = (char) (idx + 'a');
                counts[idx] -= 2;
            } else {
                return i;
            }
        }
        return chrsT.length / 2;
    }
}
