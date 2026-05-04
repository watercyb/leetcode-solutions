/*
 * Problem: 3170. Lexicographically Minimum String After Removing Stars
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public String clearStars(String s) {
        char[] chrs = s.toCharArray();
        Deque<Integer>[] Dqs = new ArrayDeque[26];
        for (int i = 0; i < 26; i++) {
            Dqs[i] = new ArrayDeque<>();
        }
        int min = 26;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '*') {
                while (Dqs[min].isEmpty()) {
                    min++;
                }
                int idx = Dqs[min].pollLast();
                chrs[idx] = '*';
            } else {
                int idx = chrs[i] - 'a';
                if (idx < min)
                    min = idx;
                Dqs[idx].offerLast(i);
            }
        }
        StringBuilder SB = new StringBuilder();
        for (char chr : chrs) {
            if (chr != '*')
                SB.append(chr);
        }
        return SB.toString();
    }
}
