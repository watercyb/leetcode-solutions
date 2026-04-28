/*
 * Problem: 3908. Valid Digit Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-digit-number/
 * Language: kotlin
 * Date: 2026-04-28
 */

class Solution {
    fun validDigit(n: Int, x: Int): Boolean {
        if (n==0) return false
        var digit=-1
        var has=false
        var n=n
        while (n>0) {
            digit=n%10
            if (digit==x) has=true
            n/=10
        }
        return digit!=x&&has
    }
}
