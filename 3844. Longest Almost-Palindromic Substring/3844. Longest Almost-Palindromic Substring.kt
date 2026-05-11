/*
 * Problem: 3844. Longest Almost-Palindromic Substring
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-almost-palindromic-substring/
 * Language: kotlin
 * Date: 2026-05-11
 */

class Solution {
    fun almostPalindromic(s: String): Int {
        var res=0
        for (i in 0 until s.length) {
            res=Math.max(Math.max(res, getMax1(s, i)), getMax2(s, i))
        }
        return Math.min(res, s.length)
    }

    fun getMax1(s: String, idx: Int):  Int {
        var l=idx-1
        var r=idx+1
        while (l>=0&&r<s.length&&s[l]==s[r]) {
            l--
            r++
        }
        return Math.max(chk(s, l-1, r), chk(s, l, r+1)) 
    }

    fun getMax2(s: String, idx: Int):  Int {
        var l=idx
        var r=idx+1
        while (l>=0&&r<s.length&&s[l]==s[r]) {
            l--
            r++
        }
        return Math.max(chk(s, l-1, r), chk(s, l, r+1)) 
    }

    fun chk(s: String, l: Int, r: Int):  Int {
        var l=l;
        var r=r;
        while (l>=0&&r<s.length&&s[l]==s[r]) {
            l--
            r++
        }
        return r-l-1
    }
}
