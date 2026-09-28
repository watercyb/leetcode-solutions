/*
 * Problem: 4067. Longest Subarray With Restricted Pair Sums
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-subarray-with-restricted-pair-sums/
 * Language: kotlin
 * Date: 2026-09-28
 */

class Solution {
    fun maxSubarray(nums: IntArray): Int {
        var max=0
        for (num in nums) {
            max=maxOf(max, num)
        }
        var j=0
        val counts=IntArray(max+1)
        var res=0
        for (i in 0 until nums.size) {
            while (j<nums.size) {
                var isGood=true
                for (num in 0 until counts.size) {
                    if (counts[num]==0) continue
                    var n=num+nums[j]
                    if (n<counts.size&&counts[n]>0) {
                        isGood=false
                        break
                    }
                    n=Math.abs(num-nums[j])
                    if (n==num) {
                        if (counts[n]>=2) {
                            isGood=false
                            break
                        }
                    } else {
                        if (counts[n]>0) {
                            isGood=false
                            break
                        }
                    }
                }
                if (isGood) {
                    counts[nums[j]]++
                    j++;
                } else {
                    break;
                }
            }
            res=Math.max(res, j-i)
            counts[nums[i]]--
        }
        return res
    }
}
