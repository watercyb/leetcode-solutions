/*
 * Problem: 3474. Lexicographically Smallest Generated String
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/lexicographically-smallest-generated-string/?envType=daily-question&envId=2026-03-31
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public String generateString(String str1, String str2) {
        char[] chrs1 = str1.toCharArray();
        char[] chrs2 = str2.toCharArray();
        char[] res = new char[chrs1.length + chrs2.length - 1];
        Arrays.fill(res, 'a');
        boolean[] fixed = new boolean[res.length];
        int len = chrs2.length;
        for (int i = 0; i < chrs1.length; i++) {
            if (chrs1[i] == 'T')
                len = 0;
            if (len < chrs2.length) {
                res[i] = chrs2[len++];
                fixed[i] = true;
            }
        }
        for (int i = chrs1.length; i < res.length && len < chrs2.length; i++) {
            res[i] = chrs2[len++];
        }
        int[] LPS = getLPS(chrs2);
        int[] lens = new int[res.length];
        int idx = 0;
        len = 0;
        while (idx < res.length) {
            if (res[idx] == chrs2[len]) {
                len++;
                if (len == chrs2.length) {
                    if (idx >= chrs2.length - 1 && chrs1[idx - chrs2.length + 1] == 'F') {
                        boolean changed = false;
                        for (int j = idx; j >= idx - chrs2.length + 1; j--) {
                            if (fixed[j])
                                continue;
                            if (chrs2.length == 1 || j < chrs2.length - 1
                                    || j > 0) {
                                res[j] = 'b';
                                fixed[j] = true;
                                changed = true;
                                if (chrs2.length == 1) {
                                    len = 0;
                                } else {
                                    len = lens[j - 1];
                                }
                                idx = j;
                                break;
                            }
                        }
                        if (!changed)
                            return "";
                    } else {
                        len = LPS[len - 1];
                        lens[idx] = len;
                        idx++;
                    }
                } else if (idx >= chrs2.length - 1 && chrs1[idx - chrs2.length + 1] == 'T') {
                    return "";
                } else {
                    lens[idx] = len;
                    idx++;
                }
            } else {
                if (len > 0) {
                    len = LPS[len - 1];
                } else {
                    if (idx >= chrs2.length - 1 && chrs1[idx - chrs2.length + 1] == 'T')
                        return "";
                    idx++;
                }
            }
        }
        return new String(res);
    }

    public int[] getLPS(char[] chrs) {
        int[] LPS = new int[chrs.length];
        int idx = 1;
        int len = 0;
        while (idx < chrs.length) {
            if (chrs[idx] == chrs[len]) {
                len++;
                LPS[idx] = len;
                idx++;
            } else {
                if (len > 0) {
                    len = LPS[len - 1];
                } else {
                    idx++;
                }
            }
        }
        return LPS;
    }
}
