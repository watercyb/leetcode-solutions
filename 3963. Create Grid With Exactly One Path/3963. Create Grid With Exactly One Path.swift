/*
 * Problem: 3963. Create Grid With Exactly One Path
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/create-grid-with-exactly-one-path/
 * Language: swift
 * Date: 2026-08-26
 */

class Solution {
    func createGrid(_ m: Int, _ n: Int) -> [String] {
        var res: [String]=[]
        var str=String()
        for i in 0..<n {
            str.append(".")
        }
        res.append(str)
        for i in 1..<m {
            str=String()
            for i in 0..<n-1 {
                str.append("#")
            }
            str.append(".")
            res.append(str)
        }
        return res
    }
}
