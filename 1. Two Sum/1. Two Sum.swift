/*
 * Problem: 1. Two Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/two-sum/
 * Language: swift
 * Date: 2026-05-10
 */

class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var map: [Int: Int] = [:]
        for i in 0...nums.count {
            if map[target-nums[i]] != nil {
                return [map[target-nums[i]] ?? i, i]
            }
            map[nums[i]]=i
        }
        return []
    }
}
