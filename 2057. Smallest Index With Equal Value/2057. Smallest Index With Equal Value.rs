/*
 * Problem: 2057. Smallest Index With Equal Value
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/smallest-index-with-equal-value/
 * Language: rust
 * Date: 2026-04-23
 */

impl Solution {
    pub fn smallest_equal(nums: Vec<i32>) -> i32 {
        for i in 0..nums.len() {
            if (i as i32)%10 ==nums[i] {
                return i as i32;
            }
        }
        return -1;
    }
}
