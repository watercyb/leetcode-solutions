/*
 * Problem: 4107. Count Valid Suffix Sorts I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-valid-suffix-sorts-i/
 * Language: kotlin
 * Date: 2026-11-08
 */

class Solution {
    fun countSuffix(nums: IntArray, target: IntArray): Int {
        var maxN=0
        var maxT=0
        for (num in nums) {
            maxN=maxOf(maxN,num)
        }
        for (num in target) {
            maxT=maxOf(maxT,num)
        }
        if (maxN!=maxT) return 0
        val counts=IntArray(maxN+1){0}
        var count=0
        var prv=-1
        var idx=nums.size-1
        var max=0
        var isSorted=true
        while (idx>0&&target[idx-1]>=target[idx]) {
            if (counts[nums[idx]]++==0)
                count++
            if (counts[target[idx]]--==1)
                count--
            max=maxOf(max, nums[idx])
            if (nums[idx-1]<nums[idx]) isSorted=false
            idx--
        }
        if (counts[nums[idx]]++==0)
            count++
        if (counts[target[idx]]--==1)
            count--
        if (count!=0) return 0
        max=maxOf(max, nums[idx])
        var index=idx;
        idx--
        while (idx>=0) {
            if (nums[idx]!=target[idx]) return 0
            idx--
        }
        if (isSorted) return nums.size-index
        var res=1
        while (index<nums.size-1&&nums[index]==target[index]) {
            res++
            index++
        }
        return res
    }
}
