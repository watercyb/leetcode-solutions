/*
 * Problem: 3909. Compare Sums of Bitonic Parts
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/compare-sums-of-bitonic-parts/
 * Language: swift
 * Date: 2026-04-28
 */

class Solution {
    func compareBitonicSums(_ nums: [Int]) -> Int {
        var sum=0
        var prv = -1
        var max=0
        for num in nums {
            if num>prv {
                sum+=num
                max=num
            } else {
                sum-=num
            }
            prv=num
        }
        sum-=max
        if sum>0 {
            return 0
        } else if sum<0 {
            return 1
        } else {
            return -1
        }
    }
}
