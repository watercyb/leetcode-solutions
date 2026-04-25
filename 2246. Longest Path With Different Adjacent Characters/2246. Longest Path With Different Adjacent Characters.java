/*
 * Problem: 2246. Longest Path With Different Adjacent Characters
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int longestPath(int[] parent, String s) {
        char[] chrs = s.toCharArray();
        int[] counts = new int[parent.length];
        int[] lengthes = new int[parent.length];
        for (int i = 1; i < parent.length; i++) {
            counts[parent[i]]++;
        }
        int[] Qu = new int[parent.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < parent.length; i++) {
            if (counts[i] == 0) {
                lengthes[i]++;
                Qu[r++] = i;
            }
        }
        int res = 0;
        while (l < r) {
            int current = Qu[l++];
            int next = parent[current];
            if (next == -1) {
                res = Math.max(lengthes[0], res);
                break;
            }
            if (chrs[next] != chrs[current]) {
                res = Math.max(lengthes[next] + lengthes[current] + 1, res);
                lengthes[next] = Math.max(lengthes[current], lengthes[next]);
            }
            if (counts[next]-- == 1) {
                lengthes[next]++;
                Qu[r++] = next;
            }
        }
        return res;
    }
}
