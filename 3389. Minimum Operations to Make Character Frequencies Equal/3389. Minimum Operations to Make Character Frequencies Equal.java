/*
 * Problem: 3389. Minimum Operations to Make Character Frequencies Equal
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-make-character-frequencies-equal/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int makeStringGood(String s) {
        int[] counts = new int[26];
        for (char chr : s.toCharArray()) {
            counts[chr - 'a']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(counts[i], max);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= max; i++) {
            res = Math.min(getMin(counts, i), res);
        }
        return res;
    }

    public int getMin(int[] counts, int target) {
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < counts.length; i++) {
            int aNext = 0;
            int bNext = 0;
            int cNext = 0;
            if (counts[i] == target || counts[i] == 0) {
                aNext = Math.min(a, c);
                cNext = aNext;
            } else {
                if (counts[i] < target) {
                    aNext = Math.min(a, c) + counts[i];
                    bNext = counts[i];
                    cNext = Math.min(a + Math.max(target - counts[i] - b, 0), c + target - counts[i]);
                } else {
                    aNext = Math.min(a, c) + counts[i] - target;
                    bNext = counts[i] - target;
                    cNext = aNext;
                }
            }
            a = aNext;
            b = bNext;
            c = cNext;
        }
        return Math.min(a, c);
    }
}
