/*
 * Problem: 2135. Count Words Obtained After Adding a Letter
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-words-obtained-after-adding-a-letter/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    static int[] masks;

    public int wordCount(String[] startWords, String[] targetWords) {
        if (masks == null) {
            masks = new int['z' + 1];
            masks['a'] = 1;
            for (int i = 'b'; i <= 'z'; i++) {
                masks[i] = masks[i - 1] * 2;
            }
        }
        HashSet<Integer> HS = new HashSet<>();
        for (String str : startWords) {
            HS.add(h(str));
        }
        int res = 0;
        for (String str : targetWords) {
            int h = h(str);
            for (char chr : str.toCharArray()) {
                if ((h & masks[chr]) == masks[chr] && HS.contains(h - masks[chr])) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public int h(String str) {
        int res = 0;
        for (char chr : str.toCharArray()) {
            res += masks[chr];
        }
        return res;
    }
}
