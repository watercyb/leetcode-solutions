/*
 * Problem: 3083. Existence of a Substring in a String and Its Reverse
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public boolean isSubstringPresent(String s) {
        boolean[] seens = new boolean[26 * 26];
        for (int i = 1; i < s.length(); i++) {
            int a = s.charAt(i - 1) - 'a';
            int b = s.charAt(i) - 'a';
            seens[b * 26 + a] = true;
            if (seens[a * 26 + b])
                return true;
        }
        return false;
    }
}
