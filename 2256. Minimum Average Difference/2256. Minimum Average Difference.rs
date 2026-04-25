/*
 * Problem: 2256. Minimum Average Difference
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-average-difference/
 * Language: rust
 * Date: 2026-04-25
 */

impl Solution {
    pub fn minimum_average_difference(nums: Vec<i32>) -> i32 {
        let mut sums: Vec<i32>=Vec::new();
        let mut sum: i64=0;
        for i in 0..nums.len() {
            sum+=nums[i] as i64;
            sums.push((sum/((i+1) as i64)) as i32);
        }
        let mut res=sums.len()-1;
        let mut min=sums[sums.len()-1];
        sum=nums[nums.len()-1] as i64;
        for i in (0..nums.len()-1).rev() {
            let diff=(sums[i]-(sum/((nums.len()-i-1) as i64)) as i32).abs();
            if diff<=min {
                min=diff;
                res=i;
            }
            sum+=nums[i] as i64;
        }
        return res as i32;
    }
}
