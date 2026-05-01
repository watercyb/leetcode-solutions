/*
 * Problem: 2869. Minimum Operations to Collect Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-operations-to-collect-elements/
 * Language: rust
 * Date: 2026-05-01
 */

impl Solution {
    pub fn min_operations(nums: Vec<i32>, k: i32) -> i32 {
        let mut seens=vec![false;k as usize+1];
        let mut count=0;
        for i in (0..nums.len()).rev() {
            if nums[i]<=k && !seens[nums[i] as usize] {
                seens[nums[i] as usize]=true;
                count+=1;
                if count==k {
                    return (nums.len()-i) as i32;
                }
            }
        }
        return -1;
    }
}
