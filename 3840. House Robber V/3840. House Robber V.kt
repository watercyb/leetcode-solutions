/*
 * Problem: 3840. House Robber V
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/house-robber-v/
 * Language: kotlin
 * Date: 2026-05-11
 */

class Solution {
    fun rob(nums: IntArray, colors: IntArray): Long {
        var a=0L
        var b=nums[0].toLong()
        for (i in 1 until nums.size) {
            if (colors[i]==colors[i-1]) {
                var temp=Math.max(a+nums[i],b)
                a=b
                b=temp
            } else {
                a=b
                b+=nums[i]
            }
        }
        return b
    }
}
