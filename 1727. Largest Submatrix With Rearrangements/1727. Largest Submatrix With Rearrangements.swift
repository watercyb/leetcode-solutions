/*
 * Problem: 1727. Largest Submatrix With Rearrangements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-submatrix-with-rearrangements/
 * Language: swift
 * Date: 2026-04-20
 */

class Solution {
    func largestSubmatrix(_ matrix: [[Int]]) -> Int {
        var grid: [[Int]]=[]
        grid.append(matrix[0])
        for i in 1..<matrix.count {
            grid.append(matrix[i])
            for j in 0..<matrix[0].count {
                if matrix[i][j]==1 {
                    grid[i][j]=grid[i-1][j]+1
                } else {
                    grid[i][j]=0
                }
            }
        }
        var res=0
        for var row in grid {
            row.sort()
            var maxValue=0
            for i in (0..<row.count).reversed() {
                maxValue=max(maxValue, row[i]*(grid[0].count-i))
            }
            res=max(res,maxValue)
        }
        return res
    }
}
