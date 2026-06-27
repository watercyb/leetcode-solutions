/*
 * Problem: 1. Two Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/two-sum/
 * Language: rust
 * Date: 2026-06-27
 */

use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut hm: HashMap<i32, i32> = HashMap::new();
        for i in 0..nums.len() {
            let num=target-nums[i];
            if hm.contains_key(&num) {
                return vec![*hm.get(&num).unwrap(), i as i32];
            }
            hm.insert(nums[i],i as i32);
        }
        return vec![-1, -1];
    }
}
