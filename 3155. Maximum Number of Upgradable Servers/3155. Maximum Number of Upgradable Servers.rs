/*
 * Problem: 3155. Maximum Number of Upgradable Servers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-upgradable-servers/?envType=problem-list-v2&envId=math
 * Language: rust
 * Date: 2026-04-03
 */

impl Solution {
    pub fn max_upgrades(count: Vec<i32>, upgrade: Vec<i32>, sell: Vec<i32>, money: Vec<i32>) -> Vec<i32> {
        let mut res: Vec<i32>=Vec::new();
        for i in 0..count.len() {
            let c=count[i] as i64;
            let u=upgrade[i] as i64;
            let s=sell[i] as i64;
            let m=money[i] as i64;
            res.push(((m+s*c)/(u+s)).min(c) as i32);
        }
        return res;
    }
}
