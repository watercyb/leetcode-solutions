/*
 * Problem: 2955. Number of Same-End Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-same-end-substrings/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int l = s.length();
        int[][] counts = new int[26][l + 1];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < 26; j++) {
                counts[j][i + 1] = counts[j][i];
            }
            counts[s.charAt(i) - 'a'][i + 1]++;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            for (int j = 0; j < 26; j++) {
                int count = counts[j][queries[i][1] + 1] - counts[j][queries[i][0]];
                sum += count * (count + 1) / 2;
            }
            res[i] = sum;
        }
        return res;
    }
}
