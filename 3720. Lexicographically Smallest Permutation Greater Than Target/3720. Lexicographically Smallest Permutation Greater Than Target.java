/*
 * Problem: 3720. Lexicographically Smallest Permutation Greater Than Target
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/?envType=daily-question&envId=2026-08-27
 * Language: java
 * Date: 2026-08-27
 */

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        char[] chrs = target.toCharArray();
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
        }
        char[] res = new char[chrs.length];
        int idx = 0;
        while (idx < chrs.length) {
            if (counts[chrs[idx]] > 0) {
                counts[chrs[idx]]--;
                res[idx] = chrs[idx];
                idx++;
            } else {
                break;
            }
        }
        if (idx == chrs.length) {
            idx--;
        } else {
            counts[chrs[idx]]--;
            res[idx] = chrs[idx];
        }
        while (idx >= 0) {
            boolean found = false;
            counts[res[idx]]++;
            for (int i = chrs[idx] + 1; i <= 'z'; i++) {
                if (counts[i] > 0) {
                    counts[i]--;
                    res[idx++] = (char) i;
                    found = true;
                    break;
                }
            }
            if (found)
                break;
            idx--;
        }
        if (idx < 0)
            return "";
        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < counts[i]; j++) {
                res[idx++] = i;
            }
        }
        return new String(res);
    }
}
