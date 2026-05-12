/*
 * Problem: 3925. Concatenate Array With Reverse
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/concatenate-array-with-reverse/
 * Language: kotlin
 * Date: 2026-05-12
 */

class Solution {
    fun concatWithReverse(nums: IntArray): IntArray {
        val res=IntArray(2*nums.size)
        var l=0
        var r=res.size-1
        while (l<r) {
            res[l]=nums[l]
            res[r]=nums[l]
            l++
            r--
        }
        return res
    }
}
