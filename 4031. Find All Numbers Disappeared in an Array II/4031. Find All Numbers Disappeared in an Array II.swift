/*
 * Problem: 4031. Find All Numbers Disappeared in an Array II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array-ii/
 * Language: swift
 * Date: 2026-08-26
 */

class Solution {
    func findDisappearedNumbers(_ nums: [Int], _ lower: Int, _ upper: Int) -> [[Int]] {
        var nums=nums
        nums.sort()
        var res: [[Int]]=[]
        var l=lower
        for num in nums {
            if l==num {
                l+=1
            } else if l<num {
                res.append([l,min(num-1,upper)])
                l=num+1
            }
            if l>upper {
                break;
            }
        }
        if l<=upper {
            res.append([l,upper])
        }
        return res
    }
}
