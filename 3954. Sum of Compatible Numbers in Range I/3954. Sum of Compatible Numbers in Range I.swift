/*
 * Problem: 3954. Sum of Compatible Numbers in Range I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-of-compatible-numbers-in-range-i/
 * Language: swift
 * Date: 2026-06-08
 */

class Solution {
    func sumOfGoodIntegers(_ n: Int, _ k: Int) -> Int {
        var res=0
        for i in max(n-k,1)...n+k {
            if n&i==0 {
                res+=i
            }
        }
        return res
    }
}
