/*
 * Problem: 791. Custom Sort String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/custom-sort-string/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public String customSortString(String order, String s) {
        int[] counts=new int['z'+1];
        for (char chr:s.toCharArray()) {
            counts[chr]++;
        }
        StringBuilder SB=new StringBuilder();
        for (char chr:order.toCharArray()) {
            for (int i=0;i<counts[chr];i++) {
                SB.append(chr);
            }
            counts[chr]=0;
        }
        for (int i='a';i<='z';i++) {
            for (int j=0;j<counts[i];j++) {
                SB.append((char)i);
            }
        }
        return SB.toString();
    }
}
