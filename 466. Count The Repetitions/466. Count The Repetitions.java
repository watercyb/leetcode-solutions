/*
 * Problem: 466. Count The Repetitions
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-the-repetitions/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] chrs1 = s1.toCharArray();
        char[] chrs2 = s2.toCharArray();
        int j = 0;
        int count = 0;
        int res = 0;
        int[] DP = new int[chrs1.length];
        int[] DPIdx = new int[chrs1.length];
        Arrays.fill(DP, -1);
        int len = chrs1.length * n1;
        int lim = Math.min(chrs1.length * chrs2.length + 1, len);
        for (int i = 0; i < lim; i++) {
            int idx = i % chrs1.length;
            if (chrs1[idx] == chrs2[j]) {
                if (j == 0) {
                    count++;
                    if (DP[idx] != -1) {
                        int n = count - DP[idx];
                        int c = i - DPIdx[idx];
                        int r = len - i;
                        res += r / c * n;
                        i = len - r % c;
                        while (i < len) {
                            if (chrs1[i % chrs1.length] == chrs2[j]) {
                                if (++j == chrs2.length) {
                                    res++;
                                    j = 0;
                                }
                            }
                            i++;
                        }
                        return res / n2;
                    } else {
                        DP[idx] = count;
                        DPIdx[idx] = i;
                    }
                }
                if (++j == chrs2.length) {
                    res++;
                    j = 0;
                }
            }
        }
        return res / n2;
    }
}
