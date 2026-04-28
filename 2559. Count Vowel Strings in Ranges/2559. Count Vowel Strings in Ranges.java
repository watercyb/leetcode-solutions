/*
 * Problem: 2559. Count Vowel Strings in Ranges
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-vowel-strings-in-ranges/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        boolean[] isVowel = new boolean['z' + 1];
        isVowel['a'] = true;
        isVowel['e'] = true;
        isVowel['i'] = true;
        isVowel['o'] = true;
        isVowel['u'] = true;
        int[] sum = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            sum[i + 1] = sum[i];
            if (isVowel[words[i].charAt(0)] && isVowel[words[i].charAt(words[i].length() - 1)])
                sum[i + 1]++;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = sum[queries[i][1] + 1] - sum[queries[i][0]];
        }
        return res;
    }
}
