/*
 * Problem: 1708. Largest Subarray Length K
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/largest-subarray-length-k/
 * Language: rust
 * Date: 2026-04-20
 */

impl Solution {
    pub fn largest_subarray(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut res=0;
        let len:usize=k as usize;
        for i in 1..=nums.len()-len {
            for j in 0..len {
                if nums[i+j]>nums[res+j] {
                    res=i;
                    break;
                } else if nums[i+j]<nums[res+j] {
                    break;
                }
            }
        }
        return nums[res..res+len].to_vec();
    }
}
