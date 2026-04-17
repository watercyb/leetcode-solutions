/*
 * Problem: 1405. Longest Happy String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-happy-string/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        char[] chrs = new char[3];
        int[] counts = new int[3];
        for (int i = 0; i < 3; i++) {
            if (a >= b && a >= c) {
                chrs[i] = 'a';
                counts[i] = a;
                a = -a;
            } else if (b >= a && b >= c) {
                chrs[i] = 'b';
                counts[i] = b;
                b = -b;
            } else if (c >= a && c >= b) {
                chrs[i] = 'c';
                counts[i] = c;
                c = -c;
            }
        }
        if (counts[0] <= counts[1] + counts[2] + 1) {
            char[] res = new char[counts[0] + counts[1] + counts[2]];
            int idx = 0;
            while (counts[0] > 0) {
                res[idx] = chrs[0];
                counts[0]--;
                idx += 2;
            }
            while (counts[1] > 0) {
                if (idx >= res.length)
                    idx = 1;
                res[idx] = chrs[1];
                counts[1]--;
                idx += 2;
            }
            while (counts[2] > 0) {
                res[idx] = chrs[2];
                counts[2]--;
                idx += 2;
            }
            return new String(res);
        } else {
            if (counts[0] > 2 * (counts[1] + counts[2] + 1))
                counts[0] = 2 * (counts[1] + counts[2] + 1);
            char[] res = new char[2 * (counts[1] + counts[2]) + 1];
            int idx = 0;
            for (int i = counts[0] - counts[1] - counts[2] - 1; i > 0; i--) {
                res[idx] = '#';
                counts[0] -= 2;
                idx += 2;
            }
            while (counts[0] > 0) {
                res[idx] = chrs[0];
                counts[0]--;
                idx += 2;
            }
            while (counts[1] > 0) {
                if (idx >= res.length)
                    idx = 1;
                res[idx] = chrs[1];
                counts[1]--;
                idx += 2;
            }
            while (counts[2] > 0) {
                res[idx] = chrs[2];
                counts[2]--;
                idx += 2;
            }
            return new String(res).replace("#", new StringBuilder().append(chrs[0]).append(chrs[0]).toString());
        }
    }
}
