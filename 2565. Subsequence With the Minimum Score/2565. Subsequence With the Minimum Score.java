/*
 * Problem: 2565. Subsequence With the Minimum Score
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/subsequence-with-the-minimum-score/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int minimumScore(String s, String t) {
        char[] chrsS = s.toCharArray();
        char[] chrsT = t.toCharArray();
        int[] arr = new int[chrsS.length];
        int j = 0;
        for (int i = 0; i < chrsS.length; i++) {
            if (chrsS[i] == chrsT[j]) {
                j++;
                if (j == chrsT.length)
                    return 0;
            }
            arr[i] = j - 1;
        }
        int res = Integer.MAX_VALUE;
        j = chrsT.length - 1;
        for (int i = chrsS.length - 1; i >= 0; i--) {
            res = Math.min(j - arr[i], res);
            if (chrsS[i] == chrsT[j]) {
                j--;
            }
        }
        res = Math.min(j + 1, res);
        return res;
    }
}
