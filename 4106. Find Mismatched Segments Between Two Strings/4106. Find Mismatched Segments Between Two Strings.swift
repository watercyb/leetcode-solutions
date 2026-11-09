/*
 * Problem: 4106. Find Mismatched Segments Between Two Strings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-mismatched-segments-between-two-strings/
 * Language: swift
 * Date: 2026-11-09
 */

class Solution {
    func findMismatchedSegments(_ s1: String, _ s2: String) -> [[String]] {
        let c1 = Array(s1)
        let c2 = Array(s2)
        var sub1=""
        var sub2=""
        var res: [[String]]=[]
        for i in 0..<c1.count {
            if c1[i]==c2[i] {
                if sub1.count != 0 {
                    res.append([sub1, sub2])
                    sub1=""
                    sub2=""
                }
            } else {
                sub1 += String(c1[i])
                sub2 += String(c2[i])
            }
        }
        if sub1.count != 0 {
            res.append([sub1, sub2])
        }
        return res
    }
}
