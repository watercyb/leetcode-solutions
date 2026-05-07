/*
 * Problem: 3403. Find the Lexicographically Largest String From the Box I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1)
            return word;
        char[] chrs = word.toCharArray();
        int i = 0;
        int j = 1;
        int len = 0;
        while (j + len < chrs.length) {
            if (chrs[i + len] < chrs[j + len]) {
                int temp = i;
                i = j;
                j = Math.max(j + 1, temp + len);
                len = 0;
            } else if (chrs[i + len] > chrs[j + len]) {
                j += len + 1;
                len = 0;
            } else {
                len++;
            }
        }
        int max = word.length() - numFriends + 1;
        return word.substring(i, Math.min(i + max, word.length()));
    }
}
