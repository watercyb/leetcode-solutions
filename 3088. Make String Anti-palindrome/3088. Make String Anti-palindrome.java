/*
 * Problem: 3088. Make String Anti-palindrome
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/make-string-anti-palindrome/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public String makeAntiPalindrome(String s) {
        char[] chrs = s.toCharArray();
        int[] counts = new int['z' + 1];
        for (char chr : chrs) {
            counts[chr]++;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] > chrs.length / 2)
                return "-1";
        }
        int i = 0;
        int j = 0;
        int idx = 0;
        while (idx < chrs.length) {
            while (counts[i] == 0) {
                i++;
            }
            if (j <= i)
                j = i + 1;
            if (idx < chrs.length / 2 || chrs[chrs.length - 1 - idx] != i) {
                chrs[idx++] = (char) i;
                counts[i]--;
            } else {
                while (counts[j] == 0) {
                    j++;
                }
                chrs[idx++] = (char) j;
                counts[j]--;
            }
        }
        return new String(chrs);
    }
}
