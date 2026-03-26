/*
 * Problem: 165. Compare Version Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/compare-version-numbers/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        while (i < version1.length() || j < version2.length()) {
            int a = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                a *= 10;
                a += version1.charAt(i) - '0';
                i++;
            }
            int b = 0;
            while (j < version2.length() && version2.charAt(j) != '.') {
                b *= 10;
                b += version2.charAt(j) - '0';
                j++;
            }
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
}
