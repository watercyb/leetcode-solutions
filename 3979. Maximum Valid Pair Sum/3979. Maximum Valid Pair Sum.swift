/*
 * Problem: 3979. Maximum Valid Pair Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-valid-pair-sum/
 * Language: swift
 * Date: 2026-07-16
 */

class Solution {
    func maxValidPairSum(_ nums: [Int], _ k: Int) -> Int {
        var max_val=0
        var res=0
        for i in k..<nums.count {
            max_val=max(max_val, nums[i-k])
            res=max(res, max_val+nums[i])
        }
        return res
    }
}
