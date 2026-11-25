/*
 * Problem: 4117. Minimum Range After Sum Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-range-after-sum-operations/
 * Language: kotlin
 * Date: 2026-11-25
 */

class Solution {
    fun minRange(a: Int, b: Int, c: Int): Int {
        val min=minOf(a,b,c)
        val max=maxOf(a,b,c)
        val mid=a+b+c-min-max
        return minOf(mid,max-min)
    }
}
