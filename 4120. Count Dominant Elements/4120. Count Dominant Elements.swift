/*
 * Problem: 4120. Count Dominant Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-dominant-elements/
 * Language: swift
 * Date: 2026-11-24
 */

class Solution {
    func countDominantElements(_ nums: [Int]) -> Int {
        if nums.count==1 {
            return 1
        }
        var res=0
        if nums[0]>=nums[1] {
            res += 1
        }
        if nums[nums.count-1]>=nums[nums.count-2] {
            res += 1
        }
        for i in 1..<nums.count-1 {
            if 2*nums[i]>=nums[i-1] + nums[i+1] {
                res+=1
            }
        }
        return res
    }
}
