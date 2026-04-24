/*
 * Problem: 2144. Minimum Cost of Buying Candies With Discount
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/
 * Language: rust
 * Date: 2026-04-24
 */

impl Solution {
    pub fn minimum_cost(mut cost: Vec<i32>) -> i32 {
        cost.sort_by(|a, b| b.cmp(a));
        let mut res=0;
        for i in 0..cost.len() {
            if i%3!=2{
                res+=cost[i];
            }
        }
        return res;
    }
}
