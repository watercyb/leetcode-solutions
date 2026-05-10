/*
 * Problem: 3775. Reverse Words With Same Vowel Count
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reverse-words-with-same-vowel-count/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public String reverseWords(String s) {
        isVowels['a'] = isVowels['e'] = isVowels['i'] = isVowels['o'] = isVowels['u'] = true;
        String[] strs = s.split(" ");
        int count = countVowels(strs[0]);
        StringBuilder SB = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            SB.append(' ');
            if (countVowels(strs[i]) == count) {
                SB.append(new StringBuilder(strs[i]).reverse().toString());
            } else {
                SB.append(strs[i]);
            }
        }
        return SB.toString();
    }

    boolean[] isVowels = new boolean['z' + 1];

    public int countVowels(String str) {
        int res = 0;
        for (char chr : str.toCharArray()) {
            if (isVowels[chr])
                res++;
        }
        return res;
    }
}
