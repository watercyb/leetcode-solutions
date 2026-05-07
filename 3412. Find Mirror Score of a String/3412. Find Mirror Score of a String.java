/*
 * Problem: 3412. Find Mirror Score of a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-mirror-score-of-a-string/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long calculateScore(String s) {
        Deque<Integer>[] Dq = new ArrayDeque[26];
        for (int i = 0; i < 26; i++) {
            Dq[i] = new ArrayDeque<>();
        }
        char[] chrs = s.toCharArray();
        long res = 0;
        for (int i = 0; i < chrs.length; i++) {
            int idx = 25 - (chrs[i] - 'a');
            if (!Dq[idx].isEmpty()) {
                res += i - Dq[idx].pollLast();
            } else {
                Dq[chrs[i] - 'a'].offerLast(i);
            }
        }
        return res;
    }
}
