/*
 * Problem: 848. Shifting Letters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shifting-letters/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] chr=s.toCharArray();
        long count=0;
        for (int i=shifts.length-1;i>=0;i--){
            count+=shifts[i];
            chr[i]=(char)((chr[i]+count-'a')%26+'a');
        }
        return String.valueOf(chr);
        
    }

}
