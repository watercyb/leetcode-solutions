/*
 * Problem: 459. Repeated Substring Pattern
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/repeated-substring-pattern/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        char[] chrs = s.toCharArray();
        for (int i = 1; i <= chrs.length / 2; i++) {
            if (chrs.length % i != 0)
                continue;
            boolean isRepeated = true;
            for (int j = 0; j < i && isRepeated; j++) {
                for (int k = j + i; k < chrs.length; k += i) {
                    if (chrs[k] != chrs[j]) {
                        isRepeated = false;
                        break;
                    }
                }
            }
            if (isRepeated)
                return true;
        }
        return false;
    }
}
