/*
 * Problem: 2451. Odd String Difference
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/odd-string-difference/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public String oddString(String[] words) {
        if (compare(words[0], words[1])) {
            for (int i = 1; i < words.length; i++) {
                if (!compare(words[i], words[0]))
                    return words[i];
            }
        }
        if (compare(words[2], words[0]))
            return words[1];
        return words[0];
    }

    public boolean compare(String a, String b) {
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) - a.charAt(i - 1) != b.charAt(i) - b.charAt(i - 1))
                return false;
        }
        return true;
    }
}
