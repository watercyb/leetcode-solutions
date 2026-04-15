/*
 * Problem: 1255. Maximum Score Words Formed by Letters
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-score-words-formed-by-letters/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] counts = new int[26];
        for (char letter : letters) {
            counts[letter - 'a']++;
        }
        char[][] chrs = new char[words.length][];
        int[] scores = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            char[] tmp = words[i].toCharArray();
            int j = 0;
            int sum = 0;
            while (j < tmp.length && counts[tmp[j] - 'a'] > 0) {
                tmp[j] -= 'a';
                sum += score[tmp[j]];
                j++;
            }
            if (j == tmp.length) {
                chrs[i] = tmp;
                scores[i] = sum;
            }
        }
        dfs(chrs, counts, scores, 0, 0);
        return res;
    }

    int res = 0;

    public void dfs(char[][] chrs, int[] counts, int[] scores, int i, int sum) {
        if (i == chrs.length) {
            res = Math.max(sum, res);
            return;
        }
        dfs(chrs, counts, scores, i + 1, sum);
        if (chrs[i] != null) {
            int j = 0;
            while (j < chrs[i].length && counts[chrs[i][j]]-- > 0) {
                j++;
            }
            if (j == chrs[i].length) {
                dfs(chrs, counts, scores, i + 1, sum + scores[i]);
                j--;
            }
            for (int k = 0; k <= j; k++) {
                counts[chrs[i][k]]++;
            }
        }
    }
}
