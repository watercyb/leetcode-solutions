/*
 * Problem: 2859. Sum of Values at Indices With K Set Bits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/
 * Language: rust
 * Date: 2026-05-01
 */

impl Solution {
    pub fn sum_indices_with_k_set_bits(nums: Vec<i32>, k: i32) -> i32 {
        let mut res=0;
        for i in 0..nums.len() {
            if i.count_ones() as i32==k {
                res+=nums[i];
            }
        }
        return res;
    }
}
