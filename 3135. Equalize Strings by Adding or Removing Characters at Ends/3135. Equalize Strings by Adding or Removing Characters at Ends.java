/*
 * Problem: 3135. Equalize Strings by Adding or Removing Characters at Ends
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/equalize-strings-by-adding-or-removing-characters-at-ends/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minOperations(String initial, String target) {
        char[] chrsI = initial.toCharArray();
        char[] chrsT = target.toCharArray();
        int[] DP = new int[chrsT.length];
        int max = 0;
        for (int i = 0; i < chrsI.length; i++) {
            int prv = 0;
            for (int j = 0; j < chrsT.length; j++) {
                int temp = DP[j];
                if (chrsI[i] == chrsT[j]) {
                    DP[j] = prv + 1;
                    max = Math.max(DP[j], max);
                } else {
                    DP[j] = 0;
                }
                prv = temp;
            }
        }
        return chrsI.length - max + chrsT.length - max;
    }
}
