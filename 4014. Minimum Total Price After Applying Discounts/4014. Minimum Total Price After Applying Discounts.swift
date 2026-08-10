/*
 * Problem: 4014. Minimum Total Price After Applying Discounts
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-total-price-after-applying-discounts/
 * Language: swift
 * Date: 2026-08-10
 */

class Solution {
    func minPrice(_ prices: [Int], _ discounts: [Int]) -> Double {
        let prices = prices.sorted()
        let discounts = discounts.sorted()
        var i=prices.count-1
        var j=discounts.count-1
        var res: Double=0
        while i>=0 {
            if j>=0 {
                res+=Double(prices[i]*(100-discounts[j]))/100;
            } else {
                res+=Double(prices[i])
            }
            i-=1
            j-=1
        }
        return res
    }
}
