/*
 * Problem: 3259. Maximum Energy Boost From Two Drinks
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-energy-boost-from-two-drinks/
 * Language: rust
 * Date: 2026-05-05
 */

impl Solution {
    pub fn max_energy_boost(energy_drink_a: Vec<i32>, energy_drink_b: Vec<i32>) -> i64 {
        let mut a:i64=0;
        let mut b:i64=0;
        let mut n:i64=0;
        for i in 0..energy_drink_a.len() {
            let temp=n;
            n=n.max(a).max(b);
            a=a.max(temp)+energy_drink_a[i] as i64;
            b=b.max(temp)+energy_drink_b[i] as i64;
        }
        return a.max(b);
    }
}
