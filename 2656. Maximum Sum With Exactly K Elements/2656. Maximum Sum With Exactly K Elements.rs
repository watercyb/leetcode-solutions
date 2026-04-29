/*
 * Problem: 2656. Maximum Sum With Exactly K Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/
 * Language: rust
 * Date: 2026-04-29
 */

impl Solution {
    pub fn maximize_sum(nums: Vec<i32>, k: i32) -> i32 {
        return (nums.iter().max().unwrap()*2+k-1)*k/2;
    }
}
