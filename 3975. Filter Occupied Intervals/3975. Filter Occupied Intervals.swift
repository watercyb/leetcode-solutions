/*
 * Problem: 3975. Filter Occupied Intervals
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/filter-occupied-intervals/
 * Language: swift
 * Date: 2026-06-29
 */

class Solution {
    func filterOccupiedIntervals(_ occupiedIntervals: [[Int]], _ freeStart: Int, _ freeEnd: Int) -> [[Int]] {
        var arr: [[Int]]=[]
        for interval in occupiedIntervals {
            let l=interval[0]
            let r=interval[1]
            if l>freeEnd || r<freeStart {
                arr.append(interval)
            } else if l<freeStart && r>freeEnd  {
                arr.append([l, freeStart-1])
                arr.append([freeEnd+1, r])
            } else if l<freeStart  {
                arr.append([l, freeStart-1])
            } else if r>freeEnd {
                arr.append([freeEnd+1, r])
            }
        }
        arr.sort{$0[0] < $1[0]}
        var res: [[Int]]=[]
        if arr.count==0 {
            return res
        }
        var l=arr[0][0]
        var r=arr[0][1]
        for i in 1..<arr.count {
            if arr[i][0]>r+1 {
                res.append([l,r])
                l=arr[i][0]
                r=arr[i][1]
            } else if arr[i][1]>r {
                r=arr[i][1]
            }
        }
        res.append([l,r])
        return res
    }
}
