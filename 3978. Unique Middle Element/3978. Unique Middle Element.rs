/*
 * Problem: 3978. Unique Middle Element
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/unique-middle-element/
 * Language: rust
 * Date: 2026-07-07
 */

impl Solution {
    pub fn is_middle_element_unique(nums: Vec<i32>) -> bool {
        let idx=nums.len()/2;
        for i in 0..nums.len() {
            if i!=idx&&nums[i]==nums[idx] {
                return false;
            }
        }
        return true;
    }
}
