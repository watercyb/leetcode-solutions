/*
 * Problem: 4006. Count Valid Prefixes
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-valid-prefixes/
 * Language: kotlin
 * Date: 2026-08-06
 */

class Solution {
    fun countValidPrefixes(s: String): Int {
        var count=0
        var res=0
        for (chr in s) {
            if (chr=='0') {
                count++
            } else {
                count--
            }
            if (count>=-1&&count<=1) res++
        }
        return res
    }
}
