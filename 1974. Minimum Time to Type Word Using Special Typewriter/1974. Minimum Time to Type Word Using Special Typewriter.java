/*
 * Problem: 1974. Minimum Time to Type Word Using Special Typewriter
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int minTimeToType(String word) {
        char prv = 'a';
        int res = 0;
        for (char chr : word.toCharArray()) {
            int diff = (chr - prv + 26) % 26;
            if (diff > 13)
                diff = 26 - diff;
            res += diff + 1;
            prv = chr;
        }
        return res;
    }
}
