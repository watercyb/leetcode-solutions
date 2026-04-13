/*
 * Problem: 1848. Minimum Distance to the Target Element
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-distance-to-the-target-element/?envType=daily-question&envId=2026-04-13
 * Language: rust
 * Date: 2026-04-13
 */

impl Solution {
    pub fn get_min_distance(nums: Vec<i32>, target: i32, start: i32) -> i32 {
        let mut len=0;
        loop {
            let l=start-len;
            let r=start+len;
            if (l>=0 && nums[l as usize]==target) || ((r as usize)<nums.len() && nums[r as usize]==target) {
                return len;
            }
            len+=1;
        }
    }
}
