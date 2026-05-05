/*
 * Problem: 3234. Count the Number of Substrings With Dominant Ones
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-the-number-of-substrings-with-dominant-ones/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int numberOfSubstrings(String s) {
        char[] chrs = s.toCharArray();
        int[] zeros = new int[chrs.length + 1];
        zeros[0] = -1;
        int idx = 1;
        int res = 0;
        int lastZero = -1;
        int count = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '0') {
                zeros[idx++] = i;
                lastZero = i;
                count++;
            } else {
                res += i - lastZero;
            }
            for (int j = idx - 1; j >= 1; j--) {
                int len = (count - j + 1) * (count - j + 2);
                if (len > i + 1)
                    break;
                res += Math.max(Math.min(i - len + 1, zeros[j]) - zeros[j - 1], 0);
            }
        }
        return res;
    }
}
