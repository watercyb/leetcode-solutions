/*
 * Problem: 3932. Count K-th Roots in a Range
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-k-th-roots-in-a-range/
 * Language: swift
 * Date: 2026-05-18
 */

import Foundation

class Solution {
    func countKthRoots(_ l: Int, _ r: Int, _ k: Int) -> Int {
        if k==1{
            return r-l+1
        }
        var r=Double(r)
        var k=Double(k)
        var n=ceil(pow(Double(l),1.0/k))
        var res=0
        while pow(n,k)<=r {
            res+=1
            n+=1
        }
        return res
    }
}
