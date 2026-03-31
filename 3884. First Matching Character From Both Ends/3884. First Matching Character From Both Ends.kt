/*
 * Problem: 3884. First Matching Character From Both Ends
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/first-matching-character-from-both-ends/
 * Language: kotlin
 * Date: 2026-03-31
 */

class Solution {
    fun firstMatchingIndex(s: String): Int {
        var l=0;
        var r=s.length-1;
        while (l<=r) {
            if (s[l]==s[r]) return l;
            l++;
            r--;
        }
        return -1;
    }
}
