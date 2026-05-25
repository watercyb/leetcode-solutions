/*
 * Problem: 3940. Limit Occurrences in Sorted Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/limit-occurrences-in-sorted-array/
 * Language: swift
 * Date: 2026-05-25
 */

class Solution {
    func limitOccurrences(_ nums: [Int], _ k: Int) -> [Int] {
        var res: [Int]=[]
        var prv=0
        var count=0
        for num in nums {
            if num != prv {
                prv=num
                count=1
            } else {
                count += 1
            }
            if (count <= k) {
                res.append(num)
            }
        }
        return res
    }
}
