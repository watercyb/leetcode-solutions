/*
 * Problem: 4058. Maximum Pulse Value After One Subarray Rotation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-pulse-value-after-one-subarray-rotation/
 * Language: swift
 * Date: 2026-09-24
 */

class Solution {
    func maxValue(_ nums: [Int]) -> Int {
        var diff=0
        var sum=0
        var sign=1;
        var maxVals=[-1000000000, 0]
        for i in 0..<nums.count {
            let num=sign*nums[i];
            let idx=i%2
            sum+=num
            diff=max(diff, -(sum-maxVals[idx]))
            maxVals[idx]=max(maxVals[idx], sum)
            sign = -sign;
        }
        return sum+2*diff
    }
}
