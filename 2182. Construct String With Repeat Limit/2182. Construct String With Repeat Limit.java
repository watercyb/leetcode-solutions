/*
 * Problem: 2182. Construct String With Repeat Limit
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-string-with-repeat-limit/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
        }
        char[] res = new char[s.length()];
        int idx = 0;
        int i = 'z';
        int j = 'z';
        while (i >= 'a') {
            if (counts[i] <= repeatLimit) {
                for (int k = 0; k < counts[i]; k++) {
                    res[idx++] = (char) i;
                }
                i--;
            } else {
                for (int k = 0; k < repeatLimit; k++) {
                    res[idx++] = (char) i;
                }
                counts[i] -= repeatLimit;
                if (j >= i)
                    j = i - 1;
                while (j >= 'a' && counts[j] == 0) {
                    j--;
                }
                if (j < 'a')
                    break;
                res[idx++] = (char) j;
                counts[j]--;
            }
        }
        return new String(res, 0, idx);
    }
}
