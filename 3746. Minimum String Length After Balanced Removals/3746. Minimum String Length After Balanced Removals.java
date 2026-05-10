/*
 * Problem: 3746. Minimum String Length After Balanced Removals
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-string-length-after-balanced-removals/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int minLengthAfterRemovals(String s) {
        int[] counts=new int[2];
        for (char chr:s.toCharArray()) {
            counts[chr-'a']++;
        }
        return Math.abs(counts[0]-counts[1]);
    }
}
