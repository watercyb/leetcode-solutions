/*
 * Problem: 843. Guess the Word
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/guess-the-word/
 * Language: java
 * Date: 2026-04-09
 */

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 * public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        List<char[]> Li = new ArrayList<>();
        List<Integer> guess = new ArrayList<>();
        Li.add(words[0].toCharArray());
        guess.add(master.guess(words[0]));
        for (int i = words.length - 1; i > 0; i--) {
            char[] chrs = words[i].toCharArray();
            int j = 0;
            while (j < Li.size()) {
                if (chk(Li.get(j), chrs) != guess.get(j))
                    break;
                j++;
            }
            if (j == Li.size()) {
                int tmp = master.guess(words[i]);
                if (tmp == 6)
                    return;
                Li.add(chrs);
                guess.add(tmp);
            }
        }
    }

    public int chk(char[] chrs1, char[] chrs2) {
        int res = 0;
        for (int i = 0; i < chrs1.length; i++) {
            if (chrs1[i] == chrs2[i])
                res++;
        }
        return res;
    }
}
