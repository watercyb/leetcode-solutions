/*
 * Problem: 2908. Minimum Sum of Mountain Triplets I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/
 * Language: rust
 * Date: 2026-05-02
 */

impl Solution {
    pub fn minimum_sum(nums: Vec<i32>) -> i32 {
        let mut lefts=Vec::new();
        let mut min=i32::MAX;
        for &num in &nums {
            lefts.push(min);
            if min>num {
                min=num;
            }
        }
        let mut res=i32::MAX;
        min=i32::MAX;
        for i in (0..nums.len()).rev() {
            if lefts[i]<nums[i]&&min<nums[i]&&lefts[i]+min+nums[i]<res {
                res=lefts[i]+min+nums[i];
            }
            if min>nums[i] {
                min=nums[i];
            }
        }
        if res==i32::MAX {
            return -1;
        }
        return res;
    }
}
