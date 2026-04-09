/*
 * Problem: 844. Backspace String Compare
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/backspace-string-compare/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return typed(s).equals(typed(t));
    }

    public String typed(String str) {
        StringBuilder SB=new StringBuilder();
        for (char chr:str.toCharArray()) {
            if (chr=='#') {
                if (SB.length()>0) SB.deleteCharAt(SB.length()-1);
            } else {
                SB.append(chr);
            }
        }
        return SB.toString();
    }
}
