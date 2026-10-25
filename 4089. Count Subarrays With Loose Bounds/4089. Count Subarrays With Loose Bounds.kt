/*
 * Problem: 4089. Count Subarrays With Loose Bounds
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-subarrays-with-loose-bounds/
 * Language: kotlin
 * Date: 2026-10-25
 */

class Solution {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var count=0
        var res=0L
        for (num in nums) {
            if (num>=minK&&num<=maxK) {
                count++
                res+=count
            } else {
                count=0
            }
        }
        return res
    }
}
