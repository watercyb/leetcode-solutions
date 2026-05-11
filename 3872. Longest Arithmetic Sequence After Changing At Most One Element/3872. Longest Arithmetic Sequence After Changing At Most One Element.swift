/*
 * Problem: 3872. Longest Arithmetic Sequence After Changing At Most One Element
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-arithmetic-sequence-after-changing-at-most-one-element/
 * Language: swift
 * Date: 2026-05-11
 */

class Solution {
    func longestArithmetic(_ nums: [Int]) -> Int {
        var i=0
        var res=1
        while i<nums.count-1 {
            var j=i+1
            while j<nums.count-1 && nums[j+1]-nums[j]==nums[i+1]-nums[i] {
                j+=1
            }
            let next=j
            if j+2<nums.count && (nums[j+2]-nums[j]==(nums[i+1]-nums[i])*2) {
                j+=2
                while j<nums.count-1 && nums[j+1]-nums[j]==nums[i+1]-nums[i] {
                    j+=1
                }
                res=max(res,j-i+1)
            } else {
                if (j<nums.count-1){
                    res=max(res,j-i+2)
                } else {
                    res=max(res,j-i+1)
                }
            }
            i=next
        }
        i=nums.count-1
        while i>0 {
            var j=i-1
            while j>0 && nums[j-1]-nums[j]==nums[i-1]-nums[i] {
                j-=1
            }
            let next=j
            if j-2>=0 && (nums[j-2]-nums[j]==(nums[i-1]-nums[i])*2) {
                j-=2
                while j>0 && nums[j-1]-nums[j]==nums[i-1]-nums[i] {
                    j-=1
                }
                res=max(res,i-j+1)
            } else {
                if (j>0){
                    res=max(res,i-j+2)
                } else {
                    res=max(res,i-j+1)
                }
            }
            i=next
        }
        return res
    }
}
