/*
 * Problem: 20. Valid Parentheses
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-parentheses/?envType=daily-question&envId=2026-10-01
 * Language: java
 * Date: 2026-10-01
 */

class Solution {
    public static boolean isValid(String s) {
        char[] chrs = s.toCharArray();
        int j = 0;
        for (int i = 0; i < chrs.length; i++) {
            switch (chrs[i]) {
                case '(':
                    chrs[j++] = ')';
                    break;
                case '[':
                    chrs[j++] = ']';
                    break;
                case '{':
                    chrs[j++] = '}';
                    break;
                default:
                    if (j == 0 || chrs[j - 1] != chrs[i])
                        return false;
                    j--;
            }
        }
        return j == 0;
    }
}
