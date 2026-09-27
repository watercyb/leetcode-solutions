/*
 * Problem: 4062. Transform Array Using Pair Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/transform-array-using-pair-operations/
 * Language: swift
 * Date: 2026-09-27
 */

class Solution {
    func canTransform(_ source: [Int], _ target: [Int]) -> Bool {
        var sum=0
        for num in source {
            sum+=num
        }
        for num in target {
            sum-=num
        }
        return sum==0
    }
}
