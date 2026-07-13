/*
 * Problem: 3982. Sum of Integers with Maximum Digit Range
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-of-integers-with-maximum-digit-range/
 * Language: swift
 * Date: 2026-07-13
 */

class Solution {
    func maxDigitRange(_ nums: [Int]) -> Int {
        var res=0
        var max=0
        for num in nums {
            let r=getRange(num)
            if r>max {
                max=r
                res=num
            } else if r==max {
                res+=num
            }
        }
        return res
    }

    func getRange(_ num: Int) -> Int {
        var max_digit=0
        var min_digit=9
        var num=num
        while num>0 {
            let digit=num%10
            max_digit=max(max_digit, digit)
            min_digit=min(min_digit, digit)
            num/=10
        }
        return max_digit-min_digit
    }
}
