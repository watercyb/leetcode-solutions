/*
 * Problem: 3987. Minimum Total Cost to Process All Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-total-cost-to-process-all-elements/
 * Language: kotlin
 * Date: 2026-07-13
 */

class Solution {
    fun minimumCost(nums: IntArray, k: Int): Int {
        var stp: Long=0
        var r=k
        for (num in nums) {
            if (num>r) {
                val n=(num-r+k-1)/k
                r=r+n*k-num
                stp+=n
            } else {
                r-=num
            }
        }
        stp%=1_000_000_007
        return ((stp+1)*stp/2%1_000_000_007).toInt()
    }
}
