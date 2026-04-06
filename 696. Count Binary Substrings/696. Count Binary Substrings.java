/*
 * Problem: 696. Count Binary Substrings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-binary-substrings/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int countBinarySubstrings(String s) {
        char[] chrs = s.toCharArray();
        int res = 0;
        int current = chrs[0];
        int prvCount = 0;
        int currentCount = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == current) {
                currentCount++;
            } else {
                res += Math.min(currentCount, prvCount);
                current = chrs[i];
                prvCount = currentCount;
                currentCount = 1;
            }
        }
        res += Math.min(currentCount, prvCount);
        return res;
    }
}
