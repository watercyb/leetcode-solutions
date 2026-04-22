/*
 * Problem: 1957. Delete Characters to Make Fancy String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/delete-characters-to-make-fancy-string/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public String makeFancyString(String s) {
        char prv = '0';
        int count = 0;
        StringBuilder SB = new StringBuilder();
        for (char chr : s.toCharArray()) {
            if (chr != prv) {
                prv = chr;
                count = 1;
                SB.append(chr);
            } else {
                count++;
                if (count < 3)
                    SB.append(chr);
            }
        }
        return SB.toString();
    }
}
