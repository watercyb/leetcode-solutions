/*
 * Problem: 3891. Minimum Increase to Maximize Special Indices
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-increase-to-maximize-special-indices/
 * Language: swift
 * Date: 2026-04-08
 */

class Solution {
    func minIncrease(_ nums: [Int]) -> Int {
        if nums.count%2==1 {
            var count=0
            for i in stride(from: 1, through: nums.count-2, by: 2) {
                count+=max(nums[i-1]-nums[i]+1, nums[i+1]-nums[i]+1, 0)
            }
            var res=count
            count=0
            for i in stride(from: nums.count-2, through: 1, by: -2) {
                count+=max(nums[i-1]-nums[i]+1, nums[i+1]-nums[i]+1, 0)
            }
            res=min(res, count)
            return res
        } else {
            var a=0
            var b=0
            for i in stride(from: 1, through: nums.count-2, by: 2) {
                let temp=a
                a+=max(nums[i-1]-nums[i]+1, nums[i+1]-nums[i]+1, 0)
                b=min(temp,b)+max(nums[i]-nums[i+1]+1, nums[i+2]-nums[i+1]+1, 0)
            }
            var res=min(a,b)
            a=0
            b=0
            for i in stride(from: nums.count-2, through: 1, by: -2) {
                 let temp=a
                a+=max(nums[i-1]-nums[i]+1, nums[i+1]-nums[i]+1, 0)
                b=min(temp,b)+max(nums[i-2]-nums[i-1]+1, nums[i]-nums[i-1]+1, 0)
            }
            res=min(res, a, b)
            return res
        }
    }
}
