/*
 * Problem: 2785. Sort Vowels in a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sort-vowels-in-a-string/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public String sortVowels(String s) {
        char[] chrs = s.toCharArray();
        boolean[] IsVowel = new boolean['z' + 1];
        char[] vowels = { 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u' };
        for (char vowel : vowels) {
            IsVowel[vowel] = true;
        }
        int[] counts = new int['u' + 1];
        for (int i = 0; i < chrs.length; i++) {
            if (IsVowel[chrs[i]])
                counts[chrs[i]]++;
        }
        int idx = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (IsVowel[chrs[i]]) {
                while (counts[vowels[idx]]==0) idx++;
                chrs[i]=vowels[idx];
                counts[vowels[idx]]--;
            }
        }
        return new String(chrs);
    }
}
