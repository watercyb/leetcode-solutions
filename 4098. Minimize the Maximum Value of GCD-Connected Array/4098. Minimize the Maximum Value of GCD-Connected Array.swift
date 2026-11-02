/*
 * Problem: 4098. Minimize the Maximum Value of GCD-Connected Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimize-the-maximum-value-of-gcd-connected-array/
 * Language: swift
 * Date: 2026-11-02
 */

class Solution {
    func minimumMaxValue(_ n: Int, _ index: Int, _ value: Int) -> Int {
        if n==1 {
            return value
        }
        if value==1 {
            return -1
        }
        if value%2==0 {
            if value-2*index<=0 {
                return -1
            } else {
                return value+2*(n-index-1)
            }
        } else {
            var num=value
            var i=2
            while i*i<=value {
                if value%i==0 {
                    num=i
                    break
                }
                i+=1
            }
            if index>0 && value-num-2*(index-1)<=0 {
                 return -1
            }
            if index==n-1 {
                return value
            }
            return value+num+2*(n-index-2)
        }
    }
}
