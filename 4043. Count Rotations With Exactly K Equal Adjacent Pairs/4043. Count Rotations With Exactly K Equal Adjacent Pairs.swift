/*
 * Problem: 4043. Count Rotations With Exactly K Equal Adjacent Pairs
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-rotations-with-exactly-k-equal-adjacent-pairs/
 * Language: swift
 * Date: 2026-09-10
 */

class Solution {
    func countGoodRotations(_ nums: [Int]) -> Int {
        var total=0
        for num in nums {
            total+=num
        }
        var l=0
        var r=nums.count/2
        var sum=0
        var res=0
        for i in 0..<r {
            sum+=nums[i]
        }
        while l<nums.count {
            if sum*2>total {
                res+=1
            }
            sum+=nums[r]-nums[l]
            l+=1
            r+=1
            if r==nums.count {
                r=0
            }
        }
        return res
    }
}
