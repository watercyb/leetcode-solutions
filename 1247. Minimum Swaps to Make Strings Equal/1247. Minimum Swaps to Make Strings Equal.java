/*
 * Problem: 1247. Minimum Swaps to Make Strings Equal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int minimumSwap(String s1, String s2) {
        char[] chrs1 = s1.toCharArray();
        char[] chrs2 = s2.toCharArray();
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < chrs1.length; i++) {
            if (chrs1[i] != chrs2[i]) {
                if (chrs1[i] > chrs2[i]) {
                    count1++;
                } else {
                    count2++;
                }
            }
        }
        if ((count1 + count2) % 2 == 1)
            return -1;
        return count1 / 2 + count2 / 2 + count1 % 2 + count2 % 2;
    }
}
