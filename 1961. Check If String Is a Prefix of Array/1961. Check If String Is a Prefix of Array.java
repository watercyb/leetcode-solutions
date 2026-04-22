/*
 * Problem: 1961. Check If String Is a Prefix of Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int length = 0;
        boolean isLengthGood = false;
        for (String str : words) {
            length += str.length();
            if (length == s.length()) {
                isLengthGood = true;
                break;
            }
        }
        if (!isLengthGood)
            return false;
        int i = 0;
        int j = 0;
        for (char chr : s.toCharArray()) {
            if (chr != words[i].charAt(j))
                return false;
            j++;
            if (j == words[i].length()) {
                i++;
                j = 0;
            }
        }
        return true;
    }
}
