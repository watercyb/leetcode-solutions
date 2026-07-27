/*
 * Problem: 4001. Aggregate Two Time Series
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/aggregate-two-time-series/
 * Language: swift
 * Date: 2026-07-27
 */

class Solution {
    func aggregateTimeSeries(_ series1: [[Int]], _ series2: [[Int]]) -> [[Int]] {
        var l=0
        var r=0
        var res: [[Int]]=[]
        while l<series1.count&&r<series2.count {
            if series1[l][0]<series2[r][0] {
                res.append([series1[l][0],series1[l][1]+series2[r][1]])
                l+=1;
            } else if series1[l][0]>series2[r][0] {
                res.append([series2[r][0],series1[l][1]+series2[r][1]])
                r+=1;
            } else {
                res.append([series1[l][0],series1[l][1]+series2[r][1]])
                l+=1;
                r+=1;
            }
        }
        while l<series1.count {
            res.append([series1[l][0],series1[l][1]])
            l+=1;
        }
        while r<series2.count {
            res.append([series2[r][0],series2[r][1]])
            r+=1;
        }
        return res
    }
}
