/*
 * Problem: 3138. Minimum Length of Anagram Concatenation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-length-of-anagram-concatenation/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minAnagramLength(String s) {
        char[] chrs = s.toCharArray();
        int[] counts = new int['z' + 1];
        for (char chr : chrs) {
            counts[chr]++;
        }
        int[] checked = new int[chrs.length + 1];
        int count = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] == 0)
                continue;
            for (int j = 1; j <= counts[i]; j++) {
                if (counts[i] % j == 0)
                    checked[counts[i] / j]++;
            }
            count++;
        }
        for (int i = chrs.length; i >= 1; i--) {
            if (checked[i] == count && chk(chrs, chrs.length / i)) {
                return chrs.length / i;
            }
        }
        return -1;
    }

    public boolean chk(char[] chrs, int i) {
        int[] targets = new int['z' + 1];
        for (int j = 0; j < i; j++) {
            targets[chrs[j]]++;
        }
        for (int j = i; j < chrs.length; j += i) {
            int[] counts = new int['z' + 1];
            for (int k = j; k < j + i; k++) {
                if (++counts[chrs[k]] > targets[chrs[k]])
                    return false;
            }
        }
        return true;
    }
}
