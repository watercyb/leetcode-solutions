/*
 * Problem: 3946. Maximum Number of Items From Sale I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-items-from-sale-i/
 * Language: swift
 * Date: 2026-06-01
 */

class Solution {
    func maximumSaleItems(_ items: [[Int]], _ budget: Int) -> Int {
        var dp=Array(repeating: 0, count: budget+1)
        var items=items;
        items.sort { $0[0] < $1[0] }
        var counts=Array(repeating: 0, count: 1501)
        for i in 0..<items.count {
            if items[i][1]>budget {
                continue
            }
            var count=1
            if (counts[items[i][0]] != 0) {
                count=counts[items[i][0]]
            } else {
                for j in i+1..<items.count {
                    if items[j][0]%items[i][0]==0 {
                        count+=1;
                    }
                }
                counts[items[i][0]]=count
            }
            for j in stride(from: budget-items[i][1], through: 0, by: -1) {
                dp[j+items[i][1]]=max(dp[j+items[i][1]], dp[j]+count)
            }
            for j in 0...budget-items[i][1] {
                dp[j+items[i][1]]=max(dp[j+items[i][1]], dp[j]+1)
            }
        }
        var res=0
        for num in dp {
            res=max(res, num)
        }
        return res
    }
}
