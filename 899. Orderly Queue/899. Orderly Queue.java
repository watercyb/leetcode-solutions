/*
 * Problem: 899. Orderly Queue
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/orderly-queue/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            int[] counts = new int['z' + 1];
            for (char chr : s.toCharArray()) {
                counts[chr]++;
            }
            StringBuilder SB = new StringBuilder();
            for (char chr = 'a'; chr <= 'z'; chr++) {
                for (int i = 0; i < counts[chr]; i++) {
                    SB.append(chr);
                }
            }
            return SB.toString();
        } else {
            char[] chrs = s.toCharArray();
            int idx = 0;
            for (int i = 1; i < chrs.length; i++) {
                for (int j = 0; j < chrs.length; j++) {
                    int idx1 = (idx + j) % chrs.length;
                    int idx2 = (i + j) % chrs.length;
                    if (chrs[idx1] < chrs[idx2])
                        break;
                    if (chrs[idx1] > chrs[idx2]) {
                        idx = i;
                        break;
                    }
                }
            }
            StringBuilder SB = new StringBuilder();
            for (int i = idx; i < idx + chrs.length; i++) {
                SB.append(chrs[i % chrs.length]);
            }
            return SB.toString();
        }
    }
}
