/*
 * Problem: 2652. Sum Multiples
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-multiples/
 * Language: rust
 * Date: 2026-04-29
 */

impl Solution {
    pub fn sum_of_multiples(n: i32) -> i32 {
        let mut res=0;
        for i in 3..=n {
            if i%3==0||i%5==0||i%7==0 {
                res+=i;
            }
        }
        return res;
    }
}
