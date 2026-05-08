/*
 * Problem: 3557. Find Maximum Number of Non Intersecting Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-maximum-number-of-non-intersecting-substrings/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int maxSubstrings(String word) {
        if (word.length() <= 3)
            return 0;
        char[] chrs = word.toCharArray();
        int[] DP1 = getDP();
        int[] DP2 = getDP();
        int[] DP3 = getDP();
        int[] DP4 = getDP();
        int max = 0;
        for (int i = 0; i < chrs.length; i++) {
            for (int j = 0; j < 26; j++) {
                if (DP3[j] > DP4[j])
                    DP4[j] = DP3[j];
            }
            DP3 = DP2;
            DP2 = DP1;
            DP1 = getDP();
            int idx = chrs[i] - 'a';
            int count = DP4[idx] + 1;
            DP1[idx] = Math.max(max, DP1[idx]);
            max = Math.max(count, max);
        }
        return max;
    }

    public int[] getDP() {
        int[] res = new int[26];
        Arrays.fill(res, Integer.MIN_VALUE);
        return res;
    }
}
