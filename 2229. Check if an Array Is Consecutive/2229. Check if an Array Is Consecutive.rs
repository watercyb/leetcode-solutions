/*
 * Problem: 2229. Check if an Array Is Consecutive
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-an-array-is-consecutive/
 * Language: rust
 * Date: 2026-04-25
 */

impl Solution {
    pub fn is_consecutive(nums: Vec<i32>) -> bool {
        let mut min=100000;
        for &num in nums.iter() {
            min=min.min(num);
        }
        let mut seens=vec![false; nums.len()];
        for num in nums.iter() {
            let n=(num-min) as usize;
            if n>=seens.len()|| seens[n] {
                return false;
            } else {
                seens[n]=true;
            }
        }
        return true;
    }
}
