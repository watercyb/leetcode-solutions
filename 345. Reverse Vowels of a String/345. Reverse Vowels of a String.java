/*
 * Problem: 345. Reverse Vowels of a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-vowels-of-a-string/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String reverseVowels(String s) {
        boolean[] isVowels = new boolean['z' + 1];
        isVowels['a'] = true;
        isVowels['e'] = true;
        isVowels['i'] = true;
        isVowels['o'] = true;
        isVowels['u'] = true;
        isVowels['A'] = true;
        isVowels['E'] = true;
        isVowels['I'] = true;
        isVowels['O'] = true;
        isVowels['U'] = true;
        char[] chrs = s.toCharArray();
        int l = 0;
        int r = chrs.length - 1;
        while (l < r) {
            while (l < r && !isVowels[chrs[l]]) {
                l++;
            }
            while (r > l && !isVowels[chrs[r]]) {
                r--;
            }
            char tmp = chrs[l];
            chrs[l] = chrs[r];
            chrs[r] = tmp;
            l++;
            r--;
        }
        return new String(chrs);
    }
}
