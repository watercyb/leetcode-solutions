/*
 * Problem: 2129. Capitalize the Title
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/capitalize-the-title/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public String capitalizeTitle(String title) {
        String[] strs = title.split(" ");
        for (int i = 0; i < strs.length - 1; i++) {
            chk(strs[i]);
            SB.append(' ');
        }
        chk(strs[strs.length - 1]);
        return SB.toString();
    }

    StringBuilder SB = new StringBuilder();

    public void chk(String str) {
        if (str.length() <= 2) {
            for (char chr : str.toCharArray()) {
                SB.append(Character.toLowerCase(chr));
            }
        } else {
            SB.append(Character.toUpperCase(str.charAt(0)));
            for (int i = 1; i < str.length(); i++) {
                SB.append(Character.toLowerCase(str.charAt(i)));
            }
        }
    }
}
