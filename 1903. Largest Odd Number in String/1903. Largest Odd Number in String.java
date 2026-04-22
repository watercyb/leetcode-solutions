/*
 * Problem: 1903. Largest Odd Number in String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/largest-odd-number-in-string/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public String largestOddNumber(String num) {
        for (int i=num.length()-1;i>=0;i--) {
            if (num.charAt(i)%2==1) {
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}
