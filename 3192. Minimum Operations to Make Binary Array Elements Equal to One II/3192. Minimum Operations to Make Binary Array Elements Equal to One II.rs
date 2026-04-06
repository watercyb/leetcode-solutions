/*
 * Problem: 3192. Minimum Operations to Make Binary Array Elements Equal to One II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/?envType=problem-list-v2&envId=array
 * Language: rust
 * Date: 2026-04-06
 */

impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        let mut zero=0;
        let mut one=0;
        for i in (0..nums.len()).rev() {
            if nums[i]==0 {
                one=zero+1;
            } else {
                zero=one+1;
            }
        }
        return one;
    }
}
