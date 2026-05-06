/*
 * Problem: 3307. Find the K-th Character in String Game II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public long countOfSubstrings(String word, int k) {
        char[] chrs = word.toCharArray();
        int[] idx = new int['z' + 1];
        idx['a'] = 1;
        idx['e'] = 2;
        idx['i'] = 3;
        idx['o'] = 4;
        idx['u'] = 5;
        int[] counts = { k, 1, 1, 1, 1, 1 };
        int count = 0;
        long res = 0;
        int j = 0;
        int r = 0;
        for (int i = 0; i < chrs.length; i++) {
            while (j < chrs.length && (counts[0] != 0 || (idx[chrs[j]] > 0 && count < 5))) {
                if (--counts[idx[chrs[j]]] == 0 && idx[chrs[j]] > 0)
                    count++;
                j++;
            }
            if (r < j)
                r = j;
            while (r < chrs.length && idx[chrs[r]] > 0) {
                r++;
            }
            if (count == 5 && counts[0] == 0) {
                res += r - j + 1;
            } else if (j == chrs.length) {
                break;
            }
            if (++counts[idx[chrs[i]]] == 1 && idx[chrs[i]] > 0)
                count--;
        }
        return res;
    }
}
