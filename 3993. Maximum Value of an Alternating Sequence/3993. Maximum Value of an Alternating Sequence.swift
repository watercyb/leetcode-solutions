/*
 * Problem: 3993. Maximum Value of an Alternating Sequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-value-of-an-alternating-sequence/
 * Language: swift
 * Date: 2026-07-18
 */

class Solution {
    func maximumValue(_ n: Int, _ s: Int, _ m: Int) -> Int {
        if n==1 {
            return s
        }
        return s+n/2*m-(n-1-n/2)+(n&1)
    }
}
