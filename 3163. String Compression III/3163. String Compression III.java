/*
 * Problem: 3163. String Compression III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/string-compression-iii/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public String compressedString(String word) {
        char[] chrs = word.toCharArray();
        StringBuilder SB = new StringBuilder();
        char prv = chrs[0];
        int count = 1;
        int i = 1;
        while (i < chrs.length) {
            while (count < 9 && i < chrs.length && chrs[i] == prv) {
                count++;
                i++;
            }
            SB.append(count).append(prv);
            if (i == chrs.length)
                return SB.toString();
            prv = chrs[i++];
            count = 1;
        }
        SB.append(count).append(prv);
        return SB.toString();
    }
}
