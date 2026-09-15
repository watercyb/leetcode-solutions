/*
 * Problem: 4052. Cyclically Shift Rows and Columns
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/cyclically-shift-rows-and-columns/
 * Language: swift
 * Date: 2026-09-15
 */

class Solution {
    func cyclicShift(_ n: Int, _ grid: [[Int]], _ rowShift: [Int], _ colShift: [Int]) -> [[Int]] {
        var m1 = Array(repeating: Array(repeating: 0, count: n), count: n)
        for i in 0..<rowShift.count {
            var idx=((-rowShift[i])%n+n)%n
            for j in 0..<n {
                m1[i][idx]=grid[i][j]
                idx+=1
                if idx==n {
                    idx=0
                }
            }
        }
        var m2 = Array(repeating: Array(repeating: 0, count: n), count: n)
        for i in 0..<colShift.count {
            var idx=((-colShift[i])%n+n)%n
            for j in 0..<n {
                m2[idx][i]=m1[j][i]
                idx+=1
                if idx==n {
                    idx=0
                }
            }
        }
        return m2
    }
}
