/*
 * Problem: 3917. Count Indices With Opposite Parity
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-indices-with-opposite-parity/
 * Language: kotlin
 * Date: 2026-05-05
 */

class Solution {
    fun countOppositeParity(nums: IntArray): IntArray {
        var counts=IntArray(2)
        var res=IntArray(nums.size)
        for (i in nums.size-1 downTo 0) {
            val idx=nums[i] and 1
            res[i]=counts[1-idx]
            counts[idx]++
        }
        return res;
    }
}
