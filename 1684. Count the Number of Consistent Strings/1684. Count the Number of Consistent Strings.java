/*
 * Problem: 1684. Count the Number of Consistent Strings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-the-number-of-consistent-strings/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] isAllowed = new boolean['z' + 1];
        for (char chr : allowed.toCharArray()) {
            isAllowed[chr] = true;
        }
        int res = words.length;
        for (String word : words) {
            for (char chr : word.toCharArray()) {
                if (!isAllowed[chr]) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}
