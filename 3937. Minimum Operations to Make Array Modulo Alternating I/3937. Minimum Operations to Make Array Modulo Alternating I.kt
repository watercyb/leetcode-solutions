/*
 * Problem: 3937. Minimum Operations to Make Array Modulo Alternating I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-array-modulo-alternating-i/
 * Language: kotlin
 * Date: 2026-05-26
 */

class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        val dp = Array(2) { IntArray(k) }
        for (i in 0 until nums.size) {
            for (j in 0 until k) {
                val diff=Math.abs(nums[i]%k-j);
                dp[(i and 1)][j]+=Math.min(diff, k-diff)
            }
        }
        var mins=IntArray(k)
        var min=Integer.MAX_VALUE
        for (i in 0 until k) {
            mins[i]=min
            min=Math.min(min, dp[0][i])
        }
        min=Integer.MAX_VALUE
        var res=Integer.MAX_VALUE
        for (i in k-1 downTo 0) {
            mins[i]=Math.min(mins[i], min)
            min=Math.min(min, dp[0][i])
            res=Math.min(res, mins[i]+dp[1][i])
        }
        return res
    }
}
